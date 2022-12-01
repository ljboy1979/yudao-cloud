package cn.acsm.module.transaction.sales.service.salespackage;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.transaction.sales.controller.admin.salespackage.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.salespackage.PackageDO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 套餐 Service 接口
 *
 * @author 芋道源码
 */
public interface PackageService {

    /**
     * 创建套餐
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    CommonResult<String> createPackage(@Valid PackageCreateReqVO createReqVO);

    /**
     * 更新套餐
     *
     * @param updateReqVO 更新信息
     */
    CommonResult<String>  updatePackage(@Valid PackageUpdateReqVO updateReqVO);

    /**
     * 删除套餐
     *
     * @param id 编号
     */
    void deletePackage(String id);

    /**
     * 获得套餐
     *
     * @param id 编号
     * @return 套餐
     */
    PackageDO getPackage(String id);

    /**
     * 获得套餐列表
     *
     * @param ids 编号
     * @return 套餐列表
     */
    List<PackageDO> getPackageList(Collection<String> ids);

    /**
     * 获得套餐分页
     *
     * @param pageReqVO 分页查询
     * @return 套餐分页
     */
    PageResult<PackageDO> getPackagePage(PackagePageReqVO pageReqVO);

    /**
     * 获得套餐列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 套餐列表
     */
    List<PackageDO> getPackageList(PackageExportReqVO exportReqVO);

}
