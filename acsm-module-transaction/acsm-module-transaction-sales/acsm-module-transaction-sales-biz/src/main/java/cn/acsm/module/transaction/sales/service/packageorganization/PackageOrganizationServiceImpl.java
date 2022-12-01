package cn.acsm.module.transaction.sales.service.packageorganization;

import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.acsm.module.transaction.sales.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.sales.controller.admin.packageorganization.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.packageorganization.PackageOrganizationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.packageorganization.PackageOrganizationConvert;
import cn.acsm.module.transaction.sales.dal.mysql.packageorganization.PackageOrganizationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 套餐组成 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PackageOrganizationServiceImpl implements PackageOrganizationService {

    @Resource
    private PackageOrganizationMapper packageOrganizationMapper;

    @Resource
    private ConfigNumberUtil configNumberUtil;

    @Override
    public CommonResult<String> createPackageOrganization(PackageOrganizationCreateReqVO createReqVO) {
        PackageOrganizationDO packageOrganizationDO = new PackageOrganizationDO();
        packageOrganizationDO.setSpecificationId(createReqVO.getSpecificationId());
        packageOrganizationDO.setPackageId(createReqVO.getPackageId());
        packageOrganizationDO.setType(createReqVO.getType());
        packageOrganizationDO.setSourceId(createReqVO.getSourceId());
        packageOrganizationDO.setClassify(createReqVO.getClassify());
        Long num = packageOrganizationMapper.findSelectCount(packageOrganizationDO);
        if (num!=null && num>0){
            return CommonResult.error(ErrorCodeConstants.PACKAGE_ORGANIZATION_EXISTENCE);
        }
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("sales_special_medical_food_organization"+tenantId);
        // 插入
        PackageOrganizationDO packageOrganization = PackageOrganizationConvert.INSTANCE.convert(createReqVO);
        packageOrganization.setOrganizationName("ZC"+number);
        packageOrganization.setId(UUID.randomUUID().toString());
        packageOrganizationMapper.insert(packageOrganization);
        // 返回
        return CommonResult.success(packageOrganization.getId());
    }

    @Override
    public CommonResult<String> updatePackageOrganization(PackageOrganizationUpdateReqVO updateReqVO) {
        PackageOrganizationDO packageOrganizationDO = new PackageOrganizationDO();
        packageOrganizationDO.setSpecificationId(updateReqVO.getSpecificationId());
        packageOrganizationDO.setPackageId(updateReqVO.getPackageId());
        packageOrganizationDO.setType(updateReqVO.getType());
        packageOrganizationDO.setSourceId(updateReqVO.getSourceId());
        packageOrganizationDO.setClassify(updateReqVO.getClassify());
        packageOrganizationDO.setId(updateReqVO.getId());
        Long num = packageOrganizationMapper.findSelectCount(packageOrganizationDO);
        if (num!=null && num>0){
            return CommonResult.error(ErrorCodeConstants.PACKAGE_ORGANIZATION_EXISTENCE);
        }
        // 校验存在
        this.validatePackageOrganizationExists(updateReqVO.getId());
        // 更新
        PackageOrganizationDO updateObj = PackageOrganizationConvert.INSTANCE.convert(updateReqVO);
        packageOrganizationMapper.updateById(updateObj);
        return CommonResult.success("成功");
    }

    @Override
    public void deletePackageOrganization(String id) {
        // 校验存在
        this.validatePackageOrganizationExists(id);
        // 删除
        packageOrganizationMapper.deleteById(id);
    }

    private void validatePackageOrganizationExists(String id) {
        if (packageOrganizationMapper.selectById(id) == null) {
            throw exception(PACKAGE_ORGANIZATION_NOT_EXISTS);
        }
    }

    @Override
    public PackageOrganizationDO getPackageOrganization(String id) {
        return packageOrganizationMapper.selectById(id);
    }

    @Override
    public List<PackageOrganizationDO> getPackageOrganizationList(Collection<String> ids) {
        return packageOrganizationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PackageOrganizationDO> getPackageOrganizationPage(PackageOrganizationPageReqVO pageReqVO) {
        return packageOrganizationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PackageOrganizationDO> getPackageOrganizationList(PackageOrganizationExportReqVO exportReqVO) {
        return packageOrganizationMapper.selectList(exportReqVO);
    }

}
