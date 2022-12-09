package cn.acsm.module.service.dal.mysql.serviceadoptinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.service.dal.dataobject.serviceadoptinfo.ServiceAdoptInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.service.controller.admin.serviceadoptinfo.vo.*;

/**
 * 认养信息 Mapper
 *
 * @author smile
 */
@Mapper
public interface ServiceAdoptInfoMapper extends BaseMapperX<ServiceAdoptInfoDO> {

    default PageResult<ServiceAdoptInfoDO> selectPage(ServiceAdoptInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ServiceAdoptInfoDO>()
                .eqIfPresent(ServiceAdoptInfoDO::getServiceId, reqVO.getServiceId())
                .eqIfPresent(ServiceAdoptInfoDO::getTunnelId, reqVO.getTunnelId())
                .eqIfPresent(ServiceAdoptInfoDO::getAdoptId, reqVO.getAdoptId())
                .eqIfPresent(ServiceAdoptInfoDO::getUserId, reqVO.getUserId())
                .eqIfPresent(ServiceAdoptInfoDO::getAdoptStatus, reqVO.getAdoptStatus())
                .eqIfPresent(ServiceAdoptInfoDO::getFamilyId, reqVO.getFamilyId())
                .eqIfPresent(ServiceAdoptInfoDO::getPlantCropId, reqVO.getPlantCropId())
                .eqIfPresent(ServiceAdoptInfoDO::getPlantCropNum, reqVO.getPlantCropNum())
                .eqIfPresent(ServiceAdoptInfoDO::getBasesId, reqVO.getBasesId())
                .eqIfPresent(ServiceAdoptInfoDO::getPartitionsId, reqVO.getPartitionsId())
                .eqIfPresent(ServiceAdoptInfoDO::getCarrierId, reqVO.getCarrierId())
                .eqIfPresent(ServiceAdoptInfoDO::getApplyNum, reqVO.getApplyNum())
                .eqIfPresent(ServiceAdoptInfoDO::getApplySubNum, reqVO.getApplySubNum())
                .eqIfPresent(ServiceAdoptInfoDO::getAdoptType, reqVO.getAdoptType())
                .eqIfPresent(ServiceAdoptInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ServiceAdoptInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ServiceAdoptInfoDO::getSource, reqVO.getSource())
                .orderByDesc(ServiceAdoptInfoDO::getId));
    }

    default List<ServiceAdoptInfoDO> selectList(ServiceAdoptInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ServiceAdoptInfoDO>()
                .eqIfPresent(ServiceAdoptInfoDO::getServiceId, reqVO.getServiceId())
                .eqIfPresent(ServiceAdoptInfoDO::getTunnelId, reqVO.getTunnelId())
                .eqIfPresent(ServiceAdoptInfoDO::getAdoptId, reqVO.getAdoptId())
                .eqIfPresent(ServiceAdoptInfoDO::getUserId, reqVO.getUserId())
                .eqIfPresent(ServiceAdoptInfoDO::getAdoptStatus, reqVO.getAdoptStatus())
                .eqIfPresent(ServiceAdoptInfoDO::getFamilyId, reqVO.getFamilyId())
                .eqIfPresent(ServiceAdoptInfoDO::getPlantCropId, reqVO.getPlantCropId())
                .eqIfPresent(ServiceAdoptInfoDO::getPlantCropNum, reqVO.getPlantCropNum())
                .eqIfPresent(ServiceAdoptInfoDO::getBasesId, reqVO.getBasesId())
                .eqIfPresent(ServiceAdoptInfoDO::getPartitionsId, reqVO.getPartitionsId())
                .eqIfPresent(ServiceAdoptInfoDO::getCarrierId, reqVO.getCarrierId())
                .eqIfPresent(ServiceAdoptInfoDO::getApplyNum, reqVO.getApplyNum())
                .eqIfPresent(ServiceAdoptInfoDO::getApplySubNum, reqVO.getApplySubNum())
                .eqIfPresent(ServiceAdoptInfoDO::getAdoptType, reqVO.getAdoptType())
                .eqIfPresent(ServiceAdoptInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ServiceAdoptInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ServiceAdoptInfoDO::getSource, reqVO.getSource())
                .orderByDesc(ServiceAdoptInfoDO::getId));
    }

}
