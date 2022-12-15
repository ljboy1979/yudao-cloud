package cn.acsm.module.purchase.dal.mysql.deliver;

import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverExportReqVO;
import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverPageReqVO;
import cn.acsm.module.purchase.dal.dataobject.deliver.PurchaseDeliverDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 采购交付 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PurchaseDeliverMapper extends BaseMapperX<PurchaseDeliverDO> {

    default PageResult<PurchaseDeliverDO> selectPage(PurchaseDeliverPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PurchaseDeliverDO>()
                .eqIfPresent(PurchaseDeliverDO::getPurchaseId, reqVO.getPurchaseId())
                .eqIfPresent(PurchaseDeliverDO::getPurchaseNumber, reqVO.getPurchaseNumber())
                .eqIfPresent(PurchaseDeliverDO::getBatchCode, reqVO.getBatchCode())
                .betweenIfPresent(PurchaseDeliverDO::getExpectedDeliveryTime, reqVO.getExpectedDeliveryTime())
                .eqIfPresent(PurchaseDeliverDO::getActualDelivery, reqVO.getActualDelivery())
                .eqIfPresent(PurchaseDeliverDO::getExpectedDeliveryCount, reqVO.getExpectedDeliveryCount())
                .eqIfPresent(PurchaseDeliverDO::getActualDeliveryCount, reqVO.getActualDeliveryCount())
                .eqIfPresent(PurchaseDeliverDO::getCompanyId, reqVO.getCompanyId())
                .betweenIfPresent(PurchaseDeliverDO::getSettlementTime, reqVO.getSettlementTime())
                .eqIfPresent(PurchaseDeliverDO::getSettlementAmount, reqVO.getSettlementAmount())
                .eqIfPresent(PurchaseDeliverDO::getDeliveryStatus, reqVO.getDeliveryStatus())
                .eqIfPresent(PurchaseDeliverDO::getShipmentNo, reqVO.getShipmentNo())
                .betweenIfPresent(PurchaseDeliverDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseDeliverDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PurchaseDeliverDO::getId));
    }

    default List<PurchaseDeliverDO> selectList(PurchaseDeliverExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PurchaseDeliverDO>()
                .eqIfPresent(PurchaseDeliverDO::getPurchaseId, reqVO.getPurchaseId())
                .eqIfPresent(PurchaseDeliverDO::getPurchaseNumber, reqVO.getPurchaseNumber())
                .eqIfPresent(PurchaseDeliverDO::getBatchCode, reqVO.getBatchCode())
                .betweenIfPresent(PurchaseDeliverDO::getExpectedDeliveryTime, reqVO.getExpectedDeliveryTime())
                .eqIfPresent(PurchaseDeliverDO::getActualDelivery, reqVO.getActualDelivery())
                .eqIfPresent(PurchaseDeliverDO::getExpectedDeliveryCount, reqVO.getExpectedDeliveryCount())
                .eqIfPresent(PurchaseDeliverDO::getActualDeliveryCount, reqVO.getActualDeliveryCount())
                .eqIfPresent(PurchaseDeliverDO::getCompanyId, reqVO.getCompanyId())
                .betweenIfPresent(PurchaseDeliverDO::getSettlementTime, reqVO.getSettlementTime())
                .eqIfPresent(PurchaseDeliverDO::getSettlementAmount, reqVO.getSettlementAmount())
                .eqIfPresent(PurchaseDeliverDO::getDeliveryStatus, reqVO.getDeliveryStatus())
                .eqIfPresent(PurchaseDeliverDO::getShipmentNo, reqVO.getShipmentNo())
                .betweenIfPresent(PurchaseDeliverDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseDeliverDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PurchaseDeliverDO::getId));
    }

}
