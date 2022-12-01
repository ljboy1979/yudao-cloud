package cn.acsm.module.transaction.sales.service.specialmedicalfood;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfood.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfood.SpecialMedicalFoodDO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 特医食品 Service 接口
 *
 * @author 芋道源码
 */
public interface SpecialMedicalFoodService {

    /**
     * 创建特医食品
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    CommonResult<String> createSpecialMedicalFood(@Valid SpecialMedicalFoodCreateReqVO createReqVO);

    /**
     * 更新特医食品
     *
     * @param updateReqVO 更新信息
     */
    CommonResult<String> updateSpecialMedicalFood(@Valid SpecialMedicalFoodUpdateReqVO updateReqVO);

    /**
     * 删除特医食品
     *
     * @param id 编号
     */
    void deleteSpecialMedicalFood(String id);

    /**
     * 获得特医食品
     *
     * @param id 编号
     * @return 特医食品
     */
    SpecialMedicalFoodDO getSpecialMedicalFood(String id);

    /**
     * 获得特医食品列表
     *
     * @param ids 编号
     * @return 特医食品列表
     */
    List<SpecialMedicalFoodDO> getSpecialMedicalFoodList(Collection<String> ids);

    /**
     * 获得特医食品分页
     *
     * @param pageReqVO 分页查询
     * @return 特医食品分页
     */
    PageResult<SpecialMedicalFoodDO> getSpecialMedicalFoodPage(SpecialMedicalFoodPageReqVO pageReqVO);

    /**
     * 获得特医食品列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 特医食品列表
     */
    List<SpecialMedicalFoodDO> getSpecialMedicalFoodList(SpecialMedicalFoodExportReqVO exportReqVO);

}
