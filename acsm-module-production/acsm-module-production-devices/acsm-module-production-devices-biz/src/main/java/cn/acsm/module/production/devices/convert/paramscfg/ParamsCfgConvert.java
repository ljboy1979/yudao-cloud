package cn.acsm.module.production.devices.convert.paramscfg;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.devices.controller.admin.paramscfg.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.paramscfg.ParamsCfgDO;

/**
 * 设备参数配置 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ParamsCfgConvert {

    ParamsCfgConvert INSTANCE = Mappers.getMapper(ParamsCfgConvert.class);

    ParamsCfgDO convert(ParamsCfgCreateReqVO bean);

    ParamsCfgDO convert(ParamsCfgUpdateReqVO bean);

    ParamsCfgRespVO convert(ParamsCfgDO bean);

    List<ParamsCfgRespVO> convertList(List<ParamsCfgDO> list);

    PageResult<ParamsCfgRespVO> convertPage(PageResult<ParamsCfgDO> page);

    List<ParamsCfgExcelVO> convertList02(List<ParamsCfgDO> list);

}
