package cn.acsm.module.resource.dal.mysql.adoptcontenthealth;

import java.util.*;

import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthExportReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthPageReqVO;
import cn.acsm.module.resource.dal.dataobject.adoptcontenthealth.AdoptContentHealthDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 服务资源-认养物/租凭物就医记录 Mapper
 *
 * @author smile
 */
@Mapper
public interface AdoptContentHealthMapper extends BaseMapperX<AdoptContentHealthDO> {

    default PageResult<AdoptContentHealthDO> selectPage(AdoptContentHealthPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AdoptContentHealthDO>()
                .eqIfPresent(AdoptContentHealthDO::getAdoptContentId, reqVO.getAdoptContentId())
                .eqIfPresent(AdoptContentHealthDO::getType, reqVO.getType())
                .eqIfPresent(AdoptContentHealthDO::getAssessment, reqVO.getAssessment())
                .eqIfPresent(AdoptContentHealthDO::getAssessmenter, reqVO.getAssessmenter())
                .eqIfPresent(AdoptContentHealthDO::getAssessmentResult, reqVO.getAssessmentResult())
                .eqIfPresent(AdoptContentHealthDO::getDescription, reqVO.getDescription())
                .likeIfPresent(AdoptContentHealthDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(AdoptContentHealthDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AdoptContentHealthDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AdoptContentHealthDO::getSource, reqVO.getSource())
                .eqIfPresent(AdoptContentHealthDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AdoptContentHealthDO::getId));
    }

    default List<AdoptContentHealthDO> selectList(AdoptContentHealthExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<AdoptContentHealthDO>()
                .eqIfPresent(AdoptContentHealthDO::getAdoptContentId, reqVO.getAdoptContentId())
                .eqIfPresent(AdoptContentHealthDO::getType, reqVO.getType())
                .eqIfPresent(AdoptContentHealthDO::getAssessment, reqVO.getAssessment())
                .eqIfPresent(AdoptContentHealthDO::getAssessmenter, reqVO.getAssessmenter())
                .eqIfPresent(AdoptContentHealthDO::getAssessmentResult, reqVO.getAssessmentResult())
                .eqIfPresent(AdoptContentHealthDO::getDescription, reqVO.getDescription())
                .likeIfPresent(AdoptContentHealthDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(AdoptContentHealthDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AdoptContentHealthDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AdoptContentHealthDO::getSource, reqVO.getSource())
                .eqIfPresent(AdoptContentHealthDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AdoptContentHealthDO::getId));
    }

}
