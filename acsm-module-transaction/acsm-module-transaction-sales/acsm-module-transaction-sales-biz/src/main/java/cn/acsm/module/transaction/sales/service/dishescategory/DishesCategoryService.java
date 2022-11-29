package cn.acsm.module.transaction.sales.service.dishescategory;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryPageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryUpdateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.dishescategory.DishesCategoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 菜品分类 Service 接口
 *
 * @author 芋道源码
 */
public interface DishesCategoryService {

    /**
     * 创建菜品分类
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createDishesCategory(@Valid DishesCategoryCreateReqVO createReqVO);

    /**
     * 更新菜品分类
     *
     * @param updateReqVO 更新信息
     */
    void updateDishesCategory(@Valid DishesCategoryUpdateReqVO updateReqVO);

    /**
     * 删除菜品分类
     *
     * @param id 编号
     */
    void deleteDishesCategory(String id);

    /**
     * 获得菜品分类
     *
     * @param id 编号
     * @return 菜品分类
     */
    DishesCategoryDO getDishesCategory(String id);

    /**
     * 获得菜品分类列表
     *
     * @param ids 编号
     * @return 菜品分类列表
     */
    List<DishesCategoryDO> getDishesCategoryList(Collection<String> ids);

    /**
     * 获得菜品分类分页
     *
     * @param pageReqVO 分页查询
     * @return 菜品分类分页
     */
    PageResult<DishesCategoryDO> getDishesCategoryPage(DishesCategoryPageReqVO pageReqVO);

    /**
     * 获得菜品分类列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 菜品分类列表
     */
    List<DishesCategoryDO> getDishesCategoryList(DishesCategoryExportReqVO exportReqVO);

}
