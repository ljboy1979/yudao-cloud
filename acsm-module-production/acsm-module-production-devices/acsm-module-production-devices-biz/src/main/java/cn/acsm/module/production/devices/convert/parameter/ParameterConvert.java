package cn.acsm.module.production.devices.convert.parameter;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.devices.controller.admin.parameter.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.parameter.ParameterDO;

/**
 * 设备表参数 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ParameterConvert {

    ParameterConvert INSTANCE = Mappers.getMapper(ParameterConvert.class);

    ParameterDO convert(ParameterCreateReqVO bean);

    ParameterDO convert(ParameterUpdateReqVO bean);

    ParameterRespVO convert(ParameterDO bean);

    List<ParameterRespVO> convertList(List<ParameterDO> list);

    PageResult<ParameterRespVO> convertPage(PageResult<ParameterDO> page);

    List<ParameterExcelVO> convertList02(List<ParameterDO> list);

}
