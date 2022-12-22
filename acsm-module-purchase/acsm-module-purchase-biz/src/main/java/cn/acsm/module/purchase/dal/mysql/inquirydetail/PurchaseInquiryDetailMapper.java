package cn.acsm.module.purchase.dal.mysql.inquirydetail;

import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailExportReqVO;
import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailPageReqVO;
import cn.acsm.module.purchase.dal.dataobject.inquirydetail.PurchaseInquiryDetailDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 采购询价电子表 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PurchaseInquiryDetailMapper extends BaseMapperX<PurchaseInquiryDetailDO> {

    default PageResult<PurchaseInquiryDetailDO> selectPage(PurchaseInquiryDetailPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PurchaseInquiryDetailDO>()
                .eqIfPresent(PurchaseInquiryDetailDO::getEnquiryId, reqVO.getEnquiryId())
                .eqIfPresent(PurchaseInquiryDetailDO::getCommodityId, reqVO.getCommodityId())
                .eqIfPresent(PurchaseInquiryDetailDO::getCommodityCategoryId, reqVO.getCommodityCategoryId())
                .eqIfPresent(PurchaseInquiryDetailDO::getProductSpecificationsId, reqVO.getProductSpecificationsId())
                .eqIfPresent(PurchaseInquiryDetailDO::getPlannedQuantityMin, reqVO.getPlannedQuantityMin())
                .eqIfPresent(PurchaseInquiryDetailDO::getPlannedQuantityMax, reqVO.getPlannedQuantityMax())
                .betweenIfPresent(PurchaseInquiryDetailDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseInquiryDetailDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(PurchaseInquiryDetailDO::getUserId, reqVO.getUserId())
                .eqIfPresent(PurchaseInquiryDetailDO::getSourceId, reqVO.getSourceId())
                .orderByDesc(PurchaseInquiryDetailDO::getId));
    }

    default List<PurchaseInquiryDetailDO> selectList(PurchaseInquiryDetailExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PurchaseInquiryDetailDO>()
                .eqIfPresent(PurchaseInquiryDetailDO::getEnquiryId, reqVO.getEnquiryId())
                .eqIfPresent(PurchaseInquiryDetailDO::getCommodityId, reqVO.getCommodityId())
                .eqIfPresent(PurchaseInquiryDetailDO::getCommodityCategoryId, reqVO.getCommodityCategoryId())
                .eqIfPresent(PurchaseInquiryDetailDO::getProductSpecificationsId, reqVO.getProductSpecificationsId())
                .eqIfPresent(PurchaseInquiryDetailDO::getPlannedQuantityMin, reqVO.getPlannedQuantityMin())
                .eqIfPresent(PurchaseInquiryDetailDO::getPlannedQuantityMax, reqVO.getPlannedQuantityMax())
                .betweenIfPresent(PurchaseInquiryDetailDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseInquiryDetailDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(PurchaseInquiryDetailDO::getUserId, reqVO.getUserId())
                .eqIfPresent(PurchaseInquiryDetailDO::getSourceId, reqVO.getSourceId())
                .orderByDesc(PurchaseInquiryDetailDO::getId));
    }

}
