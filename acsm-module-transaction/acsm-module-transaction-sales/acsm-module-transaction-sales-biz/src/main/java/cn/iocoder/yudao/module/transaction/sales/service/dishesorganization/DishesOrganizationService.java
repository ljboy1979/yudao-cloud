package cn.iocoder.yudao.module.transaction.sales.service.dishesorganization;

import java.util.*;
import javax.validation.*;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.dishesorganization.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.dishesorganization.DishesOrganizationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 菜品组成 Service 接口
 *
 * @author 芋道源码
 */
public interface DishesOrganizationService {

    /**
     * 创建菜品组成
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    CommonResult<String> createDishesOrganization(@Valid DishesOrganizationCreateReqVO createReqVO);

    /**
     * 更新菜品组成
     *
     * @param updateReqVO 更新信息
     */
    void updateDishesOrganization(@Valid DishesOrganizationUpdateReqVO updateReqVO);

    /**
     * 删除菜品组成
     *
     * @param id 编号
     */
    void deleteDishesOrganization(String id);

    /**
     * 获得菜品组成
     *
     * @param id 编号
     * @return 菜品组成
     */
    DishesOrganizationDO getDishesOrganization(String id);

    /**
     * 获得菜品组成列表
     *
     * @param ids 编号
     * @return 菜品组成列表
     */
    List<DishesOrganizationDO> getDishesOrganizationList(Collection<String> ids);

    /**
     * 获得菜品组成分页
     *
     * @param pageReqVO 分页查询
     * @return 菜品组成分页
     */
    PageResult<DishesOrganizationDO> getDishesOrganizationPage(DishesOrganizationPageReqVO pageReqVO);

    /**
     * 获得菜品组成列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 菜品组成列表
     */
    List<DishesOrganizationDO> getDishesOrganizationList(DishesOrganizationExportReqVO exportReqVO);

}
