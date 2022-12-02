package cn.acsm.module.transaction.sales.service.specialmedicalfoodspecification;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodspecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodspecification.SpecialMedicalFoodSpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 特医食品规格 Service 接口
 *
 * @author 芋道源码
 */
public interface SpecialMedicalFoodSpecificationService {

    /**
     * 创建特医食品规格
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    CommonResult<String> createSpecialMedicalFoodSpecification(@Valid SpecialMedicalFoodSpecificationCreateReqVO createReqVO);

    /**
     * 更新特医食品规格
     *
     * @param updateReqVO 更新信息
     */
    CommonResult<String> updateSpecialMedicalFoodSpecification(@Valid SpecialMedicalFoodSpecificationUpdateReqVO updateReqVO);

    /**
     * 删除特医食品规格
     *
     * @param id 编号
     */
    void deleteSpecialMedicalFoodSpecification(String id);

    /**
     * 获得特医食品规格
     *
     * @param id 编号
     * @return 特医食品规格
     */
    SpecialMedicalFoodSpecificationDO getSpecialMedicalFoodSpecification(String id);

    /**
     * 获得特医食品规格列表
     *
     * @param ids 编号
     * @return 特医食品规格列表
     */
    List<SpecialMedicalFoodSpecificationDO> getSpecialMedicalFoodSpecificationList(Collection<String> ids);

    /**
     * 获得特医食品规格分页
     *
     * @param pageReqVO 分页查询
     * @return 特医食品规格分页
     */
    PageResult<SpecialMedicalFoodSpecificationDO> getSpecialMedicalFoodSpecificationPage(SpecialMedicalFoodSpecificationPageReqVO pageReqVO);

    /**
     * 获得特医食品规格列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 特医食品规格列表
     */
    List<SpecialMedicalFoodSpecificationDO> getSpecialMedicalFoodSpecificationList(SpecialMedicalFoodSpecificationExportReqVO exportReqVO);

}
