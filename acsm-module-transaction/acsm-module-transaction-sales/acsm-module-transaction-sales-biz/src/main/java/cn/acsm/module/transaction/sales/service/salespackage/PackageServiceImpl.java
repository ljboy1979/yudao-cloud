package cn.acsm.module.transaction.sales.service.salespackage;

import cn.acsm.module.transaction.sales.controller.admin.salespackage.vo.PackageCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.salespackage.vo.PackageExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.salespackage.vo.PackagePageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.salespackage.vo.PackageUpdateReqVO;
import cn.acsm.module.transaction.sales.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.sales.dal.dataobject.salespackage.PackageDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.salespackage.PackageConvert;
import cn.acsm.module.transaction.sales.dal.mysql.salespackage.PackageMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 套餐 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PackageServiceImpl implements PackageService {

    @Resource
    private PackageMapper packageMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;

    @Override
    public CommonResult<String> createPackage(PackageCreateReqVO createReqVO) {
        PackageDO packageDO = new PackageDO();
        packageDO.setName(createReqVO.getName());
        packageDO.setMiniClassificationIdOne(createReqVO.getMiniClassificationIdOne());
        Long count = packageMapper.findSelectCount(packageDO);
        if (count!=null && count>0) {
            return CommonResult.error(PACKAGE_NOT_EXISTENCE);
        }
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("sales_package"+tenantId);
        // 插入
        packageDO = PackageConvert.INSTANCE.convert(createReqVO);
        packageDO.setId(UUID.randomUUID().toString());
        packageDO.setMealNumber("TC"+number);
        packageMapper.insert(packageDO);
        // 返回
        return CommonResult.success(packageDO.getId());
    }

    @Override
    public CommonResult<String>  updatePackage(PackageUpdateReqVO updateReqVO) {
        PackageDO packageDO = new PackageDO();
        packageDO.setName(updateReqVO.getName());
        packageDO.setMiniClassificationIdOne(updateReqVO.getMiniClassificationIdOne());
        packageDO.setId(updateReqVO.getId());
        Long count = packageMapper.findSelectCount(packageDO);
        if (count!=null && count>0) {
            return CommonResult.error(PACKAGE_NOT_EXISTENCE);
        }
        // 校验存在
        this.validatePackageExists(updateReqVO.getId());
        // 更新
        PackageDO updateObj = PackageConvert.INSTANCE.convert(updateReqVO);
        packageMapper.updateById(updateObj);
        return CommonResult.success("成功");

    }

    @Override
    public void deletePackage(String id) {
        // 校验存在
        this.validatePackageExists(id);
        // 删除
        packageMapper.deleteById(id);
    }

    private void validatePackageExists(String id) {
        if (packageMapper.selectById(id) == null) {
            throw exception(PACKAGE_NOT_EXISTS);
        }
    }

    @Override
    public PackageDO getPackage(String id) {
        return packageMapper.selectById(id);
    }

    @Override
    public List<PackageDO> getPackageList(Collection<String> ids) {
        return packageMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PackageDO> getPackagePage(PackagePageReqVO pageReqVO) {
        return packageMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PackageDO> getPackageList(PackageExportReqVO exportReqVO) {
        return packageMapper.selectList(exportReqVO);
    }


}
