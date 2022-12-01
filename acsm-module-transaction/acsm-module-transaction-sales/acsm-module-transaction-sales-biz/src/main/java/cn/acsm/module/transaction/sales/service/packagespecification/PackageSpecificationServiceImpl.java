package cn.acsm.module.transaction.sales.service.packagespecification;

import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.sales.controller.admin.packagespecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.packagespecification.PackageSpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.packagespecification.PackageSpecificationConvert;
import cn.acsm.module.transaction.sales.dal.mysql.packagespecification.PackageSpecificationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 套餐规格 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PackageSpecificationServiceImpl implements PackageSpecificationService {

    @Resource
    private PackageSpecificationMapper packageSpecificationMapper;

    @Override
    public CommonResult<String> createPackageSpecification(PackageSpecificationCreateReqVO createReqVO) {
        PackageSpecificationDO packageSpecificationDO = new PackageSpecificationDO();
        packageSpecificationDO.setSpecificationsName(createReqVO.getSpecificationsName());
        packageSpecificationDO.setPackageId(createReqVO.getPackageId());
        Long num = packageSpecificationMapper.findSelectCount(packageSpecificationDO);
        if (num!=null && num>0){
            return CommonResult.error(ErrorCodeConstants.PACKAGE_SPECIFICATION_EXISTENCE);
        }
        // 插入
        PackageSpecificationDO packageSpecification = PackageSpecificationConvert.INSTANCE.convert(createReqVO);
        packageSpecification.setId(UUID.randomUUID().toString());
        packageSpecificationMapper.insert(packageSpecification);
        // 返回
        return CommonResult.success(packageSpecification.getId());
    }

    @Override
    public CommonResult<String> updatePackageSpecification(PackageSpecificationUpdateReqVO updateReqVO) {
        PackageSpecificationDO packageSpecificationDO = new PackageSpecificationDO();
        packageSpecificationDO.setSpecificationsName(updateReqVO.getSpecificationsName());
        packageSpecificationDO.setPackageId(updateReqVO.getPackageId());
        packageSpecificationDO.setId(updateReqVO.getId());
        Long num = packageSpecificationMapper.findSelectCount(packageSpecificationDO);
        if (num!=null && num>0){
            return CommonResult.error(ErrorCodeConstants.PACKAGE_SPECIFICATION_EXISTENCE);
        }
        // 校验存在
        this.validatePackageSpecificationExists(updateReqVO.getId());
        // 更新
        PackageSpecificationDO updateObj = PackageSpecificationConvert.INSTANCE.convert(updateReqVO);
        packageSpecificationMapper.updateById(updateObj);
        return CommonResult.success("成功");
    }

    @Override
    public void deletePackageSpecification(String id) {
        // 校验存在
        this.validatePackageSpecificationExists(id);
        // 删除
        packageSpecificationMapper.deleteById(id);
    }

    private void validatePackageSpecificationExists(String id) {
        if (packageSpecificationMapper.selectById(id) == null) {
            throw exception(PACKAGE_SPECIFICATION_NOT_EXISTS);
        }
    }

    @Override
    public PackageSpecificationDO getPackageSpecification(String id) {
        return packageSpecificationMapper.selectById(id);
    }

    @Override
    public List<PackageSpecificationDO> getPackageSpecificationList(Collection<String> ids) {
        return packageSpecificationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PackageSpecificationDO> getPackageSpecificationPage(PackageSpecificationPageReqVO pageReqVO) {
        return packageSpecificationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PackageSpecificationDO> getPackageSpecificationList(PackageSpecificationExportReqVO exportReqVO) {
        return packageSpecificationMapper.selectList(exportReqVO);
    }

}
