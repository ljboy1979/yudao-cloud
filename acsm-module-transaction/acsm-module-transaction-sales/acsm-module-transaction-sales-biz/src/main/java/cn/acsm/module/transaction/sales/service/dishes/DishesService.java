package cn.acsm.module.transaction.sales.service.dishes;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.sales.controller.admin.dishes.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.dishes.DishesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 菜品 Service 接口
 *
 * @author 芋道源码
 */
public interface DishesService {

    /**
     * 创建菜品
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createDishes(@Valid DishesCreateReqVO createReqVO);

    /**
     * 更新菜品
     *
     * @param updateReqVO 更新信息
     */
    void updateDishes(@Valid DishesUpdateReqVO updateReqVO);

    /**
     * 删除菜品
     *
     * @param id 编号
     */
    void deleteDishes(String id);

    /**
     * 获得菜品
     *
     * @param id 编号
     * @return 菜品
     */
    DishesDO getDishes(String id);

    /**
     * 获得菜品列表
     *
     * @param ids 编号
     * @return 菜品列表
     */
    List<DishesDO> getDishesList(Collection<String> ids);

    /**
     * 获得菜品分页
     *
     * @param pageReqVO 分页查询
     * @return 菜品分页
     */
    PageResult<DishesDO> getDishesPage(DishesPageReqVO pageReqVO);

    /**
     * 获得菜品列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 菜品列表
     */
    List<DishesDO> getDishesList(DishesExportReqVO exportReqVO);

}
