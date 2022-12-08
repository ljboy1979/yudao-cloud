package cn.acsm.module.transaction.order.convert.deliverydetails;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.order.controller.admin.deliverydetails.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.deliverydetails.DeliveryDetailsDO;

/**
 * 配送详情 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface DeliveryDetailsConvert {

    DeliveryDetailsConvert INSTANCE = Mappers.getMapper(DeliveryDetailsConvert.class);

    DeliveryDetailsDO convert(DeliveryDetailsCreateReqVO bean);

    DeliveryDetailsDO convert(DeliveryDetailsUpdateReqVO bean);

    DeliveryDetailsRespVO convert(DeliveryDetailsDO bean);

    List<DeliveryDetailsRespVO> convertList(List<DeliveryDetailsDO> list);

    PageResult<DeliveryDetailsRespVO> convertPage(PageResult<DeliveryDetailsDO> page);

    List<DeliveryDetailsExcelVO> convertList02(List<DeliveryDetailsDO> list);

}
