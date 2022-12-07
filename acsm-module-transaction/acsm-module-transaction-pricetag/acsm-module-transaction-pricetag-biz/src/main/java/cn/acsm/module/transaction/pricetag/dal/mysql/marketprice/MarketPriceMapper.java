package cn.acsm.module.transaction.pricetag.dal.mysql.marketprice;

import java.util.*;

import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.MarketPriceInfoDO;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.PriceTrendDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.MarketPriceDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.pricetag.controller.admin.marketprice.vo.*;

/**
 * 市场价格 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MarketPriceMapper extends BaseMapperX<MarketPriceDO> {

    default PageResult<MarketPriceDO> selectPage(MarketPricePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MarketPriceDO>()
                .eqIfPresent(MarketPriceDO::getCode, reqVO.getCode())
                .eqIfPresent(MarketPriceDO::getMarketCommodityId, reqVO.getMarketCommodityId())
                .eqIfPresent(MarketPriceDO::getMaxPrice, reqVO.getMaxPrice())
                .eqIfPresent(MarketPriceDO::getMinPrice, reqVO.getMinPrice())
                .eqIfPresent(MarketPriceDO::getMiddlePrice, reqVO.getMiddlePrice())
                .eqIfPresent(MarketPriceDO::getSource, reqVO.getSource())
                .eqIfPresent(MarketPriceDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(MarketPriceDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(MarketPriceDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(MarketPriceDO::getId));
    }

    default List<MarketPriceDO> selectList(MarketPriceExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MarketPriceDO>()
                .eqIfPresent(MarketPriceDO::getCode, reqVO.getCode())
                .eqIfPresent(MarketPriceDO::getMarketCommodityId, reqVO.getMarketCommodityId())
                .eqIfPresent(MarketPriceDO::getMaxPrice, reqVO.getMaxPrice())
                .eqIfPresent(MarketPriceDO::getMinPrice, reqVO.getMinPrice())
                .eqIfPresent(MarketPriceDO::getMiddlePrice, reqVO.getMiddlePrice())
                .eqIfPresent(MarketPriceDO::getSource, reqVO.getSource())
                .eqIfPresent(MarketPriceDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(MarketPriceDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(MarketPriceDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(MarketPriceDO::getId));
    }

    List<PriceTrendDO> findPriceTrend(String id);

    MarketPriceInfoDO getMarketPriceInfo(String id);
}
