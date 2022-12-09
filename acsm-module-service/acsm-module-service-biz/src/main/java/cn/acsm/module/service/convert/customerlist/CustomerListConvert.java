package cn.acsm.module.service.convert.customerlist;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.service.controller.admin.customerlist.vo.*;
import cn.acsm.module.service.dal.dataobject.customerlist.CustomerListDO;

/**
 * 服务客户名单 Convert
 *
 * @author smile
 */
@Mapper
public interface CustomerListConvert {

    CustomerListConvert INSTANCE = Mappers.getMapper(CustomerListConvert.class);

    CustomerListDO convert(CustomerListCreateReqVO bean);

    CustomerListDO convert(CustomerListUpdateReqVO bean);

    CustomerListRespVO convert(CustomerListDO bean);

    List<CustomerListRespVO> convertList(List<CustomerListDO> list);

    PageResult<CustomerListRespVO> convertPage(PageResult<CustomerListDO> page);

    List<CustomerListExcelVO> convertList02(List<CustomerListDO> list);

}
