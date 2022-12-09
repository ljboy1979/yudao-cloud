package cn.acsm.module.service.convert.serviceinfocarrier;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.service.controller.admin.serviceinfocarrier.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceinfocarrier.ServiceInfoCarrierDO;

/**
 * 服务-认养物/租凭物 Convert
 *
 * @author smile
 */
@Mapper
public interface ServiceInfoCarrierConvert {

    ServiceInfoCarrierConvert INSTANCE = Mappers.getMapper(ServiceInfoCarrierConvert.class);

    ServiceInfoCarrierDO convert(ServiceInfoCarrierCreateReqVO bean);

    ServiceInfoCarrierDO convert(ServiceInfoCarrierUpdateReqVO bean);

    ServiceInfoCarrierRespVO convert(ServiceInfoCarrierDO bean);

    List<ServiceInfoCarrierRespVO> convertList(List<ServiceInfoCarrierDO> list);

    PageResult<ServiceInfoCarrierRespVO> convertPage(PageResult<ServiceInfoCarrierDO> page);

    List<ServiceInfoCarrierExcelVO> convertList02(List<ServiceInfoCarrierDO> list);

}
