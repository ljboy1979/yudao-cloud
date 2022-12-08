package cn.acsm.module.transaction.order.convert.reserveinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.order.controller.admin.reserveinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.reserveinfo.ReserveInfoDO;

/**
 * 预定订单 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ReserveInfoConvert {

    ReserveInfoConvert INSTANCE = Mappers.getMapper(ReserveInfoConvert.class);

    ReserveInfoDO convert(ReserveInfoCreateReqVO bean);

    ReserveInfoDO convert(ReserveInfoUpdateReqVO bean);

    ReserveInfoRespVO convert(ReserveInfoDO bean);

    List<ReserveInfoRespVO> convertList(List<ReserveInfoDO> list);

    PageResult<ReserveInfoRespVO> convertPage(PageResult<ReserveInfoDO> page);

    List<ReserveInfoExcelVO> convertList02(List<ReserveInfoDO> list);

}
