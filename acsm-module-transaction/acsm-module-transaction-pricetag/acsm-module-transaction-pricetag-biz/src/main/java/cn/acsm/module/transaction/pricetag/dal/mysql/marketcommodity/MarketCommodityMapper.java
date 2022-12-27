package cn.acsm.module.transaction.pricetag.dal.mysql.marketcommodity;

import java.util.*;

import cn.acsm.module.transaction.pricetag.dal.dataobject.marketcommodity.MarketPriceFeignDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketcommodity.MarketCommodityDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.pricetag.controller.admin.marketcommodity.vo.*;

/**
 * 市场商品 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MarketCommodityMapper extends BaseMapperX<MarketCommodityDO> {

    default PageResult<MarketCommodityDO> selectPage(MarketCommodityPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MarketCommodityDO>()
                .eqIfPresent(MarketCommodityDO::getShelvesId, reqVO.getShelvesId())
                .eqIfPresent(MarketCommodityDO::getClassifyId, reqVO.getClassifyId())
                .eqIfPresent(MarketCommodityDO::getSpecificationId, reqVO.getSpecificationId())
                .likeIfPresent(MarketCommodityDO::getCommodityName, reqVO.getCommodityName())
                .likeIfPresent(MarketCommodityDO::getSpecificationsName, reqVO.getSpecificationsName())
                .betweenIfPresent(MarketCommodityDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MarketCommodityDO::getId));
    }

    default List<MarketCommodityDO> selectList(MarketCommodityExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MarketCommodityDO>()
                .eqIfPresent(MarketCommodityDO::getShelvesId, reqVO.getShelvesId())
                .eqIfPresent(MarketCommodityDO::getClassifyId, reqVO.getClassifyId())
                .eqIfPresent(MarketCommodityDO::getSpecificationId, reqVO.getSpecificationId())
                .likeIfPresent(MarketCommodityDO::getCommodityName, reqVO.getCommodityName())
                .likeIfPresent(MarketCommodityDO::getSpecificationsName, reqVO.getSpecificationsName())
                .betweenIfPresent(MarketCommodityDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MarketCommodityDO::getId));
    }

    List<MarketPriceFeignDO> getIdBySpecificationId(String id);
}
