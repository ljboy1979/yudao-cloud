package cn.acsm.module.stock.service.inventoryrecorddetail;

import cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo.*;
import cn.acsm.module.stock.convert.inventoryrecorddetail.StockInventoryRecordDetailConvert;
import cn.acsm.module.stock.dal.dataobject.inventoryrecorddetail.StockInventoryRecordDetailDO;
import cn.acsm.module.stock.dal.mysql.inventoryrecorddetail.StockInventoryRecordDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import java.util.List;
import java.util.stream.Collectors;

import static cn.acsm.module.stock.enums.ErrorCodeConstants.INVENTORY_RECORD_DETAIL_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 盘点记录表子表-明细 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class StockInventoryRecordDetailServiceImpl implements StockInventoryRecordDetailService {

    @Resource
    private StockInventoryRecordDetailMapper inventoryRecordDetailMapper;

    @Override
    public Long createInventoryRecordDetail(StockInventoryRecordDetailCreateReqVO createReqVO) {
        // 插入
        StockInventoryRecordDetailDO inventoryRecordDetail = new StockInventoryRecordDetailDO();// ;StockInventoryRecordDetailConvert.INSTANCE.convert(createReqVO);
        BeanUtils.copyProperties(createReqVO, inventoryRecordDetail);
        inventoryRecordDetail.setStockRecordDetailId(createReqVO.getStockRecordDetailId());
        inventoryRecordDetailMapper.insert(inventoryRecordDetail);
        // 返回
        return inventoryRecordDetail.getId();
    }

    @CachePut(value = "inventoryRecordDetail", key = "#updateReqVO.id")
    @Override
    public void updateInventoryRecordDetail(StockInventoryRecordDetailUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInventoryRecordDetailExists(updateReqVO.getId());
        // 更新
        StockInventoryRecordDetailDO updateObj = StockInventoryRecordDetailConvert.INSTANCE.convert(updateReqVO);
        inventoryRecordDetailMapper.updateById(updateObj);
    }

    @CacheEvict(value = "inventoryRecordDetail", key = "#updateReqVO.id")
    @Override
    public void deleteInventoryRecordDetail(Long id) {
        // 校验存在
        this.validateInventoryRecordDetailExists(id);
        // 删除
        inventoryRecordDetailMapper.deleteById(id);
    }

    private void validateInventoryRecordDetailExists(Long id) {
        if (inventoryRecordDetailMapper.selectById(id) == null) {
            throw exception(INVENTORY_RECORD_DETAIL_NOT_EXISTS);
        }
    }

    @Cacheable(value = "inventoryRecordDetail", key = "#id")
    @Override
    public StockInventoryRecordDetailDO getInventoryRecordDetail(Long id) {
        return inventoryRecordDetailMapper.selectById(id);
    }

    @Cacheable(value = "inventoryRecordDetail", key = "#ids")
    @Override
    public List<StockInventoryRecordDetailDO> getInventoryRecordDetailList(Collection<Long> ids) {
        return inventoryRecordDetailMapper.selectBatchIds(ids);
    }

//    @Cacheable(value = "inventoryRecordDetail", key = "'getInventoryRecordDetailPage'.concat('-').concat(#pageReqVO.stockRecordId).concat('-').concat(#pageReqVO.stockRecordDetailId)")
    @Override
    public Page<StockInventoryRecordDetailRespVO> getInventoryRecordDetailPage(StockInventoryRecordDetailPageReqVO pageReqVO) {
        Page<StockInventoryRecordDetailDO> page = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq(StringUtils.isNotBlank(pageReqVO.getInventoryCode()), "inventory_code", pageReqVO.getInventoryCode());
        wrapper.like(StringUtils.isNotBlank(pageReqVO.getGoodsName()), "goods_name",pageReqVO.getGoodsName());
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getGoodsType()), "goods_type", pageReqVO.getGoodsType());
        wrapper.orderByDesc("create_time");
        Page<StockInventoryRecordDetailDO> page1 = inventoryRecordDetailMapper.selectPage(page, wrapper);
        List<StockInventoryRecordDetailRespVO> respVOS = page1.getRecords().stream().map(s -> {
            StockInventoryRecordDetailRespVO respVO = new StockInventoryRecordDetailRespVO();
            BeanUtils.copyProperties(s, respVO);
            return respVO;
        }).collect(Collectors.toList());
        Page<StockInventoryRecordDetailRespVO> voPage = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        voPage.setRecords(respVOS);
        voPage.setTotal(page1.getTotal());
        return voPage;
    }

    @Cacheable(value = "inventoryRecordDetail", key = "'getInventoryRecordDetailList'.concat('-').concat(#pageReqVO.stockRecordId).concat('-').concat(#pageReqVO.stockRecordDetailId)")
    @Override
    public List<StockInventoryRecordDetailDO> getInventoryRecordDetailList(StockInventoryRecordDetailExportReqVO exportReqVO) {
        return inventoryRecordDetailMapper.selectList(exportReqVO);
    }

    /**
     * 3.7.2.17.根据盘点记录id或批次号查询盘点明细
     *
     * @param pageReqVO 分页查询
     * @return 盘点记录表子表-明细分页
     */
    @Cacheable(value = "inventoryRecordDetail", key = "'getInventoryRecordDetailPage'.concat('-').concat(#pageReqVO.inventoryRecordId).concat('-').concat(#pageReqVO.inventoryCode)")
    @Override
    public Page<StockInventoryRecordDetailDO> getInventoryRecordDetailPage(StockInventoryRecordDetailPageVO pageReqVO) {
        Page<StockInventoryRecordDetailDO> page = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("inventory_record_id", pageReqVO.getInventoryRecordId());
        wrapper.eq("inventory_code", pageReqVO.getInventoryCode());
        wrapper.like(StringUtils.isNotBlank(pageReqVO.getGoodsName()), pageReqVO.getGoodsName());
        wrapper.eq(ObjectUtils.isNotEmpty(pageReqVO.getGoodsType()), pageReqVO.getGoodsType());
        return inventoryRecordDetailMapper.selectPage(page, wrapper);
    }

}
