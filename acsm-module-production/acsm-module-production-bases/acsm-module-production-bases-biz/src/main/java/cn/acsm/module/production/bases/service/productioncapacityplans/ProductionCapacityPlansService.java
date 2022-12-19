package cn.acsm.module.production.bases.service.productioncapacityplans;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.ProductionCapacityPlansCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.ProductionCapacityPlansExportReqVO;
import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.ProductionCapacityPlansPageReqVO;
import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.ProductionCapacityPlansUpdateReqVO;
import cn.acsm.module.production.bases.dal.dataobject.productioncapacityplans.ProductionCapacityPlansDO;
import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 产能计划 Service 接口
 *
 * @author 芋道源码
 */
public interface ProductionCapacityPlansService {

    /**
     * 创建产能计划
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createProductionCapacityPlans(@Valid ProductionCapacityPlansCreateReqVO createReqVO);

    /**
     * 更新产能计划
     *
     * @param updateReqVO 更新信息
     */
    void updateProductionCapacityPlans(@Valid ProductionCapacityPlansUpdateReqVO updateReqVO);

    /**
     * 删除产能计划
     *
     * @param id 编号
     */
    void deleteProductionCapacityPlans(Long id);

    /**
     * 获得产能计划
     *
     * @param id 编号
     * @return 产能计划
     */
    ProductionCapacityPlansDO getProductionCapacityPlans(Long id);

    /**
     * 获得产能计划列表
     *
     * @param ids 编号
     * @return 产能计划列表
     */
    List<ProductionCapacityPlansDO> getProductionCapacityPlansList(Collection<Long> ids);

    /**
     * 获得产能计划分页
     *
     * @param pageReqVO 分页查询
     * @return 产能计划分页
     */
    PageResult<ProductionCapacityPlansDO> getProductionCapacityPlansPage(ProductionCapacityPlansPageReqVO pageReqVO);

    /**
     * 获得产能计划列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 产能计划列表
     */
    List<ProductionCapacityPlansDO> getProductionCapacityPlansList(ProductionCapacityPlansExportReqVO exportReqVO);

}
