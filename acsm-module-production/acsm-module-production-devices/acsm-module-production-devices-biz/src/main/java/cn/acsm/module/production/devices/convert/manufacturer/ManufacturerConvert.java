package cn.acsm.module.production.devices.convert.manufacturer;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.devices.controller.admin.manufacturer.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.manufacturer.ManufacturerDO;

/**
 * 设备厂家 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ManufacturerConvert {

    ManufacturerConvert INSTANCE = Mappers.getMapper(ManufacturerConvert.class);

    ManufacturerDO convert(ManufacturerCreateReqVO bean);

    ManufacturerDO convert(ManufacturerUpdateReqVO bean);

    ManufacturerRespVO convert(ManufacturerDO bean);

    List<ManufacturerRespVO> convertList(List<ManufacturerDO> list);

    PageResult<ManufacturerRespVO> convertPage(PageResult<ManufacturerDO> page);

    List<ManufacturerExcelVO> convertList02(List<ManufacturerDO> list);

}
