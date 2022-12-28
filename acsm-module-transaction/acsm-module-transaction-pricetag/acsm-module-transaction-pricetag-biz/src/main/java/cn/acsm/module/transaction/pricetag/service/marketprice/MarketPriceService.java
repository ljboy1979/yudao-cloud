package cn.acsm.module.transaction.pricetag.service.marketprice;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.pricetag.controller.admin.marketprice.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.MarketPriceDO;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.MarketPriceInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 市场价格 Service 接口
 *
 * @author 芋道源码
 */
public interface MarketPriceService {

    /**
     * 创建市场价格
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createMarketPrice(@Valid MarketPriceCreateReqVO createReqVO);

    /**
     * 更新市场价格
     *
     * @param updateReqVO 更新信息
     */
    void updateMarketPrice(@Valid MarketPriceUpdateReqVO updateReqVO);

    /**
     * 删除市场价格
     *
     * @param id 编号
     */
    void deleteMarketPrice(String id);

    /**
     * 获得市场价格
     *
     * @param id 编号
     * @return 市场价格
     */
    MarketPriceDO getMarketPrice(String id);


    /**
     * 获得市场价格列表
     *
     * @param ids 编号
     * @return 市场价格列表
     */
    List<MarketPriceDO> getMarketPriceList(Collection<String> ids);

    /**
     * 获得市场价格分页
     *
     * @param pageReqVO 分页查询
     * @return 市场价格分页
     */
    PageResult<MarketPriceInfoDO> getMarketPricePage(MarketPricePageReqVO pageReqVO);

    /**
     * 获得市场价格列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 市场价格列表
     */
    List<MarketPriceDO> getMarketPriceList(MarketPriceExportReqVO exportReqVO);


    /**
     * 获得市场价格
     *
     * @param id 编号
     * @return 市场价格
     */
    MarketPriceInfoVo getMarketPriceInfo(String id);
}
