package cn.acsm.module.production.devices.convert.access;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.devices.controller.admin.access.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.access.AccessDO;

/**
 * 设备允许访问名单信息 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface AccessConvert {

    AccessConvert INSTANCE = Mappers.getMapper(AccessConvert.class);

    AccessDO convert(AccessCreateReqVO bean);

    AccessDO convert(AccessUpdateReqVO bean);

    AccessRespVO convert(AccessDO bean);

    List<AccessRespVO> convertList(List<AccessDO> list);

    PageResult<AccessRespVO> convertPage(PageResult<AccessDO> page);

    List<AccessExcelVO> convertList02(List<AccessDO> list);

}
