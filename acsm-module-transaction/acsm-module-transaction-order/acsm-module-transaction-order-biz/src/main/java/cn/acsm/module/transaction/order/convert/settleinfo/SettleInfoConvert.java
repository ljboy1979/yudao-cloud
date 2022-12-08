package cn.acsm.module.transaction.order.convert.settleinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.order.controller.admin.settleinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.settleinfo.SettleInfoDO;

/**
 * 订单结账 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface SettleInfoConvert {

    SettleInfoConvert INSTANCE = Mappers.getMapper(SettleInfoConvert.class);

    SettleInfoDO convert(SettleInfoCreateReqVO bean);

    SettleInfoDO convert(SettleInfoUpdateReqVO bean);

    SettleInfoRespVO convert(SettleInfoDO bean);

    List<SettleInfoRespVO> convertList(List<SettleInfoDO> list);

    PageResult<SettleInfoRespVO> convertPage(PageResult<SettleInfoDO> page);

    List<SettleInfoExcelVO> convertList02(List<SettleInfoDO> list);

}
