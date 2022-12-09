package cn.acsm.module.service.convert.serviceorder;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.service.controller.admin.serviceorder.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceorder.ServiceOrderDO;

/**
 * 服务交易单 Convert
 *
 * @author smile
 */
@Mapper
public interface ServiceOrderConvert {

    ServiceOrderConvert INSTANCE = Mappers.getMapper(ServiceOrderConvert.class);

    ServiceOrderDO convert(ServiceOrderCreateReqVO bean);

    ServiceOrderDO convert(ServiceOrderUpdateReqVO bean);

    ServiceOrderRespVO convert(ServiceOrderDO bean);

    List<ServiceOrderRespVO> convertList(List<ServiceOrderDO> list);

    PageResult<ServiceOrderRespVO> convertPage(PageResult<ServiceOrderDO> page);

    List<ServiceOrderExcelVO> convertList02(List<ServiceOrderDO> list);

}
