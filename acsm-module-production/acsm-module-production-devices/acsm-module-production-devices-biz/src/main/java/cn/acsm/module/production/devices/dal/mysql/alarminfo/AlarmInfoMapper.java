package cn.acsm.module.production.devices.dal.mysql.alarminfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.production.devices.dal.dataobject.alarminfo.AlarmInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.devices.controller.admin.alarminfo.vo.*;

/**
 * 告警信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface AlarmInfoMapper extends BaseMapperX<AlarmInfoDO> {

    default PageResult<AlarmInfoDO> selectPage(AlarmInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AlarmInfoDO>()
                .eqIfPresent(AlarmInfoDO::getNumber, reqVO.getNumber())
                .eqIfPresent(AlarmInfoDO::getAlarmType, reqVO.getAlarmType())
                .eqIfPresent(AlarmInfoDO::getAlarmSource, reqVO.getAlarmSource())
                .eqIfPresent(AlarmInfoDO::getAlarmContent, reqVO.getAlarmContent())
                .betweenIfPresent(AlarmInfoDO::getHappenDate, reqVO.getHappenDate())
                .eqIfPresent(AlarmInfoDO::getHappenPlace, reqVO.getHappenPlace())
                .eqIfPresent(AlarmInfoDO::getNotifiers, reqVO.getNotifiers())
                .eqIfPresent(AlarmInfoDO::getHandleStatus, reqVO.getHandleStatus())
                .eqIfPresent(AlarmInfoDO::getHandleContent, reqVO.getHandleContent())
                .eqIfPresent(AlarmInfoDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(AlarmInfoDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(AlarmInfoDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(AlarmInfoDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(AlarmInfoDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(AlarmInfoDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(AlarmInfoDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(AlarmInfoDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(AlarmInfoDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(AlarmInfoDO::getCorpName, reqVO.getCorpName())
                .eqIfPresent(AlarmInfoDO::getDevicesId, reqVO.getDevicesId())
                .likeIfPresent(AlarmInfoDO::getDeviceName, reqVO.getDeviceName())
                .eqIfPresent(AlarmInfoDO::getDeviceSn, reqVO.getDeviceSn())
                .likeIfPresent(AlarmInfoDO::getSubjectName, reqVO.getSubjectName())
                .eqIfPresent(AlarmInfoDO::getSilenceHour, reqVO.getSilenceHour())
                .eqIfPresent(AlarmInfoDO::getSilenceExpiry, reqVO.getSilenceExpiry())
                .betweenIfPresent(AlarmInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AlarmInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(AlarmInfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AlarmInfoDO::getId));
    }

    default List<AlarmInfoDO> selectList(AlarmInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<AlarmInfoDO>()
                .eqIfPresent(AlarmInfoDO::getNumber, reqVO.getNumber())
                .eqIfPresent(AlarmInfoDO::getAlarmType, reqVO.getAlarmType())
                .eqIfPresent(AlarmInfoDO::getAlarmSource, reqVO.getAlarmSource())
                .eqIfPresent(AlarmInfoDO::getAlarmContent, reqVO.getAlarmContent())
                .betweenIfPresent(AlarmInfoDO::getHappenDate, reqVO.getHappenDate())
                .eqIfPresent(AlarmInfoDO::getHappenPlace, reqVO.getHappenPlace())
                .eqIfPresent(AlarmInfoDO::getNotifiers, reqVO.getNotifiers())
                .eqIfPresent(AlarmInfoDO::getHandleStatus, reqVO.getHandleStatus())
                .eqIfPresent(AlarmInfoDO::getHandleContent, reqVO.getHandleContent())
                .eqIfPresent(AlarmInfoDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(AlarmInfoDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(AlarmInfoDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(AlarmInfoDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(AlarmInfoDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(AlarmInfoDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(AlarmInfoDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(AlarmInfoDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(AlarmInfoDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(AlarmInfoDO::getCorpName, reqVO.getCorpName())
                .eqIfPresent(AlarmInfoDO::getDevicesId, reqVO.getDevicesId())
                .likeIfPresent(AlarmInfoDO::getDeviceName, reqVO.getDeviceName())
                .eqIfPresent(AlarmInfoDO::getDeviceSn, reqVO.getDeviceSn())
                .likeIfPresent(AlarmInfoDO::getSubjectName, reqVO.getSubjectName())
                .eqIfPresent(AlarmInfoDO::getSilenceHour, reqVO.getSilenceHour())
                .eqIfPresent(AlarmInfoDO::getSilenceExpiry, reqVO.getSilenceExpiry())
                .betweenIfPresent(AlarmInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AlarmInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(AlarmInfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AlarmInfoDO::getId));
    }

}
