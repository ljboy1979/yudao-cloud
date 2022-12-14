package cn.acsm.module.purchase.dal.mysql.details;

import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsExportReqVO;
import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsPageReqVO;
import cn.acsm.module.purchase.dal.dataobject.details.PurchaseDetailsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 采购单明细 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PurchaseDetailsMapper extends BaseMapperX<PurchaseDetailsDO> {

    default PageResult<PurchaseDetailsDO> selectPage(PurchaseDetailsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PurchaseDetailsDO>()
                .eqIfPresent(PurchaseDetailsDO::getOrderId, reqVO.getOrderId())
                .eqIfPresent(PurchaseDetailsDO::getPurchaseOrderNumber, reqVO.getPurchaseOrderNumber())
                .eqIfPresent(PurchaseDetailsDO::getGoodsId, reqVO.getGoodsId())
                .likeIfPresent(PurchaseDetailsDO::getGoodsName, reqVO.getGoodsName())
                .eqIfPresent(PurchaseDetailsDO::getPackagingSpecificationId, reqVO.getPackagingSpecificationId())
                .eqIfPresent(PurchaseDetailsDO::getPackagingSpecification, reqVO.getPackagingSpecification())
                .eqIfPresent(PurchaseDetailsDO::getUnitOfMeasurement, reqVO.getUnitOfMeasurement())
                .eqIfPresent(PurchaseDetailsDO::getPackagingType, reqVO.getPackagingType())
                .eqIfPresent(PurchaseDetailsDO::getPurchaseQuantity, reqVO.getPurchaseQuantity() + "")
                .eqIfPresent(PurchaseDetailsDO::getExpectedArrivalFrequency, reqVO.getExpectedArrivalFrequency())
                .eqIfPresent(PurchaseDetailsDO::getUnitPrice, reqVO.getUnitPrice() + "")
                .eqIfPresent(PurchaseDetailsDO::getDiscountAmount, reqVO.getDiscountAmount() + "")
                .eqIfPresent(PurchaseDetailsDO::getPurchaseAmount, reqVO.getPurchaseAmount() + "")
                .eqIfPresent(PurchaseDetailsDO::getChargingStandard, reqVO.getChargingStandard())
                .betweenIfPresent(PurchaseDetailsDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseDetailsDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PurchaseDetailsDO::getId));
    }

    default List<PurchaseDetailsDO> selectList(PurchaseDetailsExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PurchaseDetailsDO>()
                .eqIfPresent(PurchaseDetailsDO::getOrderId, reqVO.getOrderId())
                .eqIfPresent(PurchaseDetailsDO::getPurchaseOrderNumber, reqVO.getPurchaseOrderNumber())
                .eqIfPresent(PurchaseDetailsDO::getGoodsId, reqVO.getGoodsId())
                .likeIfPresent(PurchaseDetailsDO::getGoodsName, reqVO.getGoodsName())
                .eqIfPresent(PurchaseDetailsDO::getPackagingSpecificationId, reqVO.getPackagingSpecificationId())
                .eqIfPresent(PurchaseDetailsDO::getPackagingSpecification, reqVO.getPackagingSpecification())
                .eqIfPresent(PurchaseDetailsDO::getUnitOfMeasurement, reqVO.getUnitOfMeasurement())
                .eqIfPresent(PurchaseDetailsDO::getPackagingType, reqVO.getPackagingType())
                .eqIfPresent(PurchaseDetailsDO::getPurchaseQuantity, reqVO.getPurchaseQuantity() + "")
                .eqIfPresent(PurchaseDetailsDO::getExpectedArrivalFrequency, reqVO.getExpectedArrivalFrequency())
                .eqIfPresent(PurchaseDetailsDO::getUnitPrice, reqVO.getUnitPrice() + "")
                .eqIfPresent(PurchaseDetailsDO::getDiscountAmount, reqVO.getDiscountAmount() + "")
                .eqIfPresent(PurchaseDetailsDO::getPurchaseAmount, reqVO.getPurchaseAmount() + "")
                .eqIfPresent(PurchaseDetailsDO::getChargingStandard, reqVO.getChargingStandard())
                .betweenIfPresent(PurchaseDetailsDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseDetailsDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PurchaseDetailsDO::getId));
    }

}
