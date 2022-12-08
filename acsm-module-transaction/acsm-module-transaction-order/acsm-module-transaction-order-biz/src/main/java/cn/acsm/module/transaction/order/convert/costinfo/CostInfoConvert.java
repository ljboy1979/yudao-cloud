package cn.acsm.module.transaction.order.convert.costinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.order.controller.admin.costinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.costinfo.CostInfoDO;

/**
 * 费用 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface CostInfoConvert {

    CostInfoConvert INSTANCE = Mappers.getMapper(CostInfoConvert.class);

    CostInfoDO convert(CostInfoCreateReqVO bean);

    CostInfoDO convert(CostInfoUpdateReqVO bean);

    CostInfoRespVO convert(CostInfoDO bean);

    List<CostInfoRespVO> convertList(List<CostInfoDO> list);

    PageResult<CostInfoRespVO> convertPage(PageResult<CostInfoDO> page);

    List<CostInfoExcelVO> convertList02(List<CostInfoDO> list);

}
