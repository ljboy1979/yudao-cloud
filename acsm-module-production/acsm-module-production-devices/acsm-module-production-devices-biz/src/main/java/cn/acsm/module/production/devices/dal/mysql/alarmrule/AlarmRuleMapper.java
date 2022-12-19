package cn.acsm.module.production.devices.dal.mysql.alarmrule;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.production.devices.dal.dataobject.alarmrule.AlarmRuleDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.devices.controller.admin.alarmrule.vo.*;

/**
 * 告警规则 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface AlarmRuleMapper extends BaseMapperX<AlarmRuleDO> {

    default PageResult<AlarmRuleDO> selectPage(AlarmRulePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AlarmRuleDO>()
                .eqIfPresent(AlarmRuleDO::getDeviceId, reqVO.getDeviceId())
                .eqIfPresent(AlarmRuleDO::getParamId, reqVO.getParamId())
                .eqIfPresent(AlarmRuleDO::getAlarmType, reqVO.getAlarmType())
                .eqIfPresent(AlarmRuleDO::getAlarmUp, reqVO.getAlarmUp())
                .eqIfPresent(AlarmRuleDO::getAlarmDown, reqVO.getAlarmDown())
                .eqIfPresent(AlarmRuleDO::getAlarmContent, reqVO.getAlarmContent())
                .eqIfPresent(AlarmRuleDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(AlarmRuleDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(AlarmRuleDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(AlarmRuleDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(AlarmRuleDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(AlarmRuleDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(AlarmRuleDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(AlarmRuleDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(AlarmRuleDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(AlarmRuleDO::getCorpName, reqVO.getCorpName())
                .likeIfPresent(AlarmRuleDO::getParamName, reqVO.getParamName())
                .betweenIfPresent(AlarmRuleDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AlarmRuleDO::getSource, reqVO.getSource())
                .eqIfPresent(AlarmRuleDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AlarmRuleDO::getId));
    }

    default List<AlarmRuleDO> selectList(AlarmRuleExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<AlarmRuleDO>()
                .eqIfPresent(AlarmRuleDO::getDeviceId, reqVO.getDeviceId())
                .eqIfPresent(AlarmRuleDO::getParamId, reqVO.getParamId())
                .eqIfPresent(AlarmRuleDO::getAlarmType, reqVO.getAlarmType())
                .eqIfPresent(AlarmRuleDO::getAlarmUp, reqVO.getAlarmUp())
                .eqIfPresent(AlarmRuleDO::getAlarmDown, reqVO.getAlarmDown())
                .eqIfPresent(AlarmRuleDO::getAlarmContent, reqVO.getAlarmContent())
                .eqIfPresent(AlarmRuleDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(AlarmRuleDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(AlarmRuleDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(AlarmRuleDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(AlarmRuleDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(AlarmRuleDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(AlarmRuleDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(AlarmRuleDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(AlarmRuleDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(AlarmRuleDO::getCorpName, reqVO.getCorpName())
                .likeIfPresent(AlarmRuleDO::getParamName, reqVO.getParamName())
                .betweenIfPresent(AlarmRuleDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AlarmRuleDO::getSource, reqVO.getSource())
                .eqIfPresent(AlarmRuleDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AlarmRuleDO::getId));
    }

}
