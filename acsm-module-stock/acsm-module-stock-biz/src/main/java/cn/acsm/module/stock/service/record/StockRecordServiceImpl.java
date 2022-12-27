package cn.acsm.module.stock.service.record;

import cn.acsm.module.stock.controller.admin.inventory.vo.StockInventoryUpdateCountVO;
import cn.acsm.module.stock.controller.admin.record.vo.*;
import cn.acsm.module.stock.convert.record.StockRecordConvert;
import cn.acsm.module.stock.dal.dataobject.inventory.StockInventoryDO;
import cn.acsm.module.stock.dal.dataobject.record.StockRecordDO;
import cn.acsm.module.stock.dal.dataobject.recorddetail.StockRecordDetailDO;
import cn.acsm.module.stock.dal.mysql.inventory.StockInventoryMapper;
import cn.acsm.module.stock.dal.mysql.record.StockRecordMapper;
import cn.acsm.module.stock.dal.mysql.recorddetail.StockRecordDetailMapper;
import cn.acsm.module.stock.service.inventory.StockInventoryService;
import cn.hutool.core.date.format.FastDateFormat;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static cn.acsm.module.stock.enums.ErrorCodeConstants.RECORD_DETAIL_EXISTS;
import static cn.acsm.module.stock.enums.ErrorCodeConstants.RECORD_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 库存记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
@Transactional(rollbackFor = Exception.class)
public class StockRecordServiceImpl implements StockRecordService {

    @Resource
    private StockRecordMapper recordMapper;

    @Resource
    private StockRecordDetailMapper detailMapper;

    @Resource
    private StockInventoryService inventoryService;

    @Resource
    private StockInventoryMapper inventoryMapper;

    @Override
    public Long createRecordWarehousing(StockRecordCreateReqVO createReqVO) {
        // 插入库存记录信息
        // 生成入库批次号
        String batchNo = getBatchNo();
        createReqVO.setOperationType(false);
        createReqVO.setBatchNo(batchNo);
        StockRecordDO record = StockRecordConvert.INSTANCE.convert(createReqVO);
        recordMapper.insert(record);

        // 获取新增入库数据的id
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("batch_no", batchNo);
        StockRecordDO stockRecordDO = recordMapper.selectOne(wrapper);
        // 插入子表-库存记录明细表
        StockRecordDetailDO detailDO = new StockRecordDetailDO();
        detailDO.setOperationType(false);
        detailDO.setRecordId(stockRecordDO.getId());
        detailDO.setStockBatchNo(batchNo);
        detailDO.setGoodsId(createReqVO.getGoodsId());
        detailDO.setGoodsName(createReqVO.getGoodsName());
        detailDO.setPackingSpecification(createReqVO.getPackingSpecification());
        detailDO.setReceiptQuantity(createReqVO.getReceiptQuantity());
        detailDO.setExistingInventory(createReqVO.getExistingInventory());
        detailDO.setUnitPrice(createReqVO.getUnitPrice());
        detailDO.setUnit(createReqVO.getUnit());
        detailDO.setTotalPrice(createReqVO.getTotalPrice());
        detailDO.setProductionBatchNo(createReqVO.getProductionBatchNo());
        detailDO.setTreasurySource(createReqVO.getTreasurySource());
        detailDO.setPurchaseId(createReqVO.getPurchaseId());
        detailDO.setPurchaseNumber(createReqVO.getPurchaseNumber());
        detailMapper.insert(detailDO);

        // 更新库存清单
        StockInventoryUpdateCountVO updateCountVO = new StockInventoryUpdateCountVO();
        updateCountVO.setGoodsId(createReqVO.getGoodsId());
        updateCountVO.setPackingSpecification(createReqVO.getPackingSpecification());
        updateCountVO.setWarehouseId(createReqVO.getWarehouseId());
        updateCountVO.setInventoryQuantity(createReqVO.getReceiptQuantity());
        inventoryService.updateInventoryCount(updateCountVO);
        // 返回
        return record.getId();
    }

    @Override
    public Long createRecordIssue(StockRecordCreateReqVO createReqVO) {
        // 插入库存记录信息
        // 生成出库批次号
        String batchNo = getBatchNo();
        createReqVO.setOperationType(true);
        createReqVO.setBatchNo(batchNo);
        StockRecordDO record = StockRecordConvert.INSTANCE.convert(createReqVO);
        recordMapper.insert(record);

        // 获取新增出库数据的id
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("batch_no", batchNo);
        StockRecordDO stockRecordDO = recordMapper.selectOne(wrapper);
        // 插入子表-库存记录明细表
        StockRecordDetailDO detailDO = new StockRecordDetailDO();
        detailDO.setRecordDetailId(createReqVO.getRecordDetailId());
        detailDO.setOperationType(true);
        detailDO.setRecordId(stockRecordDO.getId());
        detailDO.setStockBatchNo(batchNo);
        detailDO.setGoodsId(createReqVO.getGoodsId());
        detailDO.setGoodsName(createReqVO.getGoodsName());
        detailDO.setPackingSpecification(createReqVO.getPackingSpecification());
        detailDO.setDeliveryQuantity(createReqVO.getDeliveryQuantity());
        detailDO.setUnitPrice(createReqVO.getUnitPrice());
        detailDO.setUnit(createReqVO.getUnit());
        detailDO.setTotalPrice(createReqVO.getTotalPrice());
        detailDO.setProductionBatchNo(createReqVO.getProductionBatchNo());
        detailDO.setPurchaseId(createReqVO.getPurchaseId());
        detailDO.setPurchaseNumber(createReqVO.getPurchaseNumber());
        detailMapper.insert(detailDO);

        // 根据库存明细id获取入库数据的现有库存数量
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("warehouse_id", createReqVO.getWarehouseId());
        queryWrapper.eq("goods_id", createReqVO.getGoodsId());
        queryWrapper.eq("packing_specification", createReqVO.getPackingSpecification());
        StockRecordDetailDO detailDO2 = detailMapper.selectOne(queryWrapper);

        // 根据库存明细id更新入库数据的现有库存数量
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("warehouse_id", createReqVO.getWarehouseId());
        updateWrapper.eq("goods_id", createReqVO.getGoodsId());
        updateWrapper.eq(StringUtils.isNotBlank(createReqVO.getPackingSpecification()), "packing_specification", createReqVO.getPackingSpecification());

        StockRecordDetailDO detailDO1 = new StockRecordDetailDO();
        detailDO1.setExistingInventory(detailDO2.getExistingInventory() - createReqVO.getReceiptQuantity());
        detailMapper.update(detailDO1, updateWrapper);

        // 更新库存清单
        StockInventoryUpdateCountVO updateCountVO = new StockInventoryUpdateCountVO();
        updateCountVO.setGoodsId(createReqVO.getGoodsId());
        updateCountVO.setPackingSpecification(createReqVO.getPackingSpecification());
        updateCountVO.setWarehouseId(createReqVO.getWarehouseId());
        // 减去当前出库数量
        updateCountVO.setInventoryQuantity(-createReqVO.getReceiptQuantity());
        inventoryService.updateInventoryCount(updateCountVO);
        // 返回
        return record.getId();
    }

    /**
     * 生成入库批次号
     */
    private String getBatchNo() {
        String prefix = "RKPC";
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByDesc("batch_no");
        wrapper.last(" limit 1");
        StockRecordDO aDo = recordMapper.selectOne(wrapper);
        String now = FastDateFormat.getInstance("yyyyMMdd").format(new Date());
        if(ObjectUtils.isNotEmpty(aDo) && StringUtils.equalsIgnoreCase(
                aDo.getBatchNo().substring(4, 12), now)) {
            Integer newNumber = Integer.valueOf(aDo.getBatchNo().substring(12)) + 1;
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

    @CachePut(value = "stockRecord", key = "#updateReqVO.id")
    @Override
    public void updateRecord(StockRecordUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateRecordExists(updateReqVO.getId());
        // 更新
        StockRecordDO updateObj = StockRecordConvert.INSTANCE.convert(updateReqVO);
        recordMapper.updateById(updateObj);
    }

    /**
     * 3.7.2.18.删除入库记录单
     * @param id 编号
     */
    @CacheEvict(value = "stockRecord", key = "#id")
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void deleteRecord(Long id) {
        // 校验存在
        this.validateRecordExists(id);
        // 先判断要删除的记录是否有出库记录，如果有，提示”已有出库记录，不可删除“；如果没有执行2、3、4
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", id);
        List<StockRecordDetailDO> list = detailMapper.selectList(wrapper);
        // 查看是否有对应出库记录
        List<StockRecordDetailDO> collect = list.stream().filter(detil -> detil.getOperationType() == true).collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(collect)) {
            exception(RECORD_DETAIL_EXISTS);
        }
        // 获取入库的总数量
        Integer sum = list.stream().map(s -> s.getReceiptQuantity()).mapToInt(Integer::intValue).sum();

        // 逻辑删除明细数据
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("record_id", id);
        StockRecordDetailDO detailDO = new StockRecordDetailDO();
        detailDO.setDeleted(true);
        detailMapper.update(detailDO, updateWrapper);

        // 逻辑删除库存
        recordMapper.deleteById(id);

        // 获取仓库id
        StockRecordDO stockRecordDO = recordMapper.selectOne(wrapper);

        // 调用更新库存量方法（货品id、规格id、仓库id、-数量）
        QueryWrapper inventoryQueryWrapper = new QueryWrapper();
        inventoryQueryWrapper.eq("goods_id", detailDO.getGoodsId());
        inventoryQueryWrapper.eq("packing_specification", detailDO.getPackingSpecification());
        inventoryQueryWrapper.eq("warehouse_id", stockRecordDO.getWarehouseId());
        StockInventoryDO inventoryDO1 = inventoryMapper.selectOne(inventoryQueryWrapper);

        UpdateWrapper inventoryWrapper = new UpdateWrapper();
        inventoryWrapper.eq("goods_id", detailDO.getGoodsId());
        inventoryWrapper.eq("packing_specification", detailDO.getPackingSpecification());
        inventoryWrapper.eq("warehouse_id", stockRecordDO.getWarehouseId());

        StockInventoryDO inventoryDO = new StockInventoryDO();
        inventoryDO.setInventoryQuantity(inventoryDO1.getInventoryQuantity() - sum);
        inventoryMapper.update(inventoryDO, inventoryWrapper);
    }

    private void validateRecordExists(Long id) {
        if (recordMapper.selectById(id) == null) {
            throw exception(RECORD_NOT_EXISTS);
        }
    }

    @Cacheable(value = "stockRecord", key = "#id")
    @Override
    public StockRecordDO getRecord(Long id) {
        return recordMapper.selectById(id);
    }

    @Cacheable(value = "stockRecord", key = "#ids")
    @Override
    public List<StockRecordDO> getRecordList(Collection<Long> ids) {
        return recordMapper.selectBatchIds(ids);
    }

    @Cacheable(value = "stockRecord", key = "'getRecordPage'.concat('-')" +
            ".concat(#pageReqVO.type).concat('-').concat(#pageReqVO.operationType)" +
            ".concat('-').concat(#pageReqVO.batchNo)")
    @Override
    public PageResult<StockRecordDO> getRecordPage(StockRecordPageReqVO pageReqVO) {
        return recordMapper.selectPage(pageReqVO);
    }

    @Cacheable(value = "stockRecord", key = "'getRecordList'.concat('-')" +
            ".concat(#exportReqVO.type).concat('-').concat(#exportReqVO.operationType)" +
            ".concat('-').concat(#exportReqVO.batchNo)")
    @Override
    public List<StockRecordDO> getRecordList(StockRecordExportReqVO exportReqVO) {
        return recordMapper.selectList(exportReqVO);
    }

    /**
     * 3.7.2.14.查询出/入库记录
     *
     * @param pageReqVO 分页查询
     * @return 库存记录分页
     */
    @Cacheable(value = "stockRecord", key = "'getRecordOutEnterPage'.concat('-')" +
            ".concat(#pageReqVO.type).concat('-').concat(#pageReqVO.batchNo)")
    @Override
    public Page<StockRecordDO> getRecordOutEnterPage(StockRecordOutEnterVO pageReqVO) {
        Page<StockRecordDO> page = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq(StringUtils.isNotBlank(pageReqVO.getHeadName()), "head_name", pageReqVO.getHeadName());
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getType()), "type", pageReqVO.getType());
        wrapper.eq(StringUtils.isNotBlank(pageReqVO.getWarehouseName()), "warehouse_name", pageReqVO.getWarehouseName());
        wrapper.eq(StringUtils.isNotBlank(pageReqVO.getBatchNo()), "batch_no", pageReqVO.getBatchNo());
        wrapper.gt(ObjectUtils.isNotEmpty(pageReqVO.getOperationStartTime()), "operation_time", pageReqVO.getOperationStartTime());
        wrapper.lt(ObjectUtils.isNotEmpty(pageReqVO.getOperationEndTime()), "operation_time", pageReqVO.getOperationEndTime());
        wrapper.orderByDesc("create_time");
        return recordMapper.selectPage(page, wrapper);
    }

}
