package cn.acsm.module.purchase.dal.mysql.quotationelectronic;

import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchasePriceTagDetailVO;
import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicExportReqVO;
import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicPageReqVO;
import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationInfoVO;
import cn.acsm.module.purchase.dal.dataobject.quotationelectronic.PurchaseQuotationElectronicDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 采购报价单电子 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PurchaseQuotationElectronicMapper extends BaseMapperX<PurchaseQuotationElectronicDO> {

    default PageResult<PurchaseQuotationElectronicDO> selectPage(PurchaseQuotationElectronicPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PurchaseQuotationElectronicDO>()
                .eqIfPresent(PurchaseQuotationElectronicDO::getQuoteId, reqVO.getQuoteId())
                .eqIfPresent(PurchaseQuotationElectronicDO::getInquiryDetailId, reqVO.getInquiryDetailId())
                .eqIfPresent(PurchaseQuotationElectronicDO::getCommodityId, reqVO.getCommodityId())
                .eqIfPresent(PurchaseQuotationElectronicDO::getCommodityCategoryId, reqVO.getCommodityCategoryId())
                .eqIfPresent(PurchaseQuotationElectronicDO::getSpecificationsId, reqVO.getSpecificationsId())
                .eqIfPresent(PurchaseQuotationElectronicDO::getBatchNumber, reqVO.getBatchNumber())
                .eqIfPresent(PurchaseQuotationElectronicDO::getPrice, reqVO.getPrice())
                .eqIfPresent(PurchaseQuotationElectronicDO::getOrderSize, reqVO.getOrderSize())
                .eqIfPresent(PurchaseQuotationElectronicDO::getTotalPrice, reqVO.getTotalPrice())
                .betweenIfPresent(PurchaseQuotationElectronicDO::getStartTime, reqVO.getStartTime())
                .betweenIfPresent(PurchaseQuotationElectronicDO::getEndTime, reqVO.getEndTime())
                .betweenIfPresent(PurchaseQuotationElectronicDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseQuotationElectronicDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PurchaseQuotationElectronicDO::getId));
    }

    default PageResult<PurchaseQuotationElectronicDO> selectPageInfo(PurchaseQuotationInfoVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PurchaseQuotationElectronicDO>()
                .eqIfPresent(PurchaseQuotationElectronicDO::getQuotationId, reqVO.getQuotationId())
                .eqIfPresent(PurchaseQuotationElectronicDO::getInquiryDetailId, reqVO.getInquiryDetailId())
                .betweenIfPresent(PurchaseQuotationElectronicDO::getStartTime, reqVO.getStartTime())
                .orderByDesc(PurchaseQuotationElectronicDO::getId));
    }

    default PageResult<PurchaseQuotationElectronicDO> selectPriceTag(PurchasePriceTagDetailVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PurchaseQuotationElectronicDO>()
                .eqIfPresent(PurchaseQuotationElectronicDO::getCommodityId, reqVO.getCommodityId())
                .eqIfPresent(PurchaseQuotationElectronicDO::getSpecificationsId, reqVO.getSpecificationsId())
                .orderByDesc(PurchaseQuotationElectronicDO::getId));
    }

    default List<PurchaseQuotationElectronicDO> selectList(PurchaseQuotationElectronicExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PurchaseQuotationElectronicDO>()
                .eqIfPresent(PurchaseQuotationElectronicDO::getQuoteId, reqVO.getQuoteId())
                .eqIfPresent(PurchaseQuotationElectronicDO::getInquiryDetailId, reqVO.getInquiryDetailId())
                .eqIfPresent(PurchaseQuotationElectronicDO::getCommodityId, reqVO.getCommodityId())
                .eqIfPresent(PurchaseQuotationElectronicDO::getCommodityCategoryId, reqVO.getCommodityCategoryId())
                .eqIfPresent(PurchaseQuotationElectronicDO::getSpecificationsId, reqVO.getSpecificationsId())
                .eqIfPresent(PurchaseQuotationElectronicDO::getBatchNumber, reqVO.getBatchNumber())
                .eqIfPresent(PurchaseQuotationElectronicDO::getPrice, reqVO.getPrice())
                .eqIfPresent(PurchaseQuotationElectronicDO::getOrderSize, reqVO.getOrderSize())
                .eqIfPresent(PurchaseQuotationElectronicDO::getTotalPrice, reqVO.getTotalPrice())
                .betweenIfPresent(PurchaseQuotationElectronicDO::getStartTime, reqVO.getStartTime())
                .betweenIfPresent(PurchaseQuotationElectronicDO::getEndTime, reqVO.getEndTime())
                .betweenIfPresent(PurchaseQuotationElectronicDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseQuotationElectronicDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PurchaseQuotationElectronicDO::getId));
    }

}
