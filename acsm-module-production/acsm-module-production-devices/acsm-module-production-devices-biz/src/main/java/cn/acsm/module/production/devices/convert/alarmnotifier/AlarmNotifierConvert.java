package cn.acsm.module.production.devices.convert.alarmnotifier;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.devices.controller.admin.alarmnotifier.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.alarmnotifier.AlarmNotifierDO;

/**
 * 告警通知规则 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface AlarmNotifierConvert {

    AlarmNotifierConvert INSTANCE = Mappers.getMapper(AlarmNotifierConvert.class);

    AlarmNotifierDO convert(AlarmNotifierCreateReqVO bean);

    AlarmNotifierDO convert(AlarmNotifierUpdateReqVO bean);

    AlarmNotifierRespVO convert(AlarmNotifierDO bean);

    List<AlarmNotifierRespVO> convertList(List<AlarmNotifierDO> list);

    PageResult<AlarmNotifierRespVO> convertPage(PageResult<AlarmNotifierDO> page);

    List<AlarmNotifierExcelVO> convertList02(List<AlarmNotifierDO> list);

}
