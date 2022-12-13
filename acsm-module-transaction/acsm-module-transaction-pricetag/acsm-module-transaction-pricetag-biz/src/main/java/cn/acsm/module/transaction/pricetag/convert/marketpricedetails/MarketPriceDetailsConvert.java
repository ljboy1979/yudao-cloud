package cn.acsm.module.transaction.pricetag.convert.marketpricedetails;

import java.util.*;

import cn.acsm.module.transaction.pricetag.api.dto.MarketPriceDetailsDto;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.pricetag.controller.admin.marketpricedetails.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketpricedetails.MarketPriceDetailsDO;

/**
 * 市场价格明细 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface MarketPriceDetailsConvert {

    MarketPriceDetailsConvert INSTANCE = Mappers.getMapper(MarketPriceDetailsConvert.class);

    MarketPriceDetailsDO convert(MarketPriceDetailsCreateReqVO bean);

    MarketPriceDetailsDO convert(MarketPriceDetailsUpdateReqVO bean);

    MarketPriceDetailsRespVO convert(MarketPriceDetailsDO bean);

    List<MarketPriceDetailsRespVO> convertList(List<MarketPriceDetailsDO> list);

    PageResult<MarketPriceDetailsRespVO> convertPage(PageResult<MarketPriceDetailsDO> page);

    List<MarketPriceDetailsExcelVO> convertList02(List<MarketPriceDetailsDO> list);

    MarketPriceDetailsDO convertDto(MarketPriceDetailsDto marketPriceDetailsDto);
}
