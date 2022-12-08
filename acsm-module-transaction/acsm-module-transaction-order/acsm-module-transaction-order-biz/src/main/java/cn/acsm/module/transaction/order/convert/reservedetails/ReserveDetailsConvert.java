package cn.acsm.module.transaction.order.convert.reservedetails;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.order.controller.admin.reservedetails.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.reservedetails.ReserveDetailsDO;

/**
 * 订单预定详情 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ReserveDetailsConvert {

    ReserveDetailsConvert INSTANCE = Mappers.getMapper(ReserveDetailsConvert.class);

    ReserveDetailsDO convert(ReserveDetailsCreateReqVO bean);

    ReserveDetailsDO convert(ReserveDetailsUpdateReqVO bean);

    ReserveDetailsRespVO convert(ReserveDetailsDO bean);

    List<ReserveDetailsRespVO> convertList(List<ReserveDetailsDO> list);

    PageResult<ReserveDetailsRespVO> convertPage(PageResult<ReserveDetailsDO> page);

    List<ReserveDetailsExcelVO> convertList02(List<ReserveDetailsDO> list);

}
