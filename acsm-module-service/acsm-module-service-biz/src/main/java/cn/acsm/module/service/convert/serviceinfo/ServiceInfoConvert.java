package cn.acsm.module.service.convert.serviceinfo;

import java.util.*;

import cn.acsm.module.service.api.serviceinfo.dto.ServiceInfoRespDTO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.service.controller.admin.serviceinfo.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceinfo.ServiceInfoDO;

/**
 * 服务 Convert
 *
 * @author smile
 */
@Mapper
public interface ServiceInfoConvert {

    ServiceInfoConvert INSTANCE = Mappers.getMapper(ServiceInfoConvert.class);

    ServiceInfoDO convert(ServiceInfoCreateReqVO bean);

    ServiceInfoDO convert(ServiceInfoUpdateReqVO bean);

    ServiceInfoRespVO convert(ServiceInfoDO bean);

    List<ServiceInfoRespVO> convertList(List<ServiceInfoDO> list);

    PageResult<ServiceInfoRespVO> convertPage(PageResult<ServiceInfoDO> page);

    List<ServiceInfoExcelVO> convertList02(List<ServiceInfoDO> list);

    ServiceInfoRespDTO convert01(ServiceInfoRespVO bean);

}
