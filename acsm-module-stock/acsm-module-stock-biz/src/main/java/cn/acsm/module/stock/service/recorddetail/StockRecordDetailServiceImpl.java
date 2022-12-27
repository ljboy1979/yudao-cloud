package cn.acsm.module.stock.service.recorddetail;

import cn.acsm.module.stock.controller.admin.recorddetail.vo.*;
import cn.acsm.module.stock.convert.recorddetail.StockRecordDetailConvert;
import cn.acsm.module.stock.dal.dataobject.recorddetail.StockRecordDetailDO;
import cn.acsm.module.stock.dal.mysql.recorddetail.StockRecordDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.stock.enums.ErrorCodeConstants.RECORD_DETAIL_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 库存记录字表-明细 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class StockRecordDetailServiceImpl implements StockRecordDetailService {

    @Resource
    private StockRecordDetailMapper recordDetailMapper;

    @Override
    public Long createRecordDetail(StockRecordDetailCreateReqVO createReqVO) {
        // 插入
        StockRecordDetailDO recordDetail = StockRecordDetailConvert.INSTANCE.convert(createReqVO);
        recordDetailMapper.insert(recordDetail);
        // 返回
        return recordDetail.getId();
    }

    @CachePut(value = "stockRecordDetail", key = "#updateReqVO.id")
    @Override
    public void updateRecordDetail(StockRecordDetailUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateRecordDetailExists(updateReqVO.getId());
        // 更新
        StockRecordDetailDO updateObj = StockRecordDetailConvert.INSTANCE.convert(updateReqVO);
        recordDetailMapper.updateById(updateObj);
    }

    @CacheEvict(value = "stockRecordDetail", key = "#id")
    @Override
    public void deleteRecordDetail(Long id) {
        // 校验存在
        this.validateRecordDetailExists(id);
        // 删除
        recordDetailMapper.deleteById(id);
    }

    private void validateRecordDetailExists(Long id) {
        if (recordDetailMapper.selectById(id) == null) {
            throw exception(RECORD_DETAIL_NOT_EXISTS);
        }
    }

    @Cacheable(value = "stockRecord", key = "#id")
    @Override
    public StockRecordDetailDO getRecordDetail(Long id) {
        return recordDetailMapper.selectById(id);
    }

    @Override
    public List<StockRecordDetailDO> getRecordDetailList(Collection<Long> ids) {
        return recordDetailMapper.selectBatchIds(ids);
    }

    /**
     * 3.7.2.11.获取入库货品及现有库存量
     * @param pageReqVO 分页查询
     * @return
     */
    @Cacheable(value = "stockRecord", key = "'getRecordDetailPage'.concat('-').concat(#pageReqVO.goodsType)" +
            ".concat('-').concat(#pageReqVO.stockBatchNo).concat('-').concat(#pageReqVO.goodsName)")
    @Override
    public Page<StockRecordDetailDO> getRecordDetailPage(StockRecordDetailPageReqVO pageReqVO) {
        Page<StockRecordDetailDO> page = new Page(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("goods_type", pageReqVO.getGoodsType());
        wrapper.eq("stock_batch_no", pageReqVO.getStockBatchNo());
        wrapper.eq("goods_name", pageReqVO.getGoodsName());
        // 现有库存数量大于0
        wrapper.gt("existing_inventory", 0);
        wrapper.orderByAsc("create_time");
        return recordDetailMapper.selectPage(page, wrapper);
    }

    @Cacheable(value = "stockRecord", key = "'getRecordDetailList'.concat('-').concat(#exportReqVO.operationType)" +
            ".concat('-').concat(#exportReqVO.stockBatchNo)")
    @Override
    public List<StockRecordDetailDO> getRecordDetailList(StockRecordDetailExportReqVO exportReqVO) {
        return recordDetailMapper.selectList(exportReqVO);
    }

    /**
     * 3.7.2.13.修改出/入库记录
     *
     * @param updateReqVO 更新信息
     */
    @CachePut(value = "stockRecord", key = "#updateReqVO.id")
    @Override
    public void updateRecordDetailOutEnter(@Valid StockRecordDetailOutEnterVO updateReqVO) {
        // 查询当前记录是出库还是入库
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", updateReqVO.getId());
        StockRecordDetailDO detailDO = recordDetailMapper.selectOne(wrapper);

        // 修改条件
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("id", updateReqVO.getId());

        // 修改数据
        StockRecordDetailDO recordDetailDO = new StockRecordDetailDO();
        BeanUtils.copyProperties(updateReqVO, recordDetailDO);
        if(detailDO.getOperationType() == false) { // 入库
            recordDetailDO.setReceiptQuantity(updateReqVO.getQuantity());
            recordDetailMapper.update(recordDetailDO, updateWrapper);
        } else if(detailDO.getOperationType() == true) { // 出库
            recordDetailDO.setDeliveryQuantity(updateReqVO.getQuantity());
            recordDetailMapper.update(recordDetailDO, updateWrapper);
        }
    }

    /**
     * 3.7.2.15.根据出入库id或批次号查询出入库明细
     * @param pageReqVO 分页查询
     * @return
     */
    @Cacheable(value = "stockRecord", key = "'getRecordDetailPage'.concat('-').concat(#pageReqVO.stockBatchNo)" +
            ".concat('-').concat(#pageReqVO.operationType).concat('-').concat(#pageReqVO.goodsType)")
    @Override
    public Page<StockRecordDetailDO> getRecordDetailPage(StockRecordDetailPageVO pageReqVO) {
        Page<StockRecordDetailDO> page = new Page(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("stock_batch_no", pageReqVO.getStockBatchNo());
        wrapper.like(StringUtils.isNotBlank(pageReqVO.getGoodsName()), "goods_name", pageReqVO.getGoodsName());
        wrapper.eq("goods_type", pageReqVO.getGoodsType());
        wrapper.eq("operation_type", pageReqVO.getOperationType());
        wrapper.orderByAsc("create_time");
        return recordDetailMapper.selectPage(page, wrapper);
    }

    /**
     * 3.7.2.20.临期时间管理
     * @param pageReqVO 分页查询
     * @return
     */
    @Cacheable(value = "stockRecord", key = "'getRecordDetailPage'.concat('-').concat(#pageReqVO.maxOrmin)" +
            ".concat('-').concat(#pageReqVO.pageNo).concat('-').concat(#pageReqVO.pageSize)")
    @Override
    public Page<StockRecordDetailDO> getRecordDetailPage(StockRecordTempPageVO pageReqVO) {
        Page<StockRecordDetailDO> page = new Page(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        QueryWrapper wrapper = new QueryWrapper();
        if(pageReqVO.getMaxOrmin() > 0) {
            wrapper.lt("temporary_time", new Date());
            wrapper.orderByDesc("temporary_time");
        } else {
            wrapper.gt("temporary_time", new Date());
            wrapper.orderByAsc("temporary_time");
        }
        return recordDetailMapper.selectPage(page, wrapper);
    }
}
