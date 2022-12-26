package cn.acsm.module.transaction.shelves.service.stockclassify;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.shelves.controller.admin.stockclassify.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.stockclassify.StockClassifyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;

/**
 * 库存分类 Service 接口
 *
 * @author 芋道源码
 */
public interface StockClassifyService {

    /**
     * 创建库存分类
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createStockClassify(@Valid StockClassifyCreateReqVO createReqVO);

    /**
     * 更新库存分类
     *
     * @param updateReqVO 更新信息
     */
    void updateStockClassify(@Valid StockClassifyUpdateReqVO updateReqVO);

    /**
     * 删除库存分类
     *
     * @param id 编号
     */
    void deleteStockClassify(String id);

    /**
     * 获得库存分类
     *
     * @param id 编号
     * @return 库存分类
     */
    StockClassifyDO getStockClassify(String id);

    /**
     * 获得库存分类列表
     *
     * @param ids 编号
     * @return 库存分类列表
     */
    List<StockClassifyDO> getStockClassifyList(Collection<String> ids);

    /**
     * 获得库存分类分页
     *
     * @param pageReqVO 分页查询
     * @return 库存分类分页
     */
    PageResult<StockClassifyDO> getStockClassifyPage(StockClassifyPageReqVO pageReqVO);

    /**
     * 获得库存分类列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 库存分类列表
     */
    List<StockClassifyDO> getStockClassifyList(StockClassifyExportReqVO exportReqVO);

    List<TreeSelect> findTreeList(StockClassifyTreeVO stockClassifyTreeVO);

    List<StockClassifyRespVO> findClassifyList(StockClassifyTreeVO stockClassifyTreeVO);
}
