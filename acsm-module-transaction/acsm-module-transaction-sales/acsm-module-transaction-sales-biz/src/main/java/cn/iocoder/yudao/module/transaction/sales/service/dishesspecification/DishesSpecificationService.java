package cn.iocoder.yudao.module.transaction.sales.service.dishesspecification;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.dishesspecification.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.dishesspecification.DishesSpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 菜品规格 Service 接口
 *
 * @author 芋道源码
 */
public interface DishesSpecificationService {

    /**
     * 创建菜品规格
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createDishesSpecification(@Valid DishesSpecificationCreateReqVO createReqVO);

    /**
     * 更新菜品规格
     *
     * @param updateReqVO 更新信息
     */
    void updateDishesSpecification(@Valid DishesSpecificationUpdateReqVO updateReqVO);

    /**
     * 删除菜品规格
     *
     * @param id 编号
     */
    void deleteDishesSpecification(String id);

    /**
     * 获得菜品规格
     *
     * @param id 编号
     * @return 菜品规格
     */
    DishesSpecificationDO getDishesSpecification(String id);

    /**
     * 获得菜品规格列表
     *
     * @param ids 编号
     * @return 菜品规格列表
     */
    List<DishesSpecificationDO> getDishesSpecificationList(Collection<String> ids);

    /**
     * 获得菜品规格分页
     *
     * @param pageReqVO 分页查询
     * @return 菜品规格分页
     */
    PageResult<DishesSpecificationDO> getDishesSpecificationPage(DishesSpecificationPageReqVO pageReqVO);

    /**
     * 获得菜品规格列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 菜品规格列表
     */
    List<DishesSpecificationDO> getDishesSpecificationList(DishesSpecificationExportReqVO exportReqVO);

}
