package cn.acsm.module.resource.convert.maintenancerecord;

import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordCreateReqVO;
import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordExcelVO;
import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordRespVO;
import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordUpdateReqVO;
import cn.acsm.module.resource.dal.dataobject.maintenancerecord.MaintenanceRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 服务资源-养护记录 Convert
 *
 * @author smile
 */
@Mapper
public interface MaintenanceRecordConvert {

    MaintenanceRecordConvert INSTANCE = Mappers.getMapper(MaintenanceRecordConvert.class);

    MaintenanceRecordDO convert(MaintenanceRecordCreateReqVO bean);

    MaintenanceRecordDO convert(MaintenanceRecordUpdateReqVO bean);

    MaintenanceRecordRespVO convert(MaintenanceRecordDO bean);

    List<MaintenanceRecordRespVO> convertList(List<MaintenanceRecordDO> list);

    PageResult<MaintenanceRecordRespVO> convertPage(PageResult<MaintenanceRecordDO> page);

    List<MaintenanceRecordExcelVO> convertList02(List<MaintenanceRecordDO> list);

}
