package cn.acsm.module.resource.dal.mysql.maintenancerecord;

import java.util.*;

import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordExportReqVO;
import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordPageReqVO;
import cn.acsm.module.resource.dal.dataobject.maintenancerecord.MaintenanceRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 服务资源-养护记录 Mapper
 *
 * @author smile
 */
@Mapper
public interface MaintenanceRecordMapper extends BaseMapperX<MaintenanceRecordDO> {

    default PageResult<MaintenanceRecordDO> selectPage(MaintenanceRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MaintenanceRecordDO>()
                .eqIfPresent(MaintenanceRecordDO::getServiceAdoptContentId, reqVO.getServiceAdoptContentId())
                .likeIfPresent(MaintenanceRecordDO::getMaintenanceName, reqVO.getMaintenanceName())
                .eqIfPresent(MaintenanceRecordDO::getContent, reqVO.getContent())
                .betweenIfPresent(MaintenanceRecordDO::getBeginTime, reqVO.getBeginTime())
                .betweenIfPresent(MaintenanceRecordDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(MaintenanceRecordDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(MaintenanceRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(MaintenanceRecordDO::getSource, reqVO.getSource())
                .eqIfPresent(MaintenanceRecordDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(MaintenanceRecordDO::getId));
    }

    default List<MaintenanceRecordDO> selectList(MaintenanceRecordExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MaintenanceRecordDO>()
                .eqIfPresent(MaintenanceRecordDO::getServiceAdoptContentId, reqVO.getServiceAdoptContentId())
                .likeIfPresent(MaintenanceRecordDO::getMaintenanceName, reqVO.getMaintenanceName())
                .eqIfPresent(MaintenanceRecordDO::getContent, reqVO.getContent())
                .betweenIfPresent(MaintenanceRecordDO::getBeginTime, reqVO.getBeginTime())
                .betweenIfPresent(MaintenanceRecordDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(MaintenanceRecordDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(MaintenanceRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(MaintenanceRecordDO::getSource, reqVO.getSource())
                .eqIfPresent(MaintenanceRecordDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(MaintenanceRecordDO::getId));
    }

}
