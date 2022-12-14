package cn.acsm.module.purchase.dal.mysql.inquiry;

import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryExportReqVO;
import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryPageReqVO;
import cn.acsm.module.purchase.dal.dataobject.inquiry.PurchaseInquiryDO;
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
public interface PurchaseInquiryMapper extends BaseMapperX<PurchaseInquiryDO> {

    default PageResult<PurchaseInquiryDO> selectPage(PurchaseInquiryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PurchaseInquiryDO>()
                .eqIfPresent(PurchaseInquiryDO::getInquiryNo, reqVO.getInquiryNo())
                .eqIfPresent(PurchaseInquiryDO::getProductId, reqVO.getProductId())
                .eqIfPresent(PurchaseInquiryDO::getClassifyId, reqVO.getClassifyId())
                .eqIfPresent(PurchaseInquiryDO::getSpecificationsId, reqVO.getSpecificationsId())
                .eqIfPresent(PurchaseInquiryDO::getLowestPlannedQuantity, reqVO.getLowestPlannedQuantity())
                .eqIfPresent(PurchaseInquiryDO::getHighestPlannedQuantity, reqVO.getHighestPlannedQuantity())
                .betweenIfPresent(PurchaseInquiryDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseInquiryDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PurchaseInquiryDO::getId));
    }

    default List<PurchaseInquiryDO> selectList(PurchaseInquiryExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PurchaseInquiryDO>()
                .eqIfPresent(PurchaseInquiryDO::getInquiryNo, reqVO.getInquiryNo())
                .eqIfPresent(PurchaseInquiryDO::getProductId, reqVO.getProductId())
                .eqIfPresent(PurchaseInquiryDO::getClassifyId, reqVO.getClassifyId())
                .eqIfPresent(PurchaseInquiryDO::getSpecificationsId, reqVO.getSpecificationsId())
                .eqIfPresent(PurchaseInquiryDO::getLowestPlannedQuantity, reqVO.getLowestPlannedQuantity())
                .eqIfPresent(PurchaseInquiryDO::getHighestPlannedQuantity, reqVO.getHighestPlannedQuantity())
                .betweenIfPresent(PurchaseInquiryDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseInquiryDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PurchaseInquiryDO::getId));
    }

}
