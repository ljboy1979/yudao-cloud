package cn.acsm.module.service.convert.serviceadoptinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.service.controller.admin.serviceadoptinfo.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceadoptinfo.ServiceAdoptInfoDO;

/**
 * 认养信息 Convert
 *
 * @author smile
 */
@Mapper
public interface ServiceAdoptInfoConvert {

    ServiceAdoptInfoConvert INSTANCE = Mappers.getMapper(ServiceAdoptInfoConvert.class);

    ServiceAdoptInfoDO convert(ServiceAdoptInfoCreateReqVO bean);

    ServiceAdoptInfoDO convert(ServiceAdoptInfoUpdateReqVO bean);

    ServiceAdoptInfoRespVO convert(ServiceAdoptInfoDO bean);

    List<ServiceAdoptInfoRespVO> convertList(List<ServiceAdoptInfoDO> list);

    PageResult<ServiceAdoptInfoRespVO> convertPage(PageResult<ServiceAdoptInfoDO> page);

    List<ServiceAdoptInfoExcelVO> convertList02(List<ServiceAdoptInfoDO> list);

}
