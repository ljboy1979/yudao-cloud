package cn.acsm.module.purchase.dal.mysql.purchase;

import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchaseExportReqVO;
import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchasePageReqVO;
import cn.acsm.module.purchase.dal.dataobject.purchase.PurchaseDO;
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
public interface PurchaseMapper extends BaseMapperX<PurchaseDO> {

    default PageResult<PurchaseDO> selectPage(PurchasePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PurchaseDO>()
                .eqIfPresent(PurchaseDO::getId, reqVO.getId())
                .eqIfPresent(PurchaseDO::getPurchaseType, reqVO.getPurchaseType())
                .eqIfPresent(PurchaseDO::getSecondaryClassification, reqVO.getSecondaryClassification())
                .eqIfPresent(PurchaseDO::getPurchaseOrderNumber, reqVO.getPurchaseOrderNumber())
                .eqIfPresent(PurchaseDO::getProviderId, reqVO.getProviderId())
                .likeIfPresent(PurchaseDO::getProviderName, reqVO.getProviderName())
                .eqIfPresent(PurchaseDO::getProviderContactInformation, reqVO.getProviderContactInformation())
                .betweenIfPresent(PurchaseDO::getPurchaseTime, reqVO.getPurchaseTime())
                .betweenIfPresent(PurchaseDO::getPurchaseCompletionTime, reqVO.getPurchaseCompletionTime())
                .eqIfPresent(PurchaseDO::getTotalProcurement, reqVO.getTotalProcurement())
                .eqIfPresent(PurchaseDO::getSettlementMethod, reqVO.getSettlementMethod())
                .likeIfPresent(PurchaseDO::getBeneficiaryName, reqVO.getBeneficiaryName())
                .eqIfPresent(PurchaseDO::getBankOfDeposit, reqVO.getBankOfDeposit())
                .eqIfPresent(PurchaseDO::getCollectionAccountNo, reqVO.getCollectionAccountNo())
                .eqIfPresent(PurchaseDO::getPaymentMethod, reqVO.getPaymentMethod())
                .eqIfPresent(PurchaseDO::getPurchaserId, reqVO.getPurchaserId())
                .likeIfPresent(PurchaseDO::getPurchaserName, reqVO.getPurchaserName())
                .eqIfPresent(PurchaseDO::getProcurementDepartmentId, reqVO.getProcurementDepartmentId())
                .likeIfPresent(PurchaseDO::getProcurementDepartmentName, reqVO.getProcurementDepartmentName())
                .eqIfPresent(PurchaseDO::getProvince, reqVO.getProvince())
                .eqIfPresent(PurchaseDO::getCity, reqVO.getCity())
                .eqIfPresent(PurchaseDO::getArea, reqVO.getArea())
                .eqIfPresent(PurchaseDO::getDetailedAddress, reqVO.getDetailedAddress())
                .eqIfPresent(PurchaseDO::getLongitude, reqVO.getLongitude())
                .eqIfPresent(PurchaseDO::getLatitude, reqVO.getLatitude())
                .eqIfPresent(PurchaseDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(PurchaseDO::getMassifId, reqVO.getMassifId())
                .eqIfPresent(PurchaseDO::getPurchaseStatus, reqVO.getPurchaseStatus())
                .eqIfPresent(PurchaseDO::getQuotationId, reqVO.getQuotationId())
                .eqIfPresent(PurchaseDO::getQuotationNo, reqVO.getQuotationNo())
                .eqIfPresent(PurchaseDO::getTermOfValidity, reqVO.getTermOfValidity())
                .eqIfPresent(PurchaseDO::getCollectionBatchNo, reqVO.getCollectionBatchNo())
                .eqIfPresent(PurchaseDO::getTransactionNo, reqVO.getTransactionNo())
                .eqIfPresent(PurchaseDO::getPurchaseOrderSource, reqVO.getPurchaseOrderSource())
                .eqIfPresent(PurchaseDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(PurchaseDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PurchaseDO::getId));
    }

    default List<PurchaseDO> selectList(PurchaseExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PurchaseDO>()
                .eqIfPresent(PurchaseDO::getId, reqVO.getId())
                .eqIfPresent(PurchaseDO::getPurchaseType, reqVO.getPurchaseType())
                .eqIfPresent(PurchaseDO::getSecondaryClassification, reqVO.getSecondaryClassification())
                .eqIfPresent(PurchaseDO::getPurchaseOrderNumber, reqVO.getPurchaseOrderNumber())
                .eqIfPresent(PurchaseDO::getProviderId, reqVO.getProviderId())
                .likeIfPresent(PurchaseDO::getProviderName, reqVO.getProviderName())
                .eqIfPresent(PurchaseDO::getProviderContactInformation, reqVO.getProviderContactInformation())
                .betweenIfPresent(PurchaseDO::getPurchaseTime, reqVO.getPurchaseTime())
                .betweenIfPresent(PurchaseDO::getPurchaseCompletionTime, reqVO.getPurchaseCompletionTime())
                .eqIfPresent(PurchaseDO::getTotalProcurement, reqVO.getTotalProcurement())
                .eqIfPresent(PurchaseDO::getSettlementMethod, reqVO.getSettlementMethod())
                .likeIfPresent(PurchaseDO::getBeneficiaryName, reqVO.getBeneficiaryName())
                .eqIfPresent(PurchaseDO::getBankOfDeposit, reqVO.getBankOfDeposit())
                .eqIfPresent(PurchaseDO::getCollectionAccountNo, reqVO.getCollectionAccountNo())
                .eqIfPresent(PurchaseDO::getPaymentMethod, reqVO.getPaymentMethod())
                .eqIfPresent(PurchaseDO::getPurchaserId, reqVO.getPurchaserId())
                .likeIfPresent(PurchaseDO::getPurchaserName, reqVO.getPurchaserName())
                .eqIfPresent(PurchaseDO::getProcurementDepartmentId, reqVO.getProcurementDepartmentId())
                .likeIfPresent(PurchaseDO::getProcurementDepartmentName, reqVO.getProcurementDepartmentName())
                .eqIfPresent(PurchaseDO::getProvince, reqVO.getProvince())
                .eqIfPresent(PurchaseDO::getCity, reqVO.getCity())
                .eqIfPresent(PurchaseDO::getArea, reqVO.getArea())
                .eqIfPresent(PurchaseDO::getDetailedAddress, reqVO.getDetailedAddress())
                .eqIfPresent(PurchaseDO::getLongitude, reqVO.getLongitude())
                .eqIfPresent(PurchaseDO::getLatitude, reqVO.getLatitude())
                .eqIfPresent(PurchaseDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(PurchaseDO::getMassifId, reqVO.getMassifId())
                .eqIfPresent(PurchaseDO::getPurchaseStatus, reqVO.getPurchaseStatus())
                .eqIfPresent(PurchaseDO::getQuotationId, reqVO.getQuotationId())
                .eqIfPresent(PurchaseDO::getQuotationNo, reqVO.getQuotationNo())
                .eqIfPresent(PurchaseDO::getTermOfValidity, reqVO.getTermOfValidity())
                .eqIfPresent(PurchaseDO::getCollectionBatchNo, reqVO.getCollectionBatchNo())
                .eqIfPresent(PurchaseDO::getTransactionNo, reqVO.getTransactionNo())
                .eqIfPresent(PurchaseDO::getPurchaseOrderSource, reqVO.getPurchaseOrderSource())
                .eqIfPresent(PurchaseDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(PurchaseDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PurchaseDO::getId));
    }

}
