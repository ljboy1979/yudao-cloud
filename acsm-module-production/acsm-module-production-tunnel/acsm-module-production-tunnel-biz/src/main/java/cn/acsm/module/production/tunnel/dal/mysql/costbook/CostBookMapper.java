package cn.acsm.module.production.tunnel.dal.mysql.costbook;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.production.tunnel.dal.dataobject.costbook.CostBookDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.tunnel.controller.admin.costbook.vo.*;

/**
 * 地块账本 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CostBookMapper extends BaseMapperX<CostBookDO> {

    default PageResult<CostBookDO> selectPage(CostBookPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CostBookDO>()
                .eqIfPresent(CostBookDO::getCostCode, reqVO.getCostCode())
                .eqIfPresent(CostBookDO::getCostSource, reqVO.getCostSource())
                .eqIfPresent(CostBookDO::getEntityId, reqVO.getEntityId())
                .eqIfPresent(CostBookDO::getCostType, reqVO.getCostType())
                .likeIfPresent(CostBookDO::getAccountName, reqVO.getAccountName())
                .eqIfPresent(CostBookDO::getAccountInfo, reqVO.getAccountInfo())
                .eqIfPresent(CostBookDO::getAccountAmount, reqVO.getAccountAmount())
                .betweenIfPresent(CostBookDO::getAccountTime, reqVO.getAccountTime())
                .eqIfPresent(CostBookDO::getAccountLocation, reqVO.getAccountLocation())
                .betweenIfPresent(CostBookDO::getAccountingTime, reqVO.getAccountingTime())
                .eqIfPresent(CostBookDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(CostBookDO::getCounter, reqVO.getCounter())
                .eqIfPresent(CostBookDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(CostBookDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(CostBookDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(CostBookDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(CostBookDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(CostBookDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(CostBookDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(CostBookDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(CostBookDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(CostBookDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(CostBookDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(CostBookDO::getSource, reqVO.getSource())
                .eqIfPresent(CostBookDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(CostBookDO::getId));
    }

    default List<CostBookDO> selectList(CostBookExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CostBookDO>()
                .eqIfPresent(CostBookDO::getCostCode, reqVO.getCostCode())
                .eqIfPresent(CostBookDO::getCostSource, reqVO.getCostSource())
                .eqIfPresent(CostBookDO::getEntityId, reqVO.getEntityId())
                .eqIfPresent(CostBookDO::getCostType, reqVO.getCostType())
                .likeIfPresent(CostBookDO::getAccountName, reqVO.getAccountName())
                .eqIfPresent(CostBookDO::getAccountInfo, reqVO.getAccountInfo())
                .eqIfPresent(CostBookDO::getAccountAmount, reqVO.getAccountAmount())
                .betweenIfPresent(CostBookDO::getAccountTime, reqVO.getAccountTime())
                .eqIfPresent(CostBookDO::getAccountLocation, reqVO.getAccountLocation())
                .betweenIfPresent(CostBookDO::getAccountingTime, reqVO.getAccountingTime())
                .eqIfPresent(CostBookDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(CostBookDO::getCounter, reqVO.getCounter())
                .eqIfPresent(CostBookDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(CostBookDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(CostBookDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(CostBookDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(CostBookDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(CostBookDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(CostBookDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(CostBookDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(CostBookDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(CostBookDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(CostBookDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(CostBookDO::getSource, reqVO.getSource())
                .eqIfPresent(CostBookDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(CostBookDO::getId));
    }

}
