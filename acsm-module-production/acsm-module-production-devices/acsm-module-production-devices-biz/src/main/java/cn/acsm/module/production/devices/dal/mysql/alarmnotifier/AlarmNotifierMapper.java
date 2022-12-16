package cn.acsm.module.production.devices.dal.mysql.alarmnotifier;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.production.devices.dal.dataobject.alarmnotifier.AlarmNotifierDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.devices.controller.admin.alarmnotifier.vo.*;

/**
 * 告警通知规则 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface AlarmNotifierMapper extends BaseMapperX<AlarmNotifierDO> {

    default PageResult<AlarmNotifierDO> selectPage(AlarmNotifierPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AlarmNotifierDO>()
                .eqIfPresent(AlarmNotifierDO::getNumber, reqVO.getNumber())
                .eqIfPresent(AlarmNotifierDO::getAlarmType, reqVO.getAlarmType())
                .eqIfPresent(AlarmNotifierDO::getNotifyType, reqVO.getNotifyType())
                .eqIfPresent(AlarmNotifierDO::getNotifier, reqVO.getNotifier())
                .eqIfPresent(AlarmNotifierDO::getMobile, reqVO.getMobile())
                .eqIfPresent(AlarmNotifierDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(AlarmNotifierDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(AlarmNotifierDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(AlarmNotifierDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(AlarmNotifierDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(AlarmNotifierDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(AlarmNotifierDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(AlarmNotifierDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(AlarmNotifierDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(AlarmNotifierDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(AlarmNotifierDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AlarmNotifierDO::getSource, reqVO.getSource())
                .eqIfPresent(AlarmNotifierDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AlarmNotifierDO::getId));
    }

    default List<AlarmNotifierDO> selectList(AlarmNotifierExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<AlarmNotifierDO>()
                .eqIfPresent(AlarmNotifierDO::getNumber, reqVO.getNumber())
                .eqIfPresent(AlarmNotifierDO::getAlarmType, reqVO.getAlarmType())
                .eqIfPresent(AlarmNotifierDO::getNotifyType, reqVO.getNotifyType())
                .eqIfPresent(AlarmNotifierDO::getNotifier, reqVO.getNotifier())
                .eqIfPresent(AlarmNotifierDO::getMobile, reqVO.getMobile())
                .eqIfPresent(AlarmNotifierDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(AlarmNotifierDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(AlarmNotifierDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(AlarmNotifierDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(AlarmNotifierDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(AlarmNotifierDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(AlarmNotifierDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(AlarmNotifierDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(AlarmNotifierDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(AlarmNotifierDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(AlarmNotifierDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AlarmNotifierDO::getSource, reqVO.getSource())
                .eqIfPresent(AlarmNotifierDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AlarmNotifierDO::getId));
    }

}
