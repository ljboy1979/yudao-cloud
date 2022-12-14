package cn.acsm.module.transaction.sales.service.specialmedicalfoodorganization;

import cn.acsm.module.transaction.sales.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodorganization.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodorganization.SpecialMedicalFoodOrganizationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.specialmedicalfoodorganization.SpecialMedicalFoodOrganizationConvert;
import cn.acsm.module.transaction.sales.dal.mysql.specialmedicalfoodorganization.SpecialMedicalFoodOrganizationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 特医食品组成 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class SpecialMedicalFoodOrganizationServiceImpl implements SpecialMedicalFoodOrganizationService {

    @Resource
    private SpecialMedicalFoodOrganizationMapper specialMedicalFoodOrganizationMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;
    @Override
    public String createSpecialMedicalFoodOrganization(SpecialMedicalFoodOrganCreateReqVO createReqVO) {
        // 插入
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("sales_special_medical_food_organization"+tenantId);
        SpecialMedicalFoodOrganizationDO specialMedicalFoodOrganization = SpecialMedicalFoodOrganizationConvert.INSTANCE.convert(createReqVO);
        specialMedicalFoodOrganization.setOrganizationNumber("ZC"+number);
        specialMedicalFoodOrganization.setId(UUID.randomUUID().toString());
        specialMedicalFoodOrganizationMapper.insert(specialMedicalFoodOrganization);
        // 返回
        return specialMedicalFoodOrganization.getId();
    }

    @Override
    public void updateSpecialMedicalFoodOrganization(SpecialMedicalFoodOrganUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateSpecialMedicalFoodOrganizationExists(updateReqVO.getId());
        // 更新
        SpecialMedicalFoodOrganizationDO updateObj = SpecialMedicalFoodOrganizationConvert.INSTANCE.convert(updateReqVO);
        specialMedicalFoodOrganizationMapper.updateById(updateObj);
    }

    @Override
    public void deleteSpecialMedicalFoodOrganization(String id) {
        // 校验存在
        this.validateSpecialMedicalFoodOrganizationExists(id);
        // 删除
        specialMedicalFoodOrganizationMapper.deleteById(id);
    }

    private void validateSpecialMedicalFoodOrganizationExists(String id) {
        if (specialMedicalFoodOrganizationMapper.selectById(id) == null) {
            throw exception(SPECIAL_MEDICAL_FOOD_ORGANIZATION_NOT_EXISTS);
        }
    }

    @Override
    public SpecialMedicalFoodOrganizationDO getSpecialMedicalFoodOrganization(String id) {
        return specialMedicalFoodOrganizationMapper.selectById(id);
    }

    @Override
    public List<SpecialMedicalFoodOrganizationDO> getSpecialMedicalFoodOrganizationList(Collection<String> ids) {
        return specialMedicalFoodOrganizationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<SpecialMedicalFoodOrganizationDO> getSpecialMedicalFoodOrganizationPage(SpecialMedicalFoodOrganizationPageReqVO pageReqVO) {
        return specialMedicalFoodOrganizationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<SpecialMedicalFoodOrganizationDO> getSpecialMedicalFoodOrganizationList(SpecialMedicalFoodOrganExportReqVO exportReqVO) {
        return specialMedicalFoodOrganizationMapper.selectList(exportReqVO);
    }

}
