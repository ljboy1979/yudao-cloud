package cn.acsm.module.transaction.pricetag.convert.marketprice;

import java.util.*;

import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.MarketPriceInfoDO;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.PriceTrendDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.pricetag.controller.admin.marketprice.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.MarketPriceDO;

/**
 * 市场价格 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface MarketPriceConvert {

    MarketPriceConvert INSTANCE = Mappers.getMapper(MarketPriceConvert.class);

    MarketPriceDO convert(MarketPriceCreateReqVO bean);

    MarketPriceDO convert(MarketPriceUpdateReqVO bean);

    MarketPriceRespVO convert(MarketPriceDO bean);

    List<MarketPriceRespVO> convertList(List<MarketPriceDO> list);

    PageResult<MarketPriceRespVO> convertPage(PageResult<MarketPriceDO> page);

    List<MarketPriceExcelVO> convertList02(List<MarketPriceDO> list);

    MarketPriceInfoVo convertPriceInfoDO(MarketPriceInfoDO marketPriceInfo);

    List<PriceTrendVO> convertPriceTrendDO(List<PriceTrendDO> priceTrendDOS);
}
