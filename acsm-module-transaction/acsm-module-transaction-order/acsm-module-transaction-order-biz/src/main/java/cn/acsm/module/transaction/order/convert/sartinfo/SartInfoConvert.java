package cn.acsm.module.transaction.order.convert.sartinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.order.controller.admin.sartinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.sartinfo.SartInfoDO;

/**
 * 购物车 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface SartInfoConvert {

    SartInfoConvert INSTANCE = Mappers.getMapper(SartInfoConvert.class);

    SartInfoDO convert(SartInfoCreateReqVO bean);

    SartInfoDO convert(SartInfoUpdateReqVO bean);

    SartInfoRespVO convert(SartInfoDO bean);

    List<SartInfoRespVO> convertList(List<SartInfoDO> list);

    PageResult<SartInfoRespVO> convertPage(PageResult<SartInfoDO> page);

    List<SartInfoExcelVO> convertList02(List<SartInfoDO> list);

}
