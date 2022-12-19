package cn.acsm.module.production.devices.dal.mysql.parameter;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.production.devices.dal.dataobject.parameter.ParameterDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.devices.controller.admin.parameter.vo.*;

/**
 * 设备表参数 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ParameterMapper extends BaseMapperX<ParameterDO> {

    default PageResult<ParameterDO> selectPage(ParameterPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ParameterDO>()
                .eqIfPresent(ParameterDO::getDeviceId, reqVO.getDeviceId())
                .eqIfPresent(ParameterDO::getParamDeviceIp, reqVO.getParamDeviceIp())
                .eqIfPresent(ParameterDO::getParamHttpPort, reqVO.getParamHttpPort())
                .eqIfPresent(ParameterDO::getParamDevicePort, reqVO.getParamDevicePort())
                .eqIfPresent(ParameterDO::getParamRtspPort, reqVO.getParamRtspPort())
                .likeIfPresent(ParameterDO::getParamDeviceUsername, reqVO.getParamDeviceUsername())
                .eqIfPresent(ParameterDO::getParamDevicePassword, reqVO.getParamDevicePassword())
                .eqIfPresent(ParameterDO::getParamChanelNum, reqVO.getParamChanelNum())
                .eqIfPresent(ParameterDO::getKingViewUrl, reqVO.getKingViewUrl())
                .eqIfPresent(ParameterDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(ParameterDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(ParameterDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(ParameterDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(ParameterDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(ParameterDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(ParameterDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(ParameterDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(ParameterDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(ParameterDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(ParameterDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(ParameterDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ParameterDO::getSource, reqVO.getSource())
                .eqIfPresent(ParameterDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ParameterDO::getId));
    }

    default List<ParameterDO> selectList(ParameterExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ParameterDO>()
                .eqIfPresent(ParameterDO::getDeviceId, reqVO.getDeviceId())
                .eqIfPresent(ParameterDO::getParamDeviceIp, reqVO.getParamDeviceIp())
                .eqIfPresent(ParameterDO::getParamHttpPort, reqVO.getParamHttpPort())
                .eqIfPresent(ParameterDO::getParamDevicePort, reqVO.getParamDevicePort())
                .eqIfPresent(ParameterDO::getParamRtspPort, reqVO.getParamRtspPort())
                .likeIfPresent(ParameterDO::getParamDeviceUsername, reqVO.getParamDeviceUsername())
                .eqIfPresent(ParameterDO::getParamDevicePassword, reqVO.getParamDevicePassword())
                .eqIfPresent(ParameterDO::getParamChanelNum, reqVO.getParamChanelNum())
                .eqIfPresent(ParameterDO::getKingViewUrl, reqVO.getKingViewUrl())
                .eqIfPresent(ParameterDO::getOfficeCode, reqVO.getOfficeCode())
                .likeIfPresent(ParameterDO::getOfficeName, reqVO.getOfficeName())
                .eqIfPresent(ParameterDO::getCompanyCode, reqVO.getCompanyCode())
                .likeIfPresent(ParameterDO::getCompanyName, reqVO.getCompanyName())
                .eqIfPresent(ParameterDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(ParameterDO::getReviewStatus, reqVO.getReviewStatus())
                .eqIfPresent(ParameterDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(ParameterDO::getReviewDate, reqVO.getReviewDate())
                .eqIfPresent(ParameterDO::getReviewContent, reqVO.getReviewContent())
                .eqIfPresent(ParameterDO::getCorpCode, reqVO.getCorpCode())
                .likeIfPresent(ParameterDO::getCorpName, reqVO.getCorpName())
                .betweenIfPresent(ParameterDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ParameterDO::getSource, reqVO.getSource())
                .eqIfPresent(ParameterDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ParameterDO::getId));
    }

}
