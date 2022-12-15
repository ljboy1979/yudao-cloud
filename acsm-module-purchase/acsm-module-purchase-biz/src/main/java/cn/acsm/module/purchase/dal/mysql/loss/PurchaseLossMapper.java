package cn.acsm.module.purchase.dal.mysql.loss;

import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossExportReqVO;
import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossPageReqVO;
import cn.acsm.module.purchase.dal.dataobject.loss.PurchaseLossDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 损耗 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PurchaseLossMapper extends BaseMapperX<PurchaseLossDO> {

    default PageResult<PurchaseLossDO> selectPage(PurchaseLossPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PurchaseLossDO>()
                .eqIfPresent(PurchaseLossDO::getPurchaseId, reqVO.getPurchaseId())
                .eqIfPresent(PurchaseLossDO::getPurchaseNumber, reqVO.getPurchaseNumber())
                .eqIfPresent(PurchaseLossDO::getGoodsId, reqVO.getGoodsId())
                .eqIfPresent(PurchaseLossDO::getElectronicBillOfGoodsId, reqVO.getElectronicBillOfGoodsId())
                .eqIfPresent(PurchaseLossDO::getGoodSkuId, reqVO.getGoodSkuId())
                .likeIfPresent(PurchaseLossDO::getGoodsName, reqVO.getGoodsName())
                .eqIfPresent(PurchaseLossDO::getPackingSpecification, reqVO.getPackingSpecification())
                .eqIfPresent(PurchaseLossDO::getSpecificationUnit, reqVO.getSpecificationUnit())
                .eqIfPresent(PurchaseLossDO::getLossCount, reqVO.getLossCount())
                .eqIfPresent(PurchaseLossDO::getLossWeight, reqVO.getLossWeight())
                .eqIfPresent(PurchaseLossDO::getAmount, reqVO.getAmount())
                .eqIfPresent(PurchaseLossDO::getManagerId, reqVO.getManagerId())
                .eqIfPresent(PurchaseLossDO::getManager, reqVO.getManager())
                .betweenIfPresent(PurchaseLossDO::getTime, reqVO.getTime())
                .eqIfPresent(PurchaseLossDO::getStockId, reqVO.getStockId())
                .eqIfPresent(PurchaseLossDO::getReceiptBatchNo, reqVO.getReceiptBatchNo())
                .eqIfPresent(PurchaseLossDO::getInventoryRecordDetailsId, reqVO.getInventoryRecordDetailsId())
                .betweenIfPresent(PurchaseLossDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseLossDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PurchaseLossDO::getId));
    }

    default List<PurchaseLossDO> selectList(PurchaseLossExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PurchaseLossDO>()
                .eqIfPresent(PurchaseLossDO::getPurchaseId, reqVO.getPurchaseId())
                .eqIfPresent(PurchaseLossDO::getPurchaseNumber, reqVO.getPurchaseNumber())
                .eqIfPresent(PurchaseLossDO::getGoodsId, reqVO.getGoodsId())
                .eqIfPresent(PurchaseLossDO::getElectronicBillOfGoodsId, reqVO.getElectronicBillOfGoodsId())
                .eqIfPresent(PurchaseLossDO::getGoodSkuId, reqVO.getGoodSkuId())
                .likeIfPresent(PurchaseLossDO::getGoodsName, reqVO.getGoodsName())
                .eqIfPresent(PurchaseLossDO::getPackingSpecification, reqVO.getPackingSpecification())
                .eqIfPresent(PurchaseLossDO::getSpecificationUnit, reqVO.getSpecificationUnit())
                .eqIfPresent(PurchaseLossDO::getLossCount, reqVO.getLossCount())
                .eqIfPresent(PurchaseLossDO::getLossWeight, reqVO.getLossWeight())
                .eqIfPresent(PurchaseLossDO::getAmount, reqVO.getAmount())
                .eqIfPresent(PurchaseLossDO::getManagerId, reqVO.getManagerId())
                .eqIfPresent(PurchaseLossDO::getManager, reqVO.getManager())
                .betweenIfPresent(PurchaseLossDO::getTime, reqVO.getTime())
                .eqIfPresent(PurchaseLossDO::getStockId, reqVO.getStockId())
                .eqIfPresent(PurchaseLossDO::getReceiptBatchNo, reqVO.getReceiptBatchNo())
                .eqIfPresent(PurchaseLossDO::getInventoryRecordDetailsId, reqVO.getInventoryRecordDetailsId())
                .betweenIfPresent(PurchaseLossDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseLossDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PurchaseLossDO::getId));
    }

}
