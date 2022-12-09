package cn.acsm.module.service.dal.mysql.activitysession;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.service.dal.dataobject.activitysession.ActivitySessionDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.service.controller.admin.activitysession.vo.*;

/**
 * 时间排期 Mapper
 *
 * @author smile
 */
@Mapper
public interface ActivitySessionMapper extends BaseMapperX<ActivitySessionDO> {

    default PageResult<ActivitySessionDO> selectPage(ActivitySessionPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ActivitySessionDO>()
                .eqIfPresent(ActivitySessionDO::getMaxAttendPeople, reqVO.getMaxAttendPeople())
                .eqIfPresent(ActivitySessionDO::getAttendPeople, reqVO.getAttendPeople())
                .eqIfPresent(ActivitySessionDO::getRegistrationFee, reqVO.getRegistrationFee())
                .eqIfPresent(ActivitySessionDO::getActivityId, reqVO.getActivityId())
                .betweenIfPresent(ActivitySessionDO::getStartTime, reqVO.getStartTime())
                .eqIfPresent(ActivitySessionDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(ActivitySessionDO::getServiceId, reqVO.getServiceId())
                .betweenIfPresent(ActivitySessionDO::getStartDate, reqVO.getStartDate())
                .betweenIfPresent(ActivitySessionDO::getEndDate, reqVO.getEndDate())
                .betweenIfPresent(ActivitySessionDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(ActivitySessionDO::getBasesId, reqVO.getBasesId())
                .eqIfPresent(ActivitySessionDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ActivitySessionDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ActivitySessionDO::getSource, reqVO.getSource())
                .orderByDesc(ActivitySessionDO::getId));
    }

    default List<ActivitySessionDO> selectList(ActivitySessionExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ActivitySessionDO>()
                .eqIfPresent(ActivitySessionDO::getMaxAttendPeople, reqVO.getMaxAttendPeople())
                .eqIfPresent(ActivitySessionDO::getAttendPeople, reqVO.getAttendPeople())
                .eqIfPresent(ActivitySessionDO::getRegistrationFee, reqVO.getRegistrationFee())
                .eqIfPresent(ActivitySessionDO::getActivityId, reqVO.getActivityId())
                .betweenIfPresent(ActivitySessionDO::getStartTime, reqVO.getStartTime())
                .eqIfPresent(ActivitySessionDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(ActivitySessionDO::getServiceId, reqVO.getServiceId())
                .betweenIfPresent(ActivitySessionDO::getStartDate, reqVO.getStartDate())
                .betweenIfPresent(ActivitySessionDO::getEndDate, reqVO.getEndDate())
                .betweenIfPresent(ActivitySessionDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(ActivitySessionDO::getBasesId, reqVO.getBasesId())
                .eqIfPresent(ActivitySessionDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ActivitySessionDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ActivitySessionDO::getSource, reqVO.getSource())
                .orderByDesc(ActivitySessionDO::getId));
    }

}
