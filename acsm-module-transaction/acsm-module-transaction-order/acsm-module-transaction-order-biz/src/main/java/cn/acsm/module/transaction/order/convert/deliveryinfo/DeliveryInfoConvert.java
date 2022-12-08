package cn.acsm.module.transaction.order.convert.deliveryinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.order.controller.admin.deliveryinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.deliveryinfo.DeliveryInfoDO;

/**
 * 配送 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface DeliveryInfoConvert {

    DeliveryInfoConvert INSTANCE = Mappers.getMapper(DeliveryInfoConvert.class);

    DeliveryInfoDO convert(DeliveryInfoCreateReqVO bean);

    DeliveryInfoDO convert(DeliveryInfoUpdateReqVO bean);

    DeliveryInfoRespVO convert(DeliveryInfoDO bean);

    List<DeliveryInfoRespVO> convertList(List<DeliveryInfoDO> list);

    PageResult<DeliveryInfoRespVO> convertPage(PageResult<DeliveryInfoDO> page);

    List<DeliveryInfoExcelVO> convertList02(List<DeliveryInfoDO> list);

}
