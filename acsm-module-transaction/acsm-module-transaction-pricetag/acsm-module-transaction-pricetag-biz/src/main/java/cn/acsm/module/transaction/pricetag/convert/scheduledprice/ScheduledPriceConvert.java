package cn.acsm.module.transaction.pricetag.convert.scheduledprice;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.pricetag.controller.admin.scheduledprice.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.scheduledprice.ScheduledPriceDO;

/**
 * 预定价格 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ScheduledPriceConvert {

    ScheduledPriceConvert INSTANCE = Mappers.getMapper(ScheduledPriceConvert.class);

    ScheduledPriceDO convert(ScheduledPriceCreateReqVO bean);

    ScheduledPriceDO convert(ScheduledPriceUpdateReqVO bean);

    ScheduledPriceRespVO convert(ScheduledPriceDO bean);

    List<ScheduledPriceRespVO> convertList(List<ScheduledPriceDO> list);

    PageResult<ScheduledPriceRespVO> convertPage(PageResult<ScheduledPriceDO> page);

    List<ScheduledPriceExcelVO> convertList02(List<ScheduledPriceDO> list);

}
