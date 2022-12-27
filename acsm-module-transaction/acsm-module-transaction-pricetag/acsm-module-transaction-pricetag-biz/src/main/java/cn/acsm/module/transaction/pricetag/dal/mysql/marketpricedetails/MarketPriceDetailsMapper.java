package cn.acsm.module.transaction.pricetag.dal.mysql.marketpricedetails;

import java.util.*;

import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.MarketPriceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketpricedetails.MarketPriceDetailsDO;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.pricetag.controller.admin.marketpricedetails.vo.*;

/**
 * 市场价格明细 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MarketPriceDetailsMapper extends BaseMapperX<MarketPriceDetailsDO> {

    default PageResult<MarketPriceDetailsDO> selectPage(MarketPriceDetailsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MarketPriceDetailsDO>()
                .eqIfPresent(MarketPriceDetailsDO::getMarketPriceId, reqVO.getMarketPriceId())
                .betweenIfPresent(MarketPriceDetailsDO::getUpdateTime, reqVO.getUpdateTime())
                .orderByDesc(MarketPriceDetailsDO::getId));
    }

    default List<MarketPriceDetailsDO> selectList(MarketPriceDetailsExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MarketPriceDetailsDO>()
                .eqIfPresent(MarketPriceDetailsDO::getMarketPriceId, reqVO.getMarketPriceId())
                .betweenIfPresent(MarketPriceDetailsDO::getUpdateTime, reqVO.getUpdateTime())
                .orderByDesc(MarketPriceDetailsDO::getId));
    }


    MarketPriceDO findPriceByPriceId(String id);
}
