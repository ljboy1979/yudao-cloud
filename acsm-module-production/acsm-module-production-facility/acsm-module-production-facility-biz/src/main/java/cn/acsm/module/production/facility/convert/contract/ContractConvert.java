package cn.acsm.module.production.facility.convert.contract;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.facility.controller.admin.contract.vo.*;
import cn.acsm.module.production.facility.dal.dataobject.contract.ContractDO;

/**
 * 租赁合同 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ContractConvert {

    ContractConvert INSTANCE = Mappers.getMapper(ContractConvert.class);

    ContractDO convert(ContractCreateReqVO bean);

    ContractDO convert(ContractUpdateReqVO bean);

    ContractRespVO convert(ContractDO bean);

    List<ContractRespVO> convertList(List<ContractDO> list);

    PageResult<ContractRespVO> convertPage(PageResult<ContractDO> page);

    List<ContractExcelVO> convertList02(List<ContractDO> list);

}
