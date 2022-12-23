package cn.acsm.module.stock.dal.mysql.recorddetail;

import cn.acsm.module.stock.controller.admin.recorddetail.vo.StockRecordDetailExportReqVO;
import cn.acsm.module.stock.controller.admin.recorddetail.vo.StockRecordDetailPageReqVO;
import cn.acsm.module.stock.dal.dataobject.recorddetail.StockRecordDetailDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 库存记录字表-明细 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface StockRecordDetailMapper extends BaseMapperX<StockRecordDetailDO> {

    default PageResult<StockRecordDetailDO> selectPage(StockRecordDetailPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<StockRecordDetailDO>()
                .eqIfPresent(StockRecordDetailDO::getRecordId, reqVO.getRecordId())
                .eqIfPresent(StockRecordDetailDO::getStockBatchNo, reqVO.getStockBatchNo())
                .eqIfPresent(StockRecordDetailDO::getOperationType, reqVO.getOperationType())
                .eqIfPresent(StockRecordDetailDO::getSecondaryClassification, reqVO.getSecondaryClassification())
                .eqIfPresent(StockRecordDetailDO::getGoodsId, reqVO.getGoodsId())
                .eqIfPresent(StockRecordDetailDO::getGoodsNumber, reqVO.getGoodsNumber())
                .likeIfPresent(StockRecordDetailDO::getGoodsName, reqVO.getGoodsName())
                .eqIfPresent(StockRecordDetailDO::getGoodsType, reqVO.getGoodsType())
                .eqIfPresent(StockRecordDetailDO::getPackagingType, reqVO.getPackagingType())
                .eqIfPresent(StockRecordDetailDO::getPackingSpecification, reqVO.getPackingSpecification())
                .eqIfPresent(StockRecordDetailDO::getReceiptQuantity, reqVO.getReceiptQuantity())
                .eqIfPresent(StockRecordDetailDO::getExistingInventory, reqVO.getExistingInventory())
                .eqIfPresent(StockRecordDetailDO::getDeliveryQuantity, reqVO.getDeliveryQuantity())
                .eqIfPresent(StockRecordDetailDO::getRecordDetailId, reqVO.getRecordDetailId())
                .eqIfPresent(StockRecordDetailDO::getGoodsAllocationId, reqVO.getGoodsAllocationId())
                .eqIfPresent(StockRecordDetailDO::getGoodsAllocationNo, reqVO.getGoodsAllocationNo())
                .eqIfPresent(StockRecordDetailDO::getSourceTo, reqVO.getSourceTo())
                .eqIfPresent(StockRecordDetailDO::getUnitPrice, reqVO.getUnitPrice())
                .eqIfPresent(StockRecordDetailDO::getUnit, reqVO.getUnit())
                .eqIfPresent(StockRecordDetailDO::getTotalPrice, reqVO.getTotalPrice())
                .eqIfPresent(StockRecordDetailDO::getPayMethod, reqVO.getPayMethod())
                .eqIfPresent(StockRecordDetailDO::getProductionBatchNo, reqVO.getProductionBatchNo())
                .eqIfPresent(StockRecordDetailDO::getBases, reqVO.getBases())
                .eqIfPresent(StockRecordDetailDO::getTunnel, reqVO.getTunnel())
                .eqIfPresent(StockRecordDetailDO::getTreasurySource, reqVO.getTreasurySource())
                .eqIfPresent(StockRecordDetailDO::getHarvestBatchId, reqVO.getHarvestBatchId())
                .eqIfPresent(StockRecordDetailDO::getPurchaseId, reqVO.getPurchaseId())
                .eqIfPresent(StockRecordDetailDO::getPurchaseNumber, reqVO.getPurchaseNumber())
                .eqIfPresent(StockRecordDetailDO::getProcessingOrderId, reqVO.getProcessingOrderId())
                .eqIfPresent(StockRecordDetailDO::getWeighingRecordId, reqVO.getWeighingRecordId())
                .eqIfPresent(StockRecordDetailDO::getPackingListId, reqVO.getPackingListId())
                .betweenIfPresent(StockRecordDetailDO::getTemporaryTime, reqVO.getTemporaryTime())
                .eqIfPresent(StockRecordDetailDO::getEnvironmentalRequirements, reqVO.getEnvironmentalRequirements())
                .betweenIfPresent(StockRecordDetailDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(StockRecordDetailDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(StockRecordDetailDO::getUserId, reqVO.getUserId())
                .eqIfPresent(StockRecordDetailDO::getSourceId, reqVO.getSourceId())
                .orderByDesc(StockRecordDetailDO::getId));
    }

    default List<StockRecordDetailDO> selectList(StockRecordDetailExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<StockRecordDetailDO>()
                .eqIfPresent(StockRecordDetailDO::getRecordId, reqVO.getRecordId())
                .eqIfPresent(StockRecordDetailDO::getStockBatchNo, reqVO.getStockBatchNo())
                .eqIfPresent(StockRecordDetailDO::getOperationType, reqVO.getOperationType())
                .eqIfPresent(StockRecordDetailDO::getSecondaryClassification, reqVO.getSecondaryClassification())
                .eqIfPresent(StockRecordDetailDO::getGoodsId, reqVO.getGoodsId())
                .eqIfPresent(StockRecordDetailDO::getGoodsNumber, reqVO.getGoodsNumber())
                .likeIfPresent(StockRecordDetailDO::getGoodsName, reqVO.getGoodsName())
                .eqIfPresent(StockRecordDetailDO::getGoodsType, reqVO.getGoodsType())
                .eqIfPresent(StockRecordDetailDO::getPackagingType, reqVO.getPackagingType())
                .eqIfPresent(StockRecordDetailDO::getPackingSpecification, reqVO.getPackingSpecification())
                .eqIfPresent(StockRecordDetailDO::getReceiptQuantity, reqVO.getReceiptQuantity())
                .eqIfPresent(StockRecordDetailDO::getExistingInventory, reqVO.getExistingInventory())
                .eqIfPresent(StockRecordDetailDO::getDeliveryQuantity, reqVO.getDeliveryQuantity())
                .eqIfPresent(StockRecordDetailDO::getRecordDetailId, reqVO.getRecordDetailId())
                .eqIfPresent(StockRecordDetailDO::getGoodsAllocationId, reqVO.getGoodsAllocationId())
                .eqIfPresent(StockRecordDetailDO::getGoodsAllocationNo, reqVO.getGoodsAllocationNo())
                .eqIfPresent(StockRecordDetailDO::getSourceTo, reqVO.getSourceTo())
                .eqIfPresent(StockRecordDetailDO::getUnitPrice, reqVO.getUnitPrice())
                .eqIfPresent(StockRecordDetailDO::getUnit, reqVO.getUnit())
                .eqIfPresent(StockRecordDetailDO::getTotalPrice, reqVO.getTotalPrice())
                .eqIfPresent(StockRecordDetailDO::getPayMethod, reqVO.getPayMethod())
                .eqIfPresent(StockRecordDetailDO::getProductionBatchNo, reqVO.getProductionBatchNo())
                .eqIfPresent(StockRecordDetailDO::getBases, reqVO.getBases())
                .eqIfPresent(StockRecordDetailDO::getTunnel, reqVO.getTunnel())
                .eqIfPresent(StockRecordDetailDO::getTreasurySource, reqVO.getTreasurySource())
                .eqIfPresent(StockRecordDetailDO::getHarvestBatchId, reqVO.getHarvestBatchId())
                .eqIfPresent(StockRecordDetailDO::getPurchaseId, reqVO.getPurchaseId())
                .eqIfPresent(StockRecordDetailDO::getPurchaseNumber, reqVO.getPurchaseNumber())
                .eqIfPresent(StockRecordDetailDO::getProcessingOrderId, reqVO.getProcessingOrderId())
                .eqIfPresent(StockRecordDetailDO::getWeighingRecordId, reqVO.getWeighingRecordId())
                .eqIfPresent(StockRecordDetailDO::getPackingListId, reqVO.getPackingListId())
                .betweenIfPresent(StockRecordDetailDO::getTemporaryTime, reqVO.getTemporaryTime())
                .eqIfPresent(StockRecordDetailDO::getEnvironmentalRequirements, reqVO.getEnvironmentalRequirements())
                .betweenIfPresent(StockRecordDetailDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(StockRecordDetailDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(StockRecordDetailDO::getUserId, reqVO.getUserId())
                .eqIfPresent(StockRecordDetailDO::getSourceId, reqVO.getSourceId())
                .orderByDesc(StockRecordDetailDO::getId));
    }

}
