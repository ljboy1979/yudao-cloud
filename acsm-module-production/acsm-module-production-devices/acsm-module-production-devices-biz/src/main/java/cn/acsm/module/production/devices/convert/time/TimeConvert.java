package cn.acsm.module.production.devices.convert.time;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.devices.controller.admin.time.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.time.TimeDO;

/**
 * 设备运行时间 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface TimeConvert {

    TimeConvert INSTANCE = Mappers.getMapper(TimeConvert.class);

    TimeDO convert(TimeCreateReqVO bean);

    TimeDO convert(TimeUpdateReqVO bean);

    TimeRespVO convert(TimeDO bean);

    List<TimeRespVO> convertList(List<TimeDO> list);

    PageResult<TimeRespVO> convertPage(PageResult<TimeDO> page);

    List<TimeExcelVO> convertList02(List<TimeDO> list);

}
