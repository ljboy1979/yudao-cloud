package cn.acsm.module.production.devices.convert.model;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.devices.controller.admin.model.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.model.ModelDO;

/**
 * 设备型号 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ModelConvert {

    ModelConvert INSTANCE = Mappers.getMapper(ModelConvert.class);

    ModelDO convert(ModelCreateReqVO bean);

    ModelDO convert(ModelUpdateReqVO bean);

    ModelRespVO convert(ModelDO bean);

    List<ModelRespVO> convertList(List<ModelDO> list);

    PageResult<ModelRespVO> convertPage(PageResult<ModelDO> page);

    List<ModelExcelVO> convertList02(List<ModelDO> list);

}
