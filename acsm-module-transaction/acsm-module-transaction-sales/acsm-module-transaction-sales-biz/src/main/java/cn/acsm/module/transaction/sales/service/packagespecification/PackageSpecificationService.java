package cn.acsm.module.transaction.sales.service.packagespecification;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.sales.controller.admin.packagespecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.packagespecification.PackageSpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 套餐规格 Service 接口
 *
 * @author 芋道源码
 */
public interface PackageSpecificationService {

    /**
     * 创建套餐规格
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    CommonResult<String> createPackageSpecification(@Valid PackageSpecificationCreateReqVO createReqVO);

    /**
     * 更新套餐规格
     *
     * @param updateReqVO 更新信息
     */
    CommonResult<String> updatePackageSpecification(@Valid PackageSpecificationUpdateReqVO updateReqVO);

    /**
     * 删除套餐规格
     *
     * @param id 编号
     */
    void deletePackageSpecification(String id);

    /**
     * 获得套餐规格
     *
     * @param id 编号
     * @return 套餐规格
     */
    PackageSpecificationDO getPackageSpecification(String id);

    /**
     * 获得套餐规格列表
     *
     * @param ids 编号
     * @return 套餐规格列表
     */
    List<PackageSpecificationDO> getPackageSpecificationList(Collection<String> ids);

    /**
     * 获得套餐规格分页
     *
     * @param pageReqVO 分页查询
     * @return 套餐规格分页
     */
    PageResult<PackageSpecificationDO> getPackageSpecificationPage(PackageSpecificationPageReqVO pageReqVO);

    /**
     * 获得套餐规格列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 套餐规格列表
     */
    List<PackageSpecificationDO> getPackageSpecificationList(PackageSpecificationExportReqVO exportReqVO);

}
