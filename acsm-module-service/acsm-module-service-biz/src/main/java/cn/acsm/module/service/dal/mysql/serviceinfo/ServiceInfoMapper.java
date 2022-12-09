package cn.acsm.module.service.dal.mysql.serviceinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.service.dal.dataobject.serviceinfo.ServiceInfoDO;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.service.controller.admin.serviceinfo.vo.*;

/**
 * 服务 Mapper
 *
 * @author smile
 */
@Mapper
public interface ServiceInfoMapper extends BaseMapperX<ServiceInfoDO> {

    default PageResult<ServiceInfoDO> selectPage(ServiceInfoPageReqVO reqVO) {
        LambdaQueryWrapperX<ServiceInfoDO> lambdaQueryWrapperX = new LambdaQueryWrapperX<ServiceInfoDO>()
                .eqIfPresent(ServiceInfoDO::getServiceCode, reqVO.getServiceCode())
                .likeIfPresent(ServiceInfoDO::getServiceName, reqVO.getServiceName())
                .eqIfPresent(ServiceInfoDO::getServiceType, reqVO.getServiceType())
                .eqIfPresent(ServiceInfoDO::getServiceProvider, reqVO.getServiceProvider())
                .eqIfPresent(ServiceInfoDO::getContent, reqVO.getContent())
                .eqIfPresent(ServiceInfoDO::getServicePayer, reqVO.getServicePayer())
                .betweenIfPresent(ServiceInfoDO::getStartTime, reqVO.getStartTime())
                .betweenIfPresent(ServiceInfoDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(ServiceInfoDO::getState, reqVO.getState())
                .eqIfPresent(ServiceInfoDO::getInduFacilityInfoId, reqVO.getInduFacilityInfoId())
                .eqIfPresent(ServiceInfoDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(ServiceInfoDO::getTunnelInfoId, reqVO.getTunnelInfoId())
                .eqIfPresent(ServiceInfoDO::getDevicesId, reqVO.getDevicesId())
                .eqIfPresent(ServiceInfoDO::getInduSubjectInfoId, reqVO.getInduSubjectInfoId())
                .eqIfPresent(ServiceInfoDO::getCarrierId, reqVO.getCarrierId())
                .likeIfPresent(ServiceInfoDO::getChildrenTableName, reqVO.getChildrenTableName())
                .eqIfPresent(ServiceInfoDO::getServiceFee, reqVO.getServiceFee())
                .eqIfPresent(ServiceInfoDO::getCategoryId, reqVO.getCategoryId())
                .betweenIfPresent(ServiceInfoDO::getAvailableTime, reqVO.getAvailableTime())
                .eqIfPresent(ServiceInfoDO::getFarmType, reqVO.getFarmType())
                .eqIfPresent(ServiceInfoDO::getIntroduce, reqVO.getIntroduce())
                .eqIfPresent(ServiceInfoDO::getAddress, reqVO.getAddress())
                .eqIfPresent(ServiceInfoDO::getRotationImgs, reqVO.getRotationImgs())
                .eqIfPresent(ServiceInfoDO::getDetailsImgs, reqVO.getDetailsImgs())
                .eqIfPresent(ServiceInfoDO::getMaxAttendPeople, reqVO.getMaxAttendPeople())
                .eqIfPresent(ServiceInfoDO::getAttendPeople, reqVO.getAttendPeople())
                .eqIfPresent(ServiceInfoDO::getBasesId, reqVO.getBasesId())
                .likeIfPresent(ServiceInfoDO::getBasesName, reqVO.getBasesName())
                .eqIfPresent(ServiceInfoDO::getPlantNum, reqVO.getPlantNum())
                .eqIfPresent(ServiceInfoDO::getPlantCropIds, reqVO.getPlantCropIds())
                .eqIfPresent(ServiceInfoDO::getLabel, reqVO.getLabel())
                .eqIfPresent(ServiceInfoDO::getCollectNum, reqVO.getCollectNum())
                .eqIfPresent(ServiceInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ServiceInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ServiceInfoDO::getSource, reqVO.getSource())
                .orderByDesc(ServiceInfoDO::getId);
        if(!StringUtils.isEmpty(reqVO.getServiceIds())){
            lambdaQueryWrapperX.inSql(ServiceInfoDO::getId, reqVO.getServiceIds());
        }
        return selectPage(reqVO, lambdaQueryWrapperX);
    }

    default List<ServiceInfoDO> selectList(ServiceInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ServiceInfoDO>()
                .eqIfPresent(ServiceInfoDO::getServiceCode, reqVO.getServiceCode())
                .likeIfPresent(ServiceInfoDO::getServiceName, reqVO.getServiceName())
                .eqIfPresent(ServiceInfoDO::getServiceType, reqVO.getServiceType())
                .eqIfPresent(ServiceInfoDO::getServiceProvider, reqVO.getServiceProvider())
                .eqIfPresent(ServiceInfoDO::getContent, reqVO.getContent())
                .eqIfPresent(ServiceInfoDO::getServicePayer, reqVO.getServicePayer())
                .betweenIfPresent(ServiceInfoDO::getStartTime, reqVO.getStartTime())
                .betweenIfPresent(ServiceInfoDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(ServiceInfoDO::getState, reqVO.getState())
                .eqIfPresent(ServiceInfoDO::getInduFacilityInfoId, reqVO.getInduFacilityInfoId())
                .eqIfPresent(ServiceInfoDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(ServiceInfoDO::getTunnelInfoId, reqVO.getTunnelInfoId())
                .eqIfPresent(ServiceInfoDO::getDevicesId, reqVO.getDevicesId())
                .eqIfPresent(ServiceInfoDO::getInduSubjectInfoId, reqVO.getInduSubjectInfoId())
                .eqIfPresent(ServiceInfoDO::getCarrierId, reqVO.getCarrierId())
                .likeIfPresent(ServiceInfoDO::getChildrenTableName, reqVO.getChildrenTableName())
                .eqIfPresent(ServiceInfoDO::getServiceFee, reqVO.getServiceFee())
                .eqIfPresent(ServiceInfoDO::getCategoryId, reqVO.getCategoryId())
                .betweenIfPresent(ServiceInfoDO::getAvailableTime, reqVO.getAvailableTime())
                .eqIfPresent(ServiceInfoDO::getFarmType, reqVO.getFarmType())
                .eqIfPresent(ServiceInfoDO::getIntroduce, reqVO.getIntroduce())
                .eqIfPresent(ServiceInfoDO::getAddress, reqVO.getAddress())
                .eqIfPresent(ServiceInfoDO::getRotationImgs, reqVO.getRotationImgs())
                .eqIfPresent(ServiceInfoDO::getDetailsImgs, reqVO.getDetailsImgs())
                .eqIfPresent(ServiceInfoDO::getMaxAttendPeople, reqVO.getMaxAttendPeople())
                .eqIfPresent(ServiceInfoDO::getAttendPeople, reqVO.getAttendPeople())
                .eqIfPresent(ServiceInfoDO::getBasesId, reqVO.getBasesId())
                .likeIfPresent(ServiceInfoDO::getBasesName, reqVO.getBasesName())
                .eqIfPresent(ServiceInfoDO::getPlantNum, reqVO.getPlantNum())
                .eqIfPresent(ServiceInfoDO::getPlantCropIds, reqVO.getPlantCropIds())
                .eqIfPresent(ServiceInfoDO::getLabel, reqVO.getLabel())
                .eqIfPresent(ServiceInfoDO::getCollectNum, reqVO.getCollectNum())
                .eqIfPresent(ServiceInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ServiceInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ServiceInfoDO::getSource, reqVO.getSource())
                .orderByDesc(ServiceInfoDO::getId));
    }

}
