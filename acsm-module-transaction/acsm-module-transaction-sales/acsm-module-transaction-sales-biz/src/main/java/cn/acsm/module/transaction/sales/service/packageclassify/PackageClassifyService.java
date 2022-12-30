package cn.acsm.module.transaction.sales.service.packageclassify;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.sales.controller.admin.packageclassify.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.packageclassify.PackageClassifyDO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;

/**
 * 套餐分类 Service 接口
 *
 * @author 芋道源码
 */
public interface PackageClassifyService {

    /**
     * 创建套餐分类
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    CommonResult createPackageClassify(@Valid PackageClassifyCreateReqVO createReqVO);

    /**
     * 更新套餐分类
     *
     * @param updateReqVO 更新信息
     */
    CommonResult updatePackageClassify(@Valid PackageClassifyUpdateReqVO updateReqVO);

    /**
     * 删除套餐分类
     *
     * @param id 编号
     */
    void deletePackageClassify(String id);

    /**
     * 获得套餐分类
     *
     * @param id 编号
     * @return 套餐分类
     */
    PackageClassifyDO getPackageClassify(String id);

    /**
     * 获得套餐分类列表
     *
     * @param ids 编号
     * @return 套餐分类列表
     */
    List<PackageClassifyDO> getPackageClassifyList(Collection<String> ids);

    /**
     * 获得套餐分类分页
     *
     * @param pageReqVO 分页查询
     * @return 套餐分类分页
     */
    PageResult<PackageClassifyDO> getPackageClassifyPage(PackageClassifyPageReqVO pageReqVO);

    /**
     * 获得套餐分类列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 套餐分类列表
     */
    List<PackageClassifyDO> getPackageClassifyList(PackageClassifyExportReqVO exportReqVO);

    List<TreeSelect> findTreeList(PackageClassifyTreeVO packageClassifyTreeVO);
}
