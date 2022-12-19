package cn.acsm.module.production.devices.convert.alarminfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.devices.controller.admin.alarminfo.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.alarminfo.AlarmInfoDO;

/**
 * 告警信息 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface AlarmInfoConvert {

    AlarmInfoConvert INSTANCE = Mappers.getMapper(AlarmInfoConvert.class);

    AlarmInfoDO convert(AlarmInfoCreateReqVO bean);

    AlarmInfoDO convert(AlarmInfoUpdateReqVO bean);

    AlarmInfoRespVO convert(AlarmInfoDO bean);

    List<AlarmInfoRespVO> convertList(List<AlarmInfoDO> list);

    PageResult<AlarmInfoRespVO> convertPage(PageResult<AlarmInfoDO> page);

    List<AlarmInfoExcelVO> convertList02(List<AlarmInfoDO> list);

}
