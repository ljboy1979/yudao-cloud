package cn.acsm.module.production.devices.dal.mysql.time;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.production.devices.dal.dataobject.time.TimeDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.devices.controller.admin.time.vo.*;

/**
 * 设备运行时间 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface TimeMapper extends BaseMapperX<TimeDO> {

    default PageResult<TimeDO> selectPage(TimePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TimeDO>()
                .eqIfPresent(TimeDO::getDeviceSn, reqVO.getDeviceSn())
                .eqIfPresent(TimeDO::getOnline, reqVO.getOnline())
                .betweenIfPresent(TimeDO::getDevicesDate, reqVO.getDevicesDate())
                .eqIfPresent(TimeDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(TimeDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(TimeDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(TimeDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(TimeDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(TimeDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(TimeDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(TimeDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(TimeDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(TimeDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(TimeDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(TimeDO::getSource, reqVO.getSource())
                .eqIfPresent(TimeDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(TimeDO::getId));
    }

    default List<TimeDO> selectList(TimeExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<TimeDO>()
                .eqIfPresent(TimeDO::getDeviceSn, reqVO.getDeviceSn())
                .eqIfPresent(TimeDO::getOnline, reqVO.getOnline())
                .betweenIfPresent(TimeDO::getDevicesDate, reqVO.getDevicesDate())
                .eqIfPresent(TimeDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(TimeDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(TimeDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(TimeDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(TimeDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(TimeDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(TimeDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(TimeDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(TimeDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(TimeDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(TimeDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(TimeDO::getSource, reqVO.getSource())
                .eqIfPresent(TimeDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(TimeDO::getId));
    }

}
