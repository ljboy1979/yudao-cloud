package cn.acsm.module.production.devices.convert.info;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.devices.controller.admin.info.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.info.InfoDO;

/**
 * 设备 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface InfoConvert {

    InfoConvert INSTANCE = Mappers.getMapper(InfoConvert.class);

    InfoDO convert(InfoCreateReqVO bean);

    InfoDO convert(InfoUpdateReqVO bean);

    InfoRespVO convert(InfoDO bean);

    List<InfoRespVO> convertList(List<InfoDO> list);

    PageResult<InfoRespVO> convertPage(PageResult<InfoDO> page);

    List<InfoExcelVO> convertList02(List<InfoDO> list);

}
