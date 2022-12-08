package cn.acsm.module.transaction.order.convert.orderinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.order.controller.admin.orderinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.orderinfo.OrderInfoDO;

/**
 * 订单 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface OrderInfoConvert {

    OrderInfoConvert INSTANCE = Mappers.getMapper(OrderInfoConvert.class);

    OrderInfoDO convert(OrderInfoCreateReqVO bean);

    OrderInfoDO convert(OrderInfoUpdateReqVO bean);

    OrderInfoRespVO convert(OrderInfoDO bean);

    List<OrderInfoRespVO> convertList(List<OrderInfoDO> list);

    PageResult<OrderInfoRespVO> convertPage(PageResult<OrderInfoDO> page);

    List<OrderInfoExcelVO> convertList02(List<OrderInfoDO> list);

}
