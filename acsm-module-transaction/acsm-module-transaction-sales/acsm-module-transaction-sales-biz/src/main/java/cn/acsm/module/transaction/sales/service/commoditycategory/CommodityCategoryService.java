package cn.acsm.module.transaction.sales.service.commoditycategory;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.transaction.sales.controller.admin.commoditycategory.vo.CommodityCategoryCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commoditycategory.vo.CommodityCategoryExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commoditycategory.vo.CommodityCategoryPageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commoditycategory.vo.CommodityCategoryUpdateReqVO;
import cn.acsm.module.transaction.sales.dal.dataobject.commoditycategory.CommodityCategoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 商品分类 Service 接口
 *
 * @author 芋道源码
 */
public interface CommodityCategoryService {

    /**
     * 创建商品分类
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createCommodityCategory(@Valid CommodityCategoryCreateReqVO createReqVO);

    /**
     * 更新商品分类
     *
     * @param updateReqVO 更新信息
     */
    void updateCommodityCategory(@Valid CommodityCategoryUpdateReqVO updateReqVO);

    /**
     * 删除商品分类
     *
     * @param id 编号
     */
    void deleteCommodityCategory(String id);

    /**
     * 获得商品分类
     *
     * @param id 编号
     * @return 商品分类
     */
    CommodityCategoryDO getCommodityCategory(String id);

    /**
     * 获得商品分类列表
     *
     * @param ids 编号
     * @return 商品分类列表
     */
    List<CommodityCategoryDO> getCommodityCategoryList(Collection<String> ids);

    /**
     * 获得商品分类分页
     *
     * @param pageReqVO 分页查询
     * @return 商品分类分页
     */
    PageResult<CommodityCategoryDO> getCommodityCategoryPage(CommodityCategoryPageReqVO pageReqVO);

    /**
     * 获得商品分类列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 商品分类列表
     */
    List<CommodityCategoryDO> getCommodityCategoryList(CommodityCategoryExportReqVO exportReqVO);

}
