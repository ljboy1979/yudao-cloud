package cn.acsm.module.stock.dal.mysql.inventoryrecorddetail;

import cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo.StockInventoryRecordDetailExportReqVO;
import cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo.StockInventoryRecordDetailPageReqVO;
import cn.acsm.module.stock.dal.dataobject.inventoryrecorddetail.StockInventoryRecordDetailDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 盘点记录表子表-明细 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface StockInventoryRecordDetailMapper extends BaseMapperX<StockInventoryRecordDetailDO> {

    default PageResult<StockInventoryRecordDetailDO> selectPage(StockInventoryRecordDetailPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<StockInventoryRecordDetailDO>()
                .eqIfPresent(StockInventoryRecordDetailDO::getStockRecordId, reqVO.getStockRecordId())
                .eqIfPresent(StockInventoryRecordDetailDO::getStockBatchNo, reqVO.getStockBatchNo())
                .eqIfPresent(StockInventoryRecordDetailDO::getStockRecordDetailId, reqVO.getStockRecordDetailId())
                .eqIfPresent(StockInventoryRecordDetailDO::getType, reqVO.getType())
                .eqIfPresent(StockInventoryRecordDetailDO::getSecondaryClassification, reqVO.getSecondaryClassification())
                .eqIfPresent(StockInventoryRecordDetailDO::getGoodsId, reqVO.getGoodsId())
                .eqIfPresent(StockInventoryRecordDetailDO::getGoodsNumber, reqVO.getGoodsNumber())
                .likeIfPresent(StockInventoryRecordDetailDO::getGoodsName, reqVO.getGoodsName())
                .eqIfPresent(StockInventoryRecordDetailDO::getGoodsType, reqVO.getGoodsType())
                .eqIfPresent(StockInventoryRecordDetailDO::getPackagingSpecificationId, reqVO.getPackagingSpecificationId())
                .eqIfPresent(StockInventoryRecordDetailDO::getPackagingSpecification, reqVO.getPackagingSpecification())
                .likeIfPresent(StockInventoryRecordDetailDO::getPackagingSpecificationName, reqVO.getPackagingSpecificationName())
                .eqIfPresent(StockInventoryRecordDetailDO::getPackagingType, reqVO.getPackagingType())
                .eqIfPresent(StockInventoryRecordDetailDO::getInventoryFrontQuantity, reqVO.getInventoryFrontQuantity())
                .eqIfPresent(StockInventoryRecordDetailDO::getInventoryAfterQuantity, reqVO.getInventoryAfterQuantity())
                .eqIfPresent(StockInventoryRecordDetailDO::getGoodsAllocationId, reqVO.getGoodsAllocationId())
                .eqIfPresent(StockInventoryRecordDetailDO::getGoodsAllocationNo, reqVO.getGoodsAllocationNo())
                .eqIfPresent(StockInventoryRecordDetailDO::getSourceTo, reqVO.getSourceTo())
                .betweenIfPresent(StockInventoryRecordDetailDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(StockInventoryRecordDetailDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(StockInventoryRecordDetailDO::getUserId, reqVO.getUserId())
                .eqIfPresent(StockInventoryRecordDetailDO::getSourceId, reqVO.getSourceId())
                .orderByDesc(StockInventoryRecordDetailDO::getId));
    }

    default List<StockInventoryRecordDetailDO> selectList(StockInventoryRecordDetailExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<StockInventoryRecordDetailDO>()
                .eqIfPresent(StockInventoryRecordDetailDO::getStockRecordId, reqVO.getStockRecordId())
                .eqIfPresent(StockInventoryRecordDetailDO::getStockBatchNo, reqVO.getStockBatchNo())
                .eqIfPresent(StockInventoryRecordDetailDO::getStockRecordDetailId, reqVO.getStockRecordDetailId())
                .eqIfPresent(StockInventoryRecordDetailDO::getType, reqVO.getType())
                .eqIfPresent(StockInventoryRecordDetailDO::getSecondaryClassification, reqVO.getSecondaryClassification())
                .eqIfPresent(StockInventoryRecordDetailDO::getGoodsId, reqVO.getGoodsId())
                .eqIfPresent(StockInventoryRecordDetailDO::getGoodsNumber, reqVO.getGoodsNumber())
                .likeIfPresent(StockInventoryRecordDetailDO::getGoodsName, reqVO.getGoodsName())
                .eqIfPresent(StockInventoryRecordDetailDO::getGoodsType, reqVO.getGoodsType())
                .eqIfPresent(StockInventoryRecordDetailDO::getPackagingSpecificationId, reqVO.getPackagingSpecificationId())
                .eqIfPresent(StockInventoryRecordDetailDO::getPackagingSpecification, reqVO.getPackagingSpecification())
                .likeIfPresent(StockInventoryRecordDetailDO::getPackagingSpecificationName, reqVO.getPackagingSpecificationName())
                .eqIfPresent(StockInventoryRecordDetailDO::getPackagingType, reqVO.getPackagingType())
                .eqIfPresent(StockInventoryRecordDetailDO::getInventoryFrontQuantity, reqVO.getInventoryFrontQuantity())
                .eqIfPresent(StockInventoryRecordDetailDO::getInventoryAfterQuantity, reqVO.getInventoryAfterQuantity())
                .eqIfPresent(StockInventoryRecordDetailDO::getGoodsAllocationId, reqVO.getGoodsAllocationId())
                .eqIfPresent(StockInventoryRecordDetailDO::getGoodsAllocationNo, reqVO.getGoodsAllocationNo())
                .eqIfPresent(StockInventoryRecordDetailDO::getSourceTo, reqVO.getSourceTo())
                .betweenIfPresent(StockInventoryRecordDetailDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(StockInventoryRecordDetailDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(StockInventoryRecordDetailDO::getUserId, reqVO.getUserId())
                .eqIfPresent(StockInventoryRecordDetailDO::getSourceId, reqVO.getSourceId())
                .orderByDesc(StockInventoryRecordDetailDO::getId));
    }

}
