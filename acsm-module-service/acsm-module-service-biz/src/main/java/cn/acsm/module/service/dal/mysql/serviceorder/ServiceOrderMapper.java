package cn.acsm.module.service.dal.mysql.serviceorder;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.service.dal.dataobject.serviceorder.ServiceOrderDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.service.controller.admin.serviceorder.vo.*;

/**
 * 服务交易单 Mapper
 *
 * @author smile
 */
@Mapper
public interface ServiceOrderMapper extends BaseMapperX<ServiceOrderDO> {

    default PageResult<ServiceOrderDO> selectPage(ServiceOrderPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ServiceOrderDO>()
                .eqIfPresent(ServiceOrderDO::getTransactionNumber, reqVO.getTransactionNumber())
                .eqIfPresent(ServiceOrderDO::getServiceUserId, reqVO.getServiceUserId())
                .eqIfPresent(ServiceOrderDO::getCellphoneNumber, reqVO.getCellphoneNumber())
                .betweenIfPresent(ServiceOrderDO::getOrderTime, reqVO.getOrderTime())
                .eqIfPresent(ServiceOrderDO::getTotalAmount, reqVO.getTotalAmount())
                .eqIfPresent(ServiceOrderDO::getServiceId, reqVO.getServiceId())
                .eqIfPresent(ServiceOrderDO::getServiceEquitiesId, reqVO.getServiceEquitiesId())
                .eqIfPresent(ServiceOrderDO::getParticipation, reqVO.getParticipation())
                .eqIfPresent(ServiceOrderDO::getServiceCharge, reqVO.getServiceCharge())
                .eqIfPresent(ServiceOrderDO::getOrderStatus, reqVO.getOrderStatus())
                .eqIfPresent(ServiceOrderDO::getServicePriceId, reqVO.getServicePriceId())
                .eqIfPresent(ServiceOrderDO::getSystemUserId, reqVO.getSystemUserId())
                .eqIfPresent(ServiceOrderDO::getCarrierId, reqVO.getCarrierId())
                .eqIfPresent(ServiceOrderDO::getAreaCode, reqVO.getAreaCode())
                .eqIfPresent(ServiceOrderDO::getOrderType, reqVO.getOrderType())
                .eqIfPresent(ServiceOrderDO::getTicketPackageId, reqVO.getTicketPackageId())
                .eqIfPresent(ServiceOrderDO::getPayType, reqVO.getPayType())
                .eqIfPresent(ServiceOrderDO::getActivitySessionId, reqVO.getActivitySessionId())
                .eqIfPresent(ServiceOrderDO::getFarmFamilyId, reqVO.getFarmFamilyId())
                .eqIfPresent(ServiceOrderDO::getWeixinOrderId, reqVO.getWeixinOrderId())
                .eqIfPresent(ServiceOrderDO::getExchangeCode, reqVO.getExchangeCode())
                .eqIfPresent(ServiceOrderDO::getScanOperator, reqVO.getScanOperator())
                .betweenIfPresent(ServiceOrderDO::getScanDate, reqVO.getScanDate())
                .betweenIfPresent(ServiceOrderDO::getExpiryDate, reqVO.getExpiryDate())
                .eqIfPresent(ServiceOrderDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ServiceOrderDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ServiceOrderDO::getSource, reqVO.getSource())
                .orderByDesc(ServiceOrderDO::getId));
    }

    default List<ServiceOrderDO> selectList(ServiceOrderExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ServiceOrderDO>()
                .eqIfPresent(ServiceOrderDO::getTransactionNumber, reqVO.getTransactionNumber())
                .eqIfPresent(ServiceOrderDO::getServiceUserId, reqVO.getServiceUserId())
                .eqIfPresent(ServiceOrderDO::getCellphoneNumber, reqVO.getCellphoneNumber())
                .betweenIfPresent(ServiceOrderDO::getOrderTime, reqVO.getOrderTime())
                .eqIfPresent(ServiceOrderDO::getTotalAmount, reqVO.getTotalAmount())
                .eqIfPresent(ServiceOrderDO::getServiceId, reqVO.getServiceId())
                .eqIfPresent(ServiceOrderDO::getServiceEquitiesId, reqVO.getServiceEquitiesId())
                .eqIfPresent(ServiceOrderDO::getParticipation, reqVO.getParticipation())
                .eqIfPresent(ServiceOrderDO::getServiceCharge, reqVO.getServiceCharge())
                .eqIfPresent(ServiceOrderDO::getOrderStatus, reqVO.getOrderStatus())
                .eqIfPresent(ServiceOrderDO::getServicePriceId, reqVO.getServicePriceId())
                .eqIfPresent(ServiceOrderDO::getSystemUserId, reqVO.getSystemUserId())
                .eqIfPresent(ServiceOrderDO::getCarrierId, reqVO.getCarrierId())
                .eqIfPresent(ServiceOrderDO::getAreaCode, reqVO.getAreaCode())
                .eqIfPresent(ServiceOrderDO::getOrderType, reqVO.getOrderType())
                .eqIfPresent(ServiceOrderDO::getTicketPackageId, reqVO.getTicketPackageId())
                .eqIfPresent(ServiceOrderDO::getPayType, reqVO.getPayType())
                .eqIfPresent(ServiceOrderDO::getActivitySessionId, reqVO.getActivitySessionId())
                .eqIfPresent(ServiceOrderDO::getFarmFamilyId, reqVO.getFarmFamilyId())
                .eqIfPresent(ServiceOrderDO::getWeixinOrderId, reqVO.getWeixinOrderId())
                .eqIfPresent(ServiceOrderDO::getExchangeCode, reqVO.getExchangeCode())
                .eqIfPresent(ServiceOrderDO::getScanOperator, reqVO.getScanOperator())
                .betweenIfPresent(ServiceOrderDO::getScanDate, reqVO.getScanDate())
                .betweenIfPresent(ServiceOrderDO::getExpiryDate, reqVO.getExpiryDate())
                .eqIfPresent(ServiceOrderDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ServiceOrderDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ServiceOrderDO::getSource, reqVO.getSource())
                .orderByDesc(ServiceOrderDO::getId));
    }

}
