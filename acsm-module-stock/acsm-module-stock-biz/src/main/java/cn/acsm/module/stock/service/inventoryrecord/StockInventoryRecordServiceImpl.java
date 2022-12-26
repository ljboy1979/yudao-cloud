package cn.acsm.module.stock.service.inventoryrecord;

import cn.acsm.module.stock.controller.admin.inventoryrecord.vo.*;
import cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo.StockInventoryRecordDetailCreateReqVO;
import cn.acsm.module.stock.convert.inventoryrecord.StockInventoryRecordConvert;
import cn.acsm.module.stock.dal.dataobject.inventory.StockInventoryDO;
import cn.acsm.module.stock.dal.dataobject.inventoryrecord.StockInventoryRecordDO;
import cn.acsm.module.stock.dal.dataobject.recorddetail.StockRecordDetailDO;
import cn.acsm.module.stock.dal.mysql.inventory.StockInventoryMapper;
import cn.acsm.module.stock.dal.mysql.inventoryrecord.StockInventoryRecordMapper;
import cn.acsm.module.stock.dal.mysql.recorddetail.StockRecordDetailMapper;
import cn.acsm.module.stock.service.inventoryrecorddetail.StockInventoryRecordDetailService;
import cn.hutool.core.date.format.FastDateFormat;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.stock.enums.ErrorCodeConstants.INVENTORY_RECORD_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 盘点记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class StockInventoryRecordServiceImpl implements StockInventoryRecordService {

    @Resource
    private StockInventoryRecordMapper inventoryRecordMapper;

    @Resource
    private StockInventoryRecordDetailService detailService;

    @Resource
    private StockRecordDetailMapper detailMapper;

    @Resource
    private StockInventoryMapper inventoryMapper;

    @Override
    public Long createInventoryRecord(StockInventoryRecordCreateReqVO createReqVO) {
        // 生成盘点批次号
        createReqVO.setInventoryCode(getInventoryCode());

        // 插入盘点记录表
        StockInventoryRecordDO inventoryRecord = StockInventoryRecordConvert.INSTANCE.convert(createReqVO);
        inventoryRecordMapper.insert(inventoryRecord);

        // 插入盘点记录明细表
        StockInventoryRecordDetailCreateReqVO reqVO = new StockInventoryRecordDetailCreateReqVO();
        reqVO.setInventoryCode(createReqVO.getInventoryCode());
        BeanUtils.copyProperties(createReqVO, reqVO);
        detailService.createInventoryRecordDetail(reqVO);

        // 如果“盘点前数量”不等于“盘点后数量”
        if(createReqVO.getInventoryFrontQuantity() != createReqVO.getInventoryAfterQuantity()) {
            // 更新【库存记录表】：根据“库存记录明细id”更新“现有库存数量”字段=盘点明细中“盘点后数量”;
            UpdateWrapper wrapper = new UpdateWrapper();
            wrapper.eq("stock_record_detail_id", createReqVO.getStockRecordDetailId());

            StockRecordDetailDO detailDO = new StockRecordDetailDO();
            detailDO.setExistingInventory(createReqVO.getInventoryAfterQuantity());
            detailMapper.update(detailDO, wrapper);

            // 更新【库存清单表】：根据商品id规格id，更新“库存数量”=“库存数量”+“盘点后数量”-“盘点前数量”;
            // 获取库存数量
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("goods_id", createReqVO.getGoodsId());
            queryWrapper.eq("packaging_specification_id", createReqVO.getPackagingSpecificationId());
            StockInventoryDO one = inventoryMapper.selectOne(queryWrapper);

            // 更新库存清单表
            UpdateWrapper updateWrapper = new UpdateWrapper();
            updateWrapper.eq("goods_id", createReqVO.getGoodsId());
            updateWrapper.eq("packaging_specification_id", createReqVO.getPackagingSpecificationId());

            StockInventoryDO inventoryDO = new StockInventoryDO();
            inventoryDO.setInventoryQuantity(one.getInventoryQuantity() + createReqVO.getInventoryAfterQuantity() - createReqVO.getInventoryFrontQuantity());
            inventoryMapper.update(inventoryDO, updateWrapper);
        }


        // 返回
        return inventoryRecord.getId();
    }

    /**
     * 生成盘点批次号
     */
    private String getInventoryCode() {
        String prefix = "PDPC";
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByDesc("inventory_code");
        wrapper.last(" limit 1");
        StockInventoryRecordDO aDo = inventoryRecordMapper.selectOne(wrapper);
        String now = FastDateFormat.getInstance("yyyyMMdd").format(new Date());
        if(ObjectUtils.isNotEmpty(aDo) && StringUtils.equalsIgnoreCase(
                aDo.getInventoryCode().substring(4, 12), now)) {
            Integer newNumber = Integer.valueOf(aDo.getInventoryCode().substring(12)) + 1;
            if(newNumber.toString().length() == 1) {
                String number = prefix.concat(now).concat("0000".concat(newNumber+""));
                return number;
            }
            if(newNumber.toString().length() == 2) {
                String number = prefix.concat(now).concat("000".concat(newNumber + ""));
                return number;
            }
            if(newNumber.toString().length() == 3) {
                String number = prefix.concat(now).concat("00".concat(newNumber + ""));
                return number;
            }
            if(newNumber.toString().length() == 4) {
                String number = prefix.concat(now).concat("0".concat(newNumber + ""));
                return number;
            }
            if(newNumber.toString().length() == 5) {
                String number = prefix.concat(now).concat(newNumber + "");
                return number;
            }
        }
        return prefix.concat(now).concat("00001");
    }

    @CachePut(value = "inventoryRecord", key = "#updateReqVO.id")
    @Override
    public void updateInventoryRecord(StockInventoryRecordUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInventoryRecordExists(updateReqVO.getId());
        // 更新
        StockInventoryRecordDO updateObj = StockInventoryRecordConvert.INSTANCE.convert(updateReqVO);
        inventoryRecordMapper.updateById(updateObj);
    }

    @CacheEvict(value = "inventoryRecord", key = "#id")
    @Override
    public void deleteInventoryRecord(Long id) {
        // 校验存在
        this.validateInventoryRecordExists(id);
        // 删除
        inventoryRecordMapper.deleteById(id);
    }

    private void validateInventoryRecordExists(Long id) {
        if (inventoryRecordMapper.selectById(id) == null) {
            throw exception(INVENTORY_RECORD_NOT_EXISTS);
        }
    }

    @Cacheable(value = "inventoryRecord", key = "#id")
    @Override
    public StockInventoryRecordDO getInventoryRecord(Long id) {
        return inventoryRecordMapper.selectById(id);
    }

    @Cacheable(value = "inventoryRecord", key = "#ids")
    @Override
    public List<StockInventoryRecordDO> getInventoryRecordList(Collection<Long> ids) {
        return inventoryRecordMapper.selectBatchIds(ids);
    }

    @Cacheable(value = "inventoryRecord", key = "'getInventoryRecordPage'.concat(#pageReqVO.inventoryCode)")
    @Override
    public PageResult<StockInventoryRecordDO> getInventoryRecordPage(StockInventoryRecordPageReqVO pageReqVO) {
        return inventoryRecordMapper.selectPage(pageReqVO);
    }

    @Cacheable(value = "inventoryRecord", key = "'getInventoryRecordList'.concat(#pageReqVO.type).concat(#pageReqVO.inventoryCode)")
    @Override
    public List<StockInventoryRecordDO> getInventoryRecordList(StockInventoryRecordExportReqVO exportReqVO) {
        return inventoryRecordMapper.selectList(exportReqVO);
    }

    /**
     * 3.7.2.16.查询盘点记录
     *
     * @param pageReqVO 分页查询
     * @return 盘点记录分页
     */
    public Page<StockInventoryRecordDO> getInventoryRecordPage(StockInventoryRecordPageVO pageReqVO) {
        Page<StockInventoryRecordDO> page = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like(StringUtils.isNotBlank(pageReqVO.getHeadName()), "head_name", pageReqVO.getHeadName());
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getType()), "type", pageReqVO.getType());
        wrapper.like(StringUtils.isNotBlank(pageReqVO.getWarehouseName()), "warehouse_name", pageReqVO.getWarehouseName());
        wrapper.eq(StringUtils.isNotBlank(pageReqVO.getInventoryCode()), "inventory_code", pageReqVO.getInventoryCode());
        wrapper.gt(ObjectUtils.isNotEmpty(pageReqVO.getOperationStartTime()), "operation_time", pageReqVO.getOperationStartTime());
        wrapper.lt(ObjectUtils.isNotEmpty(pageReqVO.getOperationEndTime()), "operation_time", pageReqVO.getOperationEndTime());
        return inventoryRecordMapper.selectPage(page, wrapper);
    }

}
