package cn.acsm.module.transaction.sales.service.packageorganization;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.sales.controller.admin.packageorganization.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.packageorganization.PackageOrganizationDO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 套餐组成 Service 接口
 *
 * @author 芋道源码
 */
public interface PackageOrganizationService {

    /**
     * 创建套餐组成
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    CommonResult<String> createPackageOrganization(@Valid PackageOrganizationCreateReqVO createReqVO);

    /**
     * 更新套餐组成
     *
     * @param updateReqVO 更新信息
     */
    CommonResult<String> updatePackageOrganization(@Valid PackageOrganizationUpdateReqVO updateReqVO);

    /**
     * 删除套餐组成
     *
     * @param id 编号
     */
    void deletePackageOrganization(String id);

    /**
     * 获得套餐组成
     *
     * @param id 编号
     * @return 套餐组成
     */
    PackageOrganizationDO getPackageOrganization(String id);

    /**
     * 获得套餐组成列表
     *
     * @param ids 编号
     * @return 套餐组成列表
     */
    List<PackageOrganizationDO> getPackageOrganizationList(Collection<String> ids);

    /**
     * 获得套餐组成分页
     *
     * @param pageReqVO 分页查询
     * @return 套餐组成分页
     */
    PageResult<PackageOrganizationDO> getPackageOrganizationPage(PackageOrganizationPageReqVO pageReqVO);

    /**
     * 获得套餐组成列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 套餐组成列表
     */
    List<PackageOrganizationDO> getPackageOrganizationList(PackageOrganizationExportReqVO exportReqVO);

}
