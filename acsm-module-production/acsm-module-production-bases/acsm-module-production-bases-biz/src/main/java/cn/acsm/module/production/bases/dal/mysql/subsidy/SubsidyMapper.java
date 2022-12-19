package cn.acsm.module.production.bases.dal.mysql.subsidy;

import java.util.*;

import cn.acsm.module.production.bases.controller.admin.subsidy.vo.SubsidyExportReqVO;
import cn.acsm.module.production.bases.controller.admin.subsidy.vo.SubsidyPageReqVO;
import cn.acsm.module.production.bases.dal.dataobject.subsidy.SubsidyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.bases.controller.admin.subsidy.vo.*;

/**
 * 基地补贴信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface SubsidyMapper extends BaseMapperX<SubsidyDO> {

    default PageResult<SubsidyDO> selectPage(SubsidyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SubsidyDO>()
                .eqIfPresent(SubsidyDO::getBasesId, reqVO.getBasesId())
                .eqIfPresent(SubsidyDO::getFinancialId, reqVO.getFinancialId())
                .betweenIfPresent(SubsidyDO::getInsertTime, reqVO.getInsertTime())
                .eqIfPresent(SubsidyDO::getMoney, reqVO.getMoney())
                .eqIfPresent(SubsidyDO::getMuNumber, reqVO.getMuNumber())
                .eqIfPresent(SubsidyDO::getSubsidyType, reqVO.getSubsidyType())
                .eqIfPresent(SubsidyDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(SubsidyDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(SubsidyDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(SubsidyDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(SubsidyDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(SubsidyDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(SubsidyDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(SubsidyDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(SubsidyDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(SubsidyDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(SubsidyDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(SubsidyDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(SubsidyDO::getSource, reqVO.getSource())
                .eqIfPresent(SubsidyDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(SubsidyDO::getId));
    }

    default List<SubsidyDO> selectList(SubsidyExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SubsidyDO>()
                .eqIfPresent(SubsidyDO::getBasesId, reqVO.getBasesId())
                .eqIfPresent(SubsidyDO::getFinancialId, reqVO.getFinancialId())
                .betweenIfPresent(SubsidyDO::getInsertTime, reqVO.getInsertTime())
                .eqIfPresent(SubsidyDO::getMoney, reqVO.getMoney())
                .eqIfPresent(SubsidyDO::getMuNumber, reqVO.getMuNumber())
                .eqIfPresent(SubsidyDO::getSubsidyType, reqVO.getSubsidyType())
                .eqIfPresent(SubsidyDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(SubsidyDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(SubsidyDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(SubsidyDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(SubsidyDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(SubsidyDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(SubsidyDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(SubsidyDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(SubsidyDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(SubsidyDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(SubsidyDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(SubsidyDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(SubsidyDO::getSource, reqVO.getSource())
                .eqIfPresent(SubsidyDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(SubsidyDO::getId));
    }

}
