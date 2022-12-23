package cn.acsm.module.stock.service.inventoryrecorddetail;

import cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo.*;
import cn.acsm.module.stock.convert.inventoryrecorddetail.StockInventoryRecordDetailConvert;
import cn.acsm.module.stock.dal.dataobject.inventoryrecorddetail.StockInventoryRecordDetailDO;
import cn.acsm.module.stock.dal.mysql.inventoryrecorddetail.StockInventoryRecordDetailMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

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
        StockInventoryRecordDetailDO inventoryRecordDetail = StockInventoryRecordDetailConvert.INSTANCE.convert(createReqVO);
        inventoryRecordDetailMapper.insert(inventoryRecordDetail);
        // 返回
        return inventoryRecordDetail.getId();
    }

    @Override
    public void updateInventoryRecordDetail(StockInventoryRecordDetailUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInventoryRecordDetailExists(updateReqVO.getId());
        // 更新
        StockInventoryRecordDetailDO updateObj = StockInventoryRecordDetailConvert.INSTANCE.convert(updateReqVO);
        inventoryRecordDetailMapper.updateById(updateObj);
    }

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

    @Override
    public StockInventoryRecordDetailDO getInventoryRecordDetail(Long id) {
        return inventoryRecordDetailMapper.selectById(id);
    }

    @Override
    public List<StockInventoryRecordDetailDO> getInventoryRecordDetailList(Collection<Long> ids) {
        return inventoryRecordDetailMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<StockInventoryRecordDetailDO> getInventoryRecordDetailPage(StockInventoryRecordDetailPageReqVO pageReqVO) {
        return inventoryRecordDetailMapper.selectPage(pageReqVO);
    }

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
