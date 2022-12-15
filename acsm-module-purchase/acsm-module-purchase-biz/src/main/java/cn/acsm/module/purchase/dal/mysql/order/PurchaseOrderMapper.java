package cn.acsm.module.purchase.dal.mysql.order;

import cn.acsm.module.purchase.controller.admin.order.vo.PurchaseOrderExportReqVO;
import cn.acsm.module.purchase.controller.admin.order.vo.PurchaseOrderPageReqVO;
import cn.acsm.module.purchase.dal.dataobject.order.PurchaseOrderDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 采购单 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PurchaseOrderMapper extends BaseMapperX<PurchaseOrderDO> {

    default PageResult<PurchaseOrderDO> selectPage(PurchaseOrderPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PurchaseOrderDO>()
                .eqIfPresent(PurchaseOrderDO::getPurchaseType, reqVO.getPurchaseType())
                .eqIfPresent(PurchaseOrderDO::getSecondaryClassification, reqVO.getSecondaryClassification())
                .eqIfPresent(PurchaseOrderDO::getPurchaseNumber, reqVO.getPurchaseNumber())
                .eqIfPresent(PurchaseOrderDO::getProviderId, reqVO.getProviderId())
                .likeIfPresent(PurchaseOrderDO::getProviderName, reqVO.getProviderName())
                .eqIfPresent(PurchaseOrderDO::getProviderPhone, reqVO.getProviderPhone())
                .betweenIfPresent(PurchaseOrderDO::getPurchaseTime, reqVO.getPurchaseTime())
                .betweenIfPresent(PurchaseOrderDO::getComplateTime, reqVO.getComplateTime())
                .eqIfPresent(PurchaseOrderDO::getPurchaseTotalAmount, reqVO.getPurchaseTotalAmount())
                .eqIfPresent(PurchaseOrderDO::getSettlementType, reqVO.getSettlementType())
                .likeIfPresent(PurchaseOrderDO::getBeneficiaryName, reqVO.getBeneficiaryName())
                .eqIfPresent(PurchaseOrderDO::getBankDeposit, reqVO.getBankDeposit())
                .eqIfPresent(PurchaseOrderDO::getCollectionAccount, reqVO.getCollectionAccount())
                .eqIfPresent(PurchaseOrderDO::getPayWay, reqVO.getPayWay())
                .eqIfPresent(PurchaseOrderDO::getPurchaserId, reqVO.getPurchaserId())
                .likeIfPresent(PurchaseOrderDO::getPurchaserName, reqVO.getPurchaserName())
                .eqIfPresent(PurchaseOrderDO::getPurchaseOfficeId, reqVO.getPurchaseOfficeId())
                .likeIfPresent(PurchaseOrderDO::getPurchaseOfficeName, reqVO.getPurchaseOfficeName())
                .eqIfPresent(PurchaseOrderDO::getProvince, reqVO.getProvince())
                .eqIfPresent(PurchaseOrderDO::getCity, reqVO.getCity())
                .eqIfPresent(PurchaseOrderDO::getCountry, reqVO.getCountry())
                .eqIfPresent(PurchaseOrderDO::getAddress, reqVO.getAddress())
                .eqIfPresent(PurchaseOrderDO::getLongitude, reqVO.getLongitude())
                .eqIfPresent(PurchaseOrderDO::getLatitude, reqVO.getLatitude())
                .eqIfPresent(PurchaseOrderDO::getBasesId, reqVO.getBasesId())
                .eqIfPresent(PurchaseOrderDO::getTunnelId, reqVO.getTunnelId())
                .eqIfPresent(PurchaseOrderDO::getPurchaseStatus, reqVO.getPurchaseStatus())
                .eqIfPresent(PurchaseOrderDO::getQuoteId, reqVO.getQuoteId())
                .eqIfPresent(PurchaseOrderDO::getEffectiveStage, reqVO.getEffectiveStage())
                .eqIfPresent(PurchaseOrderDO::getBatchCode, reqVO.getBatchCode())
                .eqIfPresent(PurchaseOrderDO::getTransactionNumber, reqVO.getTransactionNumber())
                .eqIfPresent(PurchaseOrderDO::getSource, reqVO.getSource())
                .eqIfPresent(PurchaseOrderDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(PurchaseOrderDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseOrderDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PurchaseOrderDO::getId));
    }

    default List<PurchaseOrderDO> selectList(PurchaseOrderExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PurchaseOrderDO>()
                .eqIfPresent(PurchaseOrderDO::getPurchaseType, reqVO.getPurchaseType())
                .eqIfPresent(PurchaseOrderDO::getSecondaryClassification, reqVO.getSecondaryClassification())
                .eqIfPresent(PurchaseOrderDO::getPurchaseNumber, reqVO.getPurchaseNumber())
                .eqIfPresent(PurchaseOrderDO::getProviderId, reqVO.getProviderId())
                .likeIfPresent(PurchaseOrderDO::getProviderName, reqVO.getProviderName())
                .eqIfPresent(PurchaseOrderDO::getProviderPhone, reqVO.getProviderPhone())
                .betweenIfPresent(PurchaseOrderDO::getPurchaseTime, reqVO.getPurchaseTime())
                .betweenIfPresent(PurchaseOrderDO::getComplateTime, reqVO.getComplateTime())
                .eqIfPresent(PurchaseOrderDO::getPurchaseTotalAmount, reqVO.getPurchaseTotalAmount())
                .eqIfPresent(PurchaseOrderDO::getSettlementType, reqVO.getSettlementType())
                .likeIfPresent(PurchaseOrderDO::getBeneficiaryName, reqVO.getBeneficiaryName())
                .eqIfPresent(PurchaseOrderDO::getBankDeposit, reqVO.getBankDeposit())
                .eqIfPresent(PurchaseOrderDO::getCollectionAccount, reqVO.getCollectionAccount())
                .eqIfPresent(PurchaseOrderDO::getPayWay, reqVO.getPayWay())
                .eqIfPresent(PurchaseOrderDO::getPurchaserId, reqVO.getPurchaserId())
                .likeIfPresent(PurchaseOrderDO::getPurchaserName, reqVO.getPurchaserName())
                .eqIfPresent(PurchaseOrderDO::getPurchaseOfficeId, reqVO.getPurchaseOfficeId())
                .likeIfPresent(PurchaseOrderDO::getPurchaseOfficeName, reqVO.getPurchaseOfficeName())
                .eqIfPresent(PurchaseOrderDO::getProvince, reqVO.getProvince())
                .eqIfPresent(PurchaseOrderDO::getCity, reqVO.getCity())
                .eqIfPresent(PurchaseOrderDO::getCountry, reqVO.getCountry())
                .eqIfPresent(PurchaseOrderDO::getAddress, reqVO.getAddress())
                .eqIfPresent(PurchaseOrderDO::getLongitude, reqVO.getLongitude())
                .eqIfPresent(PurchaseOrderDO::getLatitude, reqVO.getLatitude())
                .eqIfPresent(PurchaseOrderDO::getBasesId, reqVO.getBasesId())
                .eqIfPresent(PurchaseOrderDO::getTunnelId, reqVO.getTunnelId())
                .eqIfPresent(PurchaseOrderDO::getPurchaseStatus, reqVO.getPurchaseStatus())
                .eqIfPresent(PurchaseOrderDO::getQuoteId, reqVO.getQuoteId())
                .eqIfPresent(PurchaseOrderDO::getEffectiveStage, reqVO.getEffectiveStage())
                .eqIfPresent(PurchaseOrderDO::getBatchCode, reqVO.getBatchCode())
                .eqIfPresent(PurchaseOrderDO::getTransactionNumber, reqVO.getTransactionNumber())
                .eqIfPresent(PurchaseOrderDO::getSource, reqVO.getSource())
                .eqIfPresent(PurchaseOrderDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(PurchaseOrderDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseOrderDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PurchaseOrderDO::getId));
    }

}
