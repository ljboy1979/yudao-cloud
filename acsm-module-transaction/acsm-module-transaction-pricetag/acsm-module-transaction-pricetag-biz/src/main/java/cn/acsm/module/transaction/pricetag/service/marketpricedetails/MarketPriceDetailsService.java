package cn.acsm.module.transaction.pricetag.service.marketpricedetails;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.pricetag.controller.admin.marketpricedetails.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketpricedetails.MarketPriceDetailsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 市场价格明细 Service 接口
 *
 * @author 芋道源码
 */
public interface MarketPriceDetailsService {

    /**
     * 创建市场价格明细
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createMarketPriceDetails(@Valid MarketPriceDetailsCreateReqVO createReqVO);

    /**
     * 更新市场价格明细
     *
     * @param updateReqVO 更新信息
     */
    void updateMarketPriceDetails(@Valid MarketPriceDetailsUpdateReqVO updateReqVO);

    /**
     * 删除市场价格明细
     *
     * @param id 编号
     */
    void deleteMarketPriceDetails(String id);

    /**
     * 获得市场价格明细
     *
     * @param id 编号
     * @return 市场价格明细
     */
    MarketPriceDetailsDO getMarketPriceDetails(String id);

    /**
     * 获得市场价格明细列表
     *
     * @param ids 编号
     * @return 市场价格明细列表
     */
    List<MarketPriceDetailsDO> getMarketPriceDetailsList(Collection<String> ids);

    /**
     * 获得市场价格明细分页
     *
     * @param pageReqVO 分页查询
     * @return 市场价格明细分页
     */
    PageResult<MarketPriceDetailsDO> getMarketPriceDetailsPage(MarketPriceDetailsPageReqVO pageReqVO);

    /**
     * 获得市场价格明细列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 市场价格明细列表
     */
    List<MarketPriceDetailsDO> getMarketPriceDetailsList(MarketPriceDetailsExportReqVO exportReqVO);

}
