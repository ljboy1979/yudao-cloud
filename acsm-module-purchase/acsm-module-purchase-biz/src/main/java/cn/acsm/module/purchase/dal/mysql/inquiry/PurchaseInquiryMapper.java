package cn.acsm.module.purchase.dal.mysql.inquiry;

import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryExportReqVO;
import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryGetVO;
import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryPageReqVO;
import cn.acsm.module.purchase.dal.dataobject.inquiry.PurchaseInquiryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 采购询价 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PurchaseInquiryMapper extends BaseMapperX<PurchaseInquiryDO> {

    default PageResult<PurchaseInquiryDO> selectPage(PurchaseInquiryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PurchaseInquiryDO>()
                .eqIfPresent(PurchaseInquiryDO::getEnquiryId, reqVO.getEnquiryId())
                .likeIfPresent(PurchaseInquiryDO::getEnquiryName, reqVO.getEnquiryName())
                .eqIfPresent(PurchaseInquiryDO::getProviderId, reqVO.getProviderId())
                .likeIfPresent(PurchaseInquiryDO::getProviderName, reqVO.getProviderName())
                .eqIfPresent(PurchaseInquiryDO::getPostStatus, reqVO.getPostStatus())
                .eqIfPresent(PurchaseInquiryDO::getEnquiryStatus, reqVO.getEnquiryStatus())
                .betweenIfPresent(PurchaseInquiryDO::getReleaseTime, reqVO.getReleaseTime())
                .eqIfPresent(PurchaseInquiryDO::getReadStatus, reqVO.getReadStatus())
                .eqIfPresent(PurchaseInquiryDO::getUid, reqVO.getUid())
                .betweenIfPresent(PurchaseInquiryDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseInquiryDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(PurchaseInquiryDO::getUserId, reqVO.getUserId())
                .eqIfPresent(PurchaseInquiryDO::getSourceId, reqVO.getSourceId())
                .orderByDesc(PurchaseInquiryDO::getId));
    }

    default PageResult<PurchaseInquiryDO> selectPageByProivder(PurchaseInquiryGetVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PurchaseInquiryDO>()
                .eqIfPresent(PurchaseInquiryDO::getProviderId, reqVO.getProviderId())
                .eqIfPresent(PurchaseInquiryDO::getPostStatus, reqVO.getPostStatus())
                .eqIfPresent(PurchaseInquiryDO::getEnquiryStatus, reqVO.getEnquiryStatus())
                .eqIfPresent(PurchaseInquiryDO::getReadStatus, reqVO.getReadStatus()));
    }

    default List<PurchaseInquiryDO> selectList(PurchaseInquiryExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PurchaseInquiryDO>()
                .eqIfPresent(PurchaseInquiryDO::getEnquiryId, reqVO.getEnquiryId())
                .likeIfPresent(PurchaseInquiryDO::getEnquiryName, reqVO.getEnquiryName())
                .eqIfPresent(PurchaseInquiryDO::getProviderId, reqVO.getProviderId())
                .likeIfPresent(PurchaseInquiryDO::getProviderName, reqVO.getProviderName())
                .eqIfPresent(PurchaseInquiryDO::getPostStatus, reqVO.getPostStatus())
                .eqIfPresent(PurchaseInquiryDO::getEnquiryStatus, reqVO.getEnquiryStatus())
                .betweenIfPresent(PurchaseInquiryDO::getReleaseTime, reqVO.getReleaseTime())
                .eqIfPresent(PurchaseInquiryDO::getReadStatus, reqVO.getReadStatus())
                .eqIfPresent(PurchaseInquiryDO::getUid, reqVO.getUid())
                .betweenIfPresent(PurchaseInquiryDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseInquiryDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(PurchaseInquiryDO::getUserId, reqVO.getUserId())
                .eqIfPresent(PurchaseInquiryDO::getSourceId, reqVO.getSourceId())
                .orderByDesc(PurchaseInquiryDO::getId));
    }

}
