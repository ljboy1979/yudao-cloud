package cn.acsm.module.transaction.sales.service.specialmedicalfood;

import cn.acsm.module.transaction.sales.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfood.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfood.SpecialMedicalFoodDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.specialmedicalfood.SpecialMedicalFoodConvert;
import cn.acsm.module.transaction.sales.dal.mysql.specialmedicalfood.SpecialMedicalFoodMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 特医食品 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class SpecialMedicalFoodServiceImpl implements SpecialMedicalFoodService {

    @Resource
    private SpecialMedicalFoodMapper specialMedicalFoodMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;
    @Override
    public CommonResult<String> createSpecialMedicalFood(SpecialMedicalFoodCreateReqVO createReqVO) {
        SpecialMedicalFoodDO specialMedicalFoodDO = new SpecialMedicalFoodDO();
        specialMedicalFoodDO.setName(createReqVO.getName());
        specialMedicalFoodDO.setClassify(createReqVO.getClassify());
        Long count = specialMedicalFoodMapper.findSelectCount(specialMedicalFoodDO);
        if (count!=null && count>0) {
            return CommonResult.error(SPECIAL_MEDICAL_FOOD_EXISTENCE);
        }
        // 插入
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("sales_special_medical_food"+tenantId);
        SpecialMedicalFoodDO specialMedicalFood = SpecialMedicalFoodConvert.INSTANCE.convert(createReqVO);
        specialMedicalFood.setNumber("SP"+number);
        specialMedicalFood.setId(UUID.randomUUID().toString());
        specialMedicalFoodMapper.insert(specialMedicalFood);
        // 返回
        return CommonResult.success(specialMedicalFood.getId());
    }

    @Override
    public CommonResult<String> updateSpecialMedicalFood(SpecialMedicalFoodUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateSpecialMedicalFoodExists(updateReqVO.getId());
        SpecialMedicalFoodDO specialMedicalFoodDO = new SpecialMedicalFoodDO();
        specialMedicalFoodDO.setName(updateReqVO.getName());
        specialMedicalFoodDO.setClassify(updateReqVO.getClassify());
        specialMedicalFoodDO.setId(updateReqVO.getId());
        Long count = specialMedicalFoodMapper.findSelectCount(specialMedicalFoodDO);
        if (count!=null && count>0) {
            return CommonResult.error(SPECIAL_MEDICAL_FOOD_EXISTENCE);
        }
        // 更新
        SpecialMedicalFoodDO updateObj = SpecialMedicalFoodConvert.INSTANCE.convert(updateReqVO);
        specialMedicalFoodMapper.updateById(updateObj);
        return CommonResult.success("成功");

    }

    @Override
    public void deleteSpecialMedicalFood(String id) {
        // 校验存在
        this.validateSpecialMedicalFoodExists(id);
        // 删除
        specialMedicalFoodMapper.deleteById(id);
    }

    private void validateSpecialMedicalFoodExists(String id) {
        if (specialMedicalFoodMapper.selectById(id) == null) {
            throw exception(SPECIAL_MEDICAL_FOOD_NOT_EXISTS);
        }
    }

    @Override
    public SpecialMedicalFoodDO getSpecialMedicalFood(String id) {
        return specialMedicalFoodMapper.selectById(id);
    }

    @Override
    public List<SpecialMedicalFoodDO> getSpecialMedicalFoodList(Collection<String> ids) {
        return specialMedicalFoodMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<SpecialMedicalFoodDO> getSpecialMedicalFoodPage(SpecialMedicalFoodPageReqVO pageReqVO) {
        return specialMedicalFoodMapper.selectPage(pageReqVO);
    }

    @Override
    public List<SpecialMedicalFoodDO> getSpecialMedicalFoodList(SpecialMedicalFoodExportReqVO exportReqVO) {
        return specialMedicalFoodMapper.selectList(exportReqVO);
    }

}
