package cn.acsm.module.transaction.pricetag.service.marketclassify;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.pricetag.controller.admin.marketclassify.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketclassify.MarketClassifyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;

/**
 * 市场分类 Service 接口
 *
 * @author 芋道源码
 */
public interface MarketClassifyService {

    /**
     * 创建市场分类
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createMarketClassify(@Valid MarketClassifyCreateReqVO createReqVO);

    /**
     * 更新市场分类
     *
     * @param updateReqVO 更新信息
     */
    void updateMarketClassify(@Valid MarketClassifyUpdateReqVO updateReqVO);

    /**
     * 删除市场分类
     *
     * @param id 编号
     */
    void deleteMarketClassify(String id);

    /**
     * 获得市场分类
     *
     * @param id 编号
     * @return 市场分类
     */
    MarketClassifyDO getMarketClassify(String id);

    /**
     * 获得市场分类列表
     *
     * @param ids 编号
     * @return 市场分类列表
     */
    List<MarketClassifyDO> getMarketClassifyList(Collection<String> ids);

    /**
     * 获得市场分类分页
     *
     * @param pageReqVO 分页查询
     * @return 市场分类分页
     */
    PageResult<MarketClassifyDO> getMarketClassifyPage(MarketClassifyPageReqVO pageReqVO);

    /**
     * 获得市场分类列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 市场分类列表
     */
    List<MarketClassifyDO> getMarketClassifyList(MarketClassifyExportReqVO exportReqVO);

    List<TreeSelect> findTreeList(MarketClassifyTreeVO marketClassifyTreeVO);
}
