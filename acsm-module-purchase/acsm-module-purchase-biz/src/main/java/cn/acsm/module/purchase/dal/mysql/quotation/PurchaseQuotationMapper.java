package cn.acsm.module.purchase.dal.mysql.quotation;

import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationExportReqVO;
import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationPageReqVO;
import cn.acsm.module.purchase.dal.dataobject.quotation.PurchaseQuotationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 采购询价电子 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PurchaseQuotationMapper extends BaseMapperX<PurchaseQuotationDO> {

    default PageResult<PurchaseQuotationDO> selectPage(PurchaseQuotationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PurchaseQuotationDO>()
                .eqIfPresent(PurchaseQuotationDO::getQuotationNo, reqVO.getQuotationNo())
                .likeIfPresent(PurchaseQuotationDO::getQuotationName, reqVO.getQuotationName())
                .eqIfPresent(PurchaseQuotationDO::getPurchaserId, reqVO.getPurchaserId())
                .eqIfPresent(PurchaseQuotationDO::getInquiryId, reqVO.getInquiryId())
                .eqIfPresent(PurchaseQuotationDO::getInquiryNo, reqVO.getInquiryNo())
                .betweenIfPresent(PurchaseQuotationDO::getQuotationValidTime, reqVO.getQuotationValidTime())
                .eqIfPresent(PurchaseQuotationDO::getIsSubmit, reqVO.getIsSubmit())
                .betweenIfPresent(PurchaseQuotationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseQuotationDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PurchaseQuotationDO::getId));
    }

    default List<PurchaseQuotationDO> selectList(PurchaseQuotationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PurchaseQuotationDO>()
                .eqIfPresent(PurchaseQuotationDO::getQuotationNo, reqVO.getQuotationNo())
                .likeIfPresent(PurchaseQuotationDO::getQuotationName, reqVO.getQuotationName())
                .eqIfPresent(PurchaseQuotationDO::getPurchaserId, reqVO.getPurchaserId())
                .eqIfPresent(PurchaseQuotationDO::getInquiryId, reqVO.getInquiryId())
                .eqIfPresent(PurchaseQuotationDO::getInquiryNo, reqVO.getInquiryNo())
                .betweenIfPresent(PurchaseQuotationDO::getQuotationValidTime, reqVO.getQuotationValidTime())
                .eqIfPresent(PurchaseQuotationDO::getIsSubmit, reqVO.getIsSubmit())
                .betweenIfPresent(PurchaseQuotationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseQuotationDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PurchaseQuotationDO::getId));
    }

}
