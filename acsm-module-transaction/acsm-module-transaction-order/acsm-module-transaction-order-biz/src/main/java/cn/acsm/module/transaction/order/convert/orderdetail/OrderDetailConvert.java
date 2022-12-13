package cn.acsm.module.transaction.order.convert.orderdetail;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.order.controller.admin.orderdetail.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.orderdetail.OrderDetailDO;

/**
 * 订单详情 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface OrderDetailConvert {

    OrderDetailConvert INSTANCE = Mappers.getMapper(OrderDetailConvert.class);

    OrderDetailDO convert(OrderDetailCreateReqVO bean);

    OrderDetailDO convert(OrderDetailUpdateReqVO bean);

    OrderDetailRespVO convert(OrderDetailDO bean);

    List<OrderDetailRespVO> convertList(List<OrderDetailDO> list);

    PageResult<OrderDetailRespVO> convertPage(PageResult<OrderDetailDO> page);

    List<OrderDetailExcelVO> convertList02(List<OrderDetailDO> list);

}
