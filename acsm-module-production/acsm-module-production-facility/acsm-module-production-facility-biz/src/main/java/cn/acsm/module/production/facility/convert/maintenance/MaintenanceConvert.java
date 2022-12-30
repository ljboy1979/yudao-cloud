package cn.acsm.module.production.facility.convert.maintenance;

import cn.acsm.module.production.facility.controller.admin.maintenance.vo.MaintenanceCreateReqVO;
import cn.acsm.module.production.facility.controller.admin.maintenance.vo.MaintenanceExcelVO;
import cn.acsm.module.production.facility.controller.admin.maintenance.vo.MaintenanceRespVO;
import cn.acsm.module.production.facility.controller.admin.maintenance.vo.MaintenanceUpdateReqVO;
import cn.acsm.module.production.facility.dal.dataobject.maintenance.MaintenanceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 设施维护记录 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface MaintenanceConvert {

    MaintenanceConvert INSTANCE = Mappers.getMapper(MaintenanceConvert.class);

    MaintenanceDO convert(MaintenanceCreateReqVO bean);

    MaintenanceDO convert(MaintenanceUpdateReqVO bean);

    MaintenanceRespVO convert(MaintenanceDO bean);

    List<MaintenanceRespVO> convertList(List<MaintenanceDO> list);

    PageResult<MaintenanceRespVO> convertPage(PageResult<MaintenanceDO> page);

    List<MaintenanceExcelVO> convertList02(List<MaintenanceDO> list);

}
