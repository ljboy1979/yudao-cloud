package cn.acsm.module.transaction.sales.service.packageorganization;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesRespVO;
import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.acsm.module.transaction.sales.enums.ShelvesEnums;
import cn.acsm.module.transaction.sales.service.api.shelves.ShelvesContext;
import cn.acsm.module.transaction.sales.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
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


    @Resource
    private ShelvesContext shelvesContext;

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
        PackageOrganizationDO packageOrganization = PackageOrganizationConvert.INSTANCE.convert(createReqVO);
        Integer type=null;
        if("0".equals(createReqVO.getType())){
            type = 2;
        }
        if("1".equals(createReqVO.getType())){
            type = 3;
        }
        ShelvesSalesReqVO shelvesSalesReqVO = new ShelvesSalesReqVO();
        shelvesSalesReqVO.setClassify(Long.valueOf(createReqVO.getClassify()));
        List<TreeSelect> classifyList = shelvesContext.getService(ShelvesEnums.getByType(type).getValue()).findClassify(shelvesSalesReqVO);
        packageOrganization.setClassifyName(classifyList.get(0).getLabel());
        ShelvesSalesReqDto shelvesSalesReqDto = new ShelvesSalesReqDto();
        shelvesSalesReqDto.setSalesId(createReqVO.getSourceId());
        List<ShelvesSalesRespDto> salesList = shelvesContext.getService(ShelvesEnums.getByType(type).getValue()).findSales(shelvesSalesReqDto);
        packageOrganization.setOrganizationName(salesList.get(0).getName());
        shelvesSalesReqVO = new ShelvesSalesReqVO();
        shelvesSalesReqVO.setSpecificationsId(createReqVO.getSpecificationId());
        PageResult<ShelvesSalesRespVO> specifications = shelvesContext.getService(ShelvesEnums.getByType(type).getValue()).findSpecificationsVo(shelvesSalesReqVO);
        ShelvesSalesRespVO shelvesRespDto = specifications.getList().get(0);
        packageOrganization.setSpecificationsName(shelvesRespDto.getName());
        packageOrganization.setPackagingType(shelvesRespDto.getPackagingType());
        packageOrganization.setPackagingTypeName(shelvesRespDto.getPackagingTypeName());
        packageOrganization.setNumber(shelvesRespDto.getNumber());
        packageOrganization.setUnit(shelvesRespDto.getUnit());
        packageOrganization.setUnitName(shelvesRespDto.getUnitName());
        packageOrganization.setPackaging(shelvesRespDto.getPackaging());
        packageOrganization.setPackagingName(shelvesRespDto.getPackagingName());
        packageOrganization.setMeasurementUnit(shelvesRespDto.getMeasurementUnit());
        packageOrganization.setMeasurementUnitName(shelvesRespDto.getMeasurementUnitName());

        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("sales_special_medical_food_organization"+tenantId);
        // 插入

        packageOrganization.setOrganizationNumber("ZC"+number);
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
        Integer type=null;
        if("0".equals(updateReqVO.getType())){
            type = 2;
        }
        if("1".equals(updateReqVO.getType())){
            type = 3;
        }
        ShelvesSalesReqVO shelvesSalesReqVO = new ShelvesSalesReqVO();
        shelvesSalesReqVO.setClassify(Long.valueOf(updateReqVO.getClassify()));
        List<TreeSelect> classifyList = shelvesContext.getService(ShelvesEnums.getByType(type).getValue()).findClassify(shelvesSalesReqVO);
        updateObj.setClassifyName(classifyList.get(0).getLabel());
        ShelvesSalesReqDto shelvesSalesReqDto = new ShelvesSalesReqDto();
        shelvesSalesReqDto.setSalesId(updateReqVO.getSourceId());
        List<ShelvesSalesRespDto> salesList = shelvesContext.getService(ShelvesEnums.getByType(type).getValue()).findSales(shelvesSalesReqDto);
        updateObj.setOrganizationName(salesList.get(0).getName());
        shelvesSalesReqVO = new ShelvesSalesReqVO();
        shelvesSalesReqVO.setSpecificationsId(updateReqVO.getSpecificationId());
        PageResult<ShelvesSalesRespVO> specifications = shelvesContext.getService(ShelvesEnums.getByType(type).getValue()).findSpecificationsVo(shelvesSalesReqVO);
        ShelvesSalesRespVO shelvesRespDto = specifications.getList().get(0);
        updateObj.setSpecificationsName(shelvesRespDto.getName());
        updateObj.setPackagingType(shelvesRespDto.getPackagingType());
        updateObj.setPackagingTypeName(shelvesRespDto.getPackagingTypeName());
        updateObj.setNumber(shelvesRespDto.getNumber());
        updateObj.setUnit(shelvesRespDto.getUnit());
        updateObj.setUnitName(shelvesRespDto.getUnitName());
        updateObj.setPackaging(shelvesRespDto.getPackaging());
        updateObj.setPackagingName(shelvesRespDto.getPackagingName());
        updateObj.setMeasurementUnit(shelvesRespDto.getMeasurementUnit());
        updateObj.setMeasurementUnitName(shelvesRespDto.getMeasurementUnitName());
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
