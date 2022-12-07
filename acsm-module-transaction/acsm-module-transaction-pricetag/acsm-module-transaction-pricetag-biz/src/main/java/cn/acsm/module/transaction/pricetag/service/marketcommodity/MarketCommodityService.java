package cn.acsm.module.transaction.pricetag.service.marketcommodity;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.pricetag.controller.admin.marketcommodity.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketcommodity.MarketCommodityDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;

/**
 * 市场商品 Service 接口
 *
 * @author 芋道源码
 */
public interface MarketCommodityService {

    /**
     * 创建市场商品
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createMarketCommodity(@Valid MarketCommodityCreateReqVO createReqVO);

    /**
     * 更新市场商品
     *
     * @param updateReqVO 更新信息
     */
    void updateMarketCommodity(@Valid MarketCommodityUpdateReqVO updateReqVO);

    /**
     * 删除市场商品
     *
     * @param id 编号
     */
    void deleteMarketCommodity(String id);

    /**
     * 获得市场商品
     *
     * @param id 编号
     * @return 市场商品
     */
    MarketCommodityDO getMarketCommodity(String id);

    /**
     * 获得市场商品列表
     *
     * @param ids 编号
     * @return 市场商品列表
     */
    List<MarketCommodityDO> getMarketCommodityList(Collection<String> ids);

    /**
     * 获得市场商品分页
     *
     * @param pageReqVO 分页查询
     * @return 市场商品分页
     */
    PageResult<MarketCommodityDO> getMarketCommodityPage(MarketCommodityPageReqVO pageReqVO);

    /**
     * 获得市场商品列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 市场商品列表
     */
    List<MarketCommodityDO> getMarketCommodityList(MarketCommodityExportReqVO exportReqVO);

    List<PriceTagShelvesRespVo> findShelves(PriceTagShelvesReqVo shelvesReqVO);

    List<PriceTagShelvesRespVo> findSpecifications(PriceTagShelvesReqVo shelvesReqVO);

    List<TreeSelectVo> findTreeList(PriceTagShelvesReqVo shelvesReqVO);
}
