package cn.acsm.module.resource.dal.mysql.expertevaluation;

import java.util.*;

import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationExportReqVO;
import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationPageReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.resource.dal.dataobject.expertevaluation.ExpertEvaluationDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 健康状况 Mapper
 *
 * @author smile
 */
@Mapper
public interface ExpertEvaluationMapper extends BaseMapperX<ExpertEvaluationDO> {

    default PageResult<ExpertEvaluationDO> selectPage(ExpertEvaluationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExpertEvaluationDO>()
                .eqIfPresent(ExpertEvaluationDO::getEvaluationPerson, reqVO.getEvaluationPerson())
                .eqIfPresent(ExpertEvaluationDO::getExceptionItem, reqVO.getExceptionItem())
                .betweenIfPresent(ExpertEvaluationDO::getEvaluationTime, reqVO.getEvaluationTime())
                .eqIfPresent(ExpertEvaluationDO::getEvaluationResult, reqVO.getEvaluationResult())
                .eqIfPresent(ExpertEvaluationDO::getAdoptContentId, reqVO.getAdoptContentId())
                .eqIfPresent(ExpertEvaluationDO::getBehavior, reqVO.getBehavior())
                .eqIfPresent(ExpertEvaluationDO::getCoat, reqVO.getCoat())
                .eqIfPresent(ExpertEvaluationDO::getAppetite, reqVO.getAppetite())
                .eqIfPresent(ExpertEvaluationDO::getTeeth, reqVO.getTeeth())
                .eqIfPresent(ExpertEvaluationDO::getEyes, reqVO.getEyes())
                .eqIfPresent(ExpertEvaluationDO::getNose, reqVO.getNose())
                .eqIfPresent(ExpertEvaluationDO::getTrunk, reqVO.getTrunk())
                .eqIfPresent(ExpertEvaluationDO::getDefecation, reqVO.getDefecation())
                .eqIfPresent(ExpertEvaluationDO::getTemperature, reqVO.getTemperature())
                .eqIfPresent(ExpertEvaluationDO::getHeartbeat, reqVO.getHeartbeat())
                .eqIfPresent(ExpertEvaluationDO::getBreathing, reqVO.getBreathing())
                .eqIfPresent(ExpertEvaluationDO::getWeight, reqVO.getWeight())
                .eqIfPresent(ExpertEvaluationDO::getBehaviorContent, reqVO.getBehaviorContent())
                .eqIfPresent(ExpertEvaluationDO::getCoatContent, reqVO.getCoatContent())
                .eqIfPresent(ExpertEvaluationDO::getAppetiteContent, reqVO.getAppetiteContent())
                .eqIfPresent(ExpertEvaluationDO::getTeethContent, reqVO.getTeethContent())
                .eqIfPresent(ExpertEvaluationDO::getEyesContent, reqVO.getEyesContent())
                .eqIfPresent(ExpertEvaluationDO::getNoseContent, reqVO.getNoseContent())
                .eqIfPresent(ExpertEvaluationDO::getTrunkContent, reqVO.getTrunkContent())
                .eqIfPresent(ExpertEvaluationDO::getDefecationContent, reqVO.getDefecationContent())
                .eqIfPresent(ExpertEvaluationDO::getTemperatureContent, reqVO.getTemperatureContent())
                .eqIfPresent(ExpertEvaluationDO::getHeartbeatContent, reqVO.getHeartbeatContent())
                .eqIfPresent(ExpertEvaluationDO::getBreathingContent, reqVO.getBreathingContent())
                .eqIfPresent(ExpertEvaluationDO::getWeightContent, reqVO.getWeightContent())
                .eqIfPresent(ExpertEvaluationDO::getType, reqVO.getType())
                .eqIfPresent(ExpertEvaluationDO::getMicturition, reqVO.getMicturition())
                .eqIfPresent(ExpertEvaluationDO::getMicturitionContent, reqVO.getMicturitionContent())
                .eqIfPresent(ExpertEvaluationDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ExpertEvaluationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ExpertEvaluationDO::getSource, reqVO.getSource())
                .eqIfPresent(ExpertEvaluationDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ExpertEvaluationDO::getId));
    }

    default List<ExpertEvaluationDO> selectList(ExpertEvaluationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ExpertEvaluationDO>()
                .eqIfPresent(ExpertEvaluationDO::getEvaluationPerson, reqVO.getEvaluationPerson())
                .eqIfPresent(ExpertEvaluationDO::getExceptionItem, reqVO.getExceptionItem())
                .betweenIfPresent(ExpertEvaluationDO::getEvaluationTime, reqVO.getEvaluationTime())
                .eqIfPresent(ExpertEvaluationDO::getEvaluationResult, reqVO.getEvaluationResult())
                .eqIfPresent(ExpertEvaluationDO::getAdoptContentId, reqVO.getAdoptContentId())
                .eqIfPresent(ExpertEvaluationDO::getBehavior, reqVO.getBehavior())
                .eqIfPresent(ExpertEvaluationDO::getCoat, reqVO.getCoat())
                .eqIfPresent(ExpertEvaluationDO::getAppetite, reqVO.getAppetite())
                .eqIfPresent(ExpertEvaluationDO::getTeeth, reqVO.getTeeth())
                .eqIfPresent(ExpertEvaluationDO::getEyes, reqVO.getEyes())
                .eqIfPresent(ExpertEvaluationDO::getNose, reqVO.getNose())
                .eqIfPresent(ExpertEvaluationDO::getTrunk, reqVO.getTrunk())
                .eqIfPresent(ExpertEvaluationDO::getDefecation, reqVO.getDefecation())
                .eqIfPresent(ExpertEvaluationDO::getTemperature, reqVO.getTemperature())
                .eqIfPresent(ExpertEvaluationDO::getHeartbeat, reqVO.getHeartbeat())
                .eqIfPresent(ExpertEvaluationDO::getBreathing, reqVO.getBreathing())
                .eqIfPresent(ExpertEvaluationDO::getWeight, reqVO.getWeight())
                .eqIfPresent(ExpertEvaluationDO::getBehaviorContent, reqVO.getBehaviorContent())
                .eqIfPresent(ExpertEvaluationDO::getCoatContent, reqVO.getCoatContent())
                .eqIfPresent(ExpertEvaluationDO::getAppetiteContent, reqVO.getAppetiteContent())
                .eqIfPresent(ExpertEvaluationDO::getTeethContent, reqVO.getTeethContent())
                .eqIfPresent(ExpertEvaluationDO::getEyesContent, reqVO.getEyesContent())
                .eqIfPresent(ExpertEvaluationDO::getNoseContent, reqVO.getNoseContent())
                .eqIfPresent(ExpertEvaluationDO::getTrunkContent, reqVO.getTrunkContent())
                .eqIfPresent(ExpertEvaluationDO::getDefecationContent, reqVO.getDefecationContent())
                .eqIfPresent(ExpertEvaluationDO::getTemperatureContent, reqVO.getTemperatureContent())
                .eqIfPresent(ExpertEvaluationDO::getHeartbeatContent, reqVO.getHeartbeatContent())
                .eqIfPresent(ExpertEvaluationDO::getBreathingContent, reqVO.getBreathingContent())
                .eqIfPresent(ExpertEvaluationDO::getWeightContent, reqVO.getWeightContent())
                .eqIfPresent(ExpertEvaluationDO::getType, reqVO.getType())
                .eqIfPresent(ExpertEvaluationDO::getMicturition, reqVO.getMicturition())
                .eqIfPresent(ExpertEvaluationDO::getMicturitionContent, reqVO.getMicturitionContent())
                .eqIfPresent(ExpertEvaluationDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ExpertEvaluationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ExpertEvaluationDO::getSource, reqVO.getSource())
                .eqIfPresent(ExpertEvaluationDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ExpertEvaluationDO::getId));
    }

}
