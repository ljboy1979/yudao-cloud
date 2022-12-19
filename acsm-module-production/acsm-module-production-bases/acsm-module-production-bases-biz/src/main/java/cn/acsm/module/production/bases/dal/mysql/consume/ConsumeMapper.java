package cn.acsm.module.production.bases.dal.mysql.consume;

import java.util.*;

import cn.acsm.module.production.bases.controller.admin.consume.vo.ConsumeExportReqVO;
import cn.acsm.module.production.bases.controller.admin.consume.vo.ConsumePageReqVO;
import cn.acsm.module.production.bases.dal.dataobject.consume.ConsumeDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.bases.controller.admin.consume.vo.*;

/**
 * 基地能耗信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ConsumeMapper extends BaseMapperX<ConsumeDO> {

    default PageResult<ConsumeDO> selectPage(ConsumePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ConsumeDO>()
                .eqIfPresent(ConsumeDO::getBasesId, reqVO.getBasesId())
                .eqIfPresent(ConsumeDO::getConsumeNum, reqVO.getConsumeNum())
                .eqIfPresent(ConsumeDO::getUnit, reqVO.getUnit())
                .betweenIfPresent(ConsumeDO::getInsertTime, reqVO.getInsertTime())
                .eqIfPresent(ConsumeDO::getConsumeType, reqVO.getConsumeType())
                .eqIfPresent(ConsumeDO::getSource, reqVO.getSource())
                .eqIfPresent(ConsumeDO::getStatus, reqVO.getStatus())
                .eqIfPresent(ConsumeDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(ConsumeDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(ConsumeDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(ConsumeDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(ConsumeDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(ConsumeDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(ConsumeDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(ConsumeDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(ConsumeDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(ConsumeDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(ConsumeDO::getCorpName, reqVO.getCorpName())
                .likeIfPresent(ConsumeDO::getParamName, reqVO.getParamName())
                .eqIfPresent(ConsumeDO::getParamUnit, reqVO.getParamUnit())
                .eqIfPresent(ConsumeDO::getNum, reqVO.getNum())
                .betweenIfPresent(ConsumeDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ConsumeDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ConsumeDO::getId));
    }

    default List<ConsumeDO> selectList(ConsumeExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ConsumeDO>()
                .eqIfPresent(ConsumeDO::getBasesId, reqVO.getBasesId())
                .eqIfPresent(ConsumeDO::getConsumeNum, reqVO.getConsumeNum())
                .eqIfPresent(ConsumeDO::getUnit, reqVO.getUnit())
                .betweenIfPresent(ConsumeDO::getInsertTime, reqVO.getInsertTime())
                .eqIfPresent(ConsumeDO::getConsumeType, reqVO.getConsumeType())
                .eqIfPresent(ConsumeDO::getSource, reqVO.getSource())
                .eqIfPresent(ConsumeDO::getStatus, reqVO.getStatus())
                .eqIfPresent(ConsumeDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(ConsumeDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(ConsumeDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(ConsumeDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(ConsumeDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(ConsumeDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(ConsumeDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(ConsumeDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(ConsumeDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(ConsumeDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(ConsumeDO::getCorpName, reqVO.getCorpName())
                .likeIfPresent(ConsumeDO::getParamName, reqVO.getParamName())
                .eqIfPresent(ConsumeDO::getParamUnit, reqVO.getParamUnit())
                .eqIfPresent(ConsumeDO::getNum, reqVO.getNum())
                .betweenIfPresent(ConsumeDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ConsumeDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ConsumeDO::getId));
    }

}
