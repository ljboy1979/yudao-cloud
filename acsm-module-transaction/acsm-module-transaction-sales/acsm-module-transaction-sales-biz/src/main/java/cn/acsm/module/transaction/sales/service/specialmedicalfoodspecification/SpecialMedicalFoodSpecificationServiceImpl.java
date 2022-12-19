package cn.acsm.module.transaction.sales.service.specialmedicalfoodspecification;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodspecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodspecification.SpecialMedicalFoodSpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.specialmedicalfoodspecification.SpecialMedicalFoodSpecificationConvert;
import cn.acsm.module.transaction.sales.dal.mysql.specialmedicalfoodspecification.SpecialMedicalFoodSpecificationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 特医食品规格 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class SpecialMedicalFoodSpecificationServiceImpl implements SpecialMedicalFoodSpecificationService {

    @Resource
    private SpecialMedicalFoodSpecificationMapper specialMedicalFoodSpecificationMapper;

    @Override
    public CommonResult<String> createSpecialMedicalFoodSpecification(SpecialMedicalFoodSpecCreateReqVO createReqVO) {
        SpecialMedicalFoodSpecificationDO specialMedicalFoodSpecificationDO = new SpecialMedicalFoodSpecificationDO();
        specialMedicalFoodSpecificationDO.setFoodId(createReqVO.getFoodId());
        specialMedicalFoodSpecificationDO.setSpecificationsName(createReqVO.getSpecificationsName());
        Long count = specialMedicalFoodSpecificationMapper.findSelectCount(specialMedicalFoodSpecificationDO);
        if (count!=null && count>0) {
            return CommonResult.error(SPECIAL_MEDICAL_FOOD_SPECIFICATION_EXISTENCE);
        }
        // 插入
        SpecialMedicalFoodSpecificationDO specialMedicalFoodSpecification = SpecialMedicalFoodSpecificationConvert.INSTANCE.convert(createReqVO);
        specialMedicalFoodSpecification.setId(UUID.randomUUID().toString());
        specialMedicalFoodSpecificationMapper.insert(specialMedicalFoodSpecification);
        // 返回
        return CommonResult.success(specialMedicalFoodSpecification.getId());
    }

    @Override
    public CommonResult<String> updateSpecialMedicalFoodSpecification(SpecialMedicalFoodSpecUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateSpecialMedicalFoodSpecificationExists(updateReqVO.getId());
        SpecialMedicalFoodSpecificationDO specialMedicalFoodSpecificationDO = new SpecialMedicalFoodSpecificationDO();
        specialMedicalFoodSpecificationDO.setFoodId(updateReqVO.getFoodId());
        specialMedicalFoodSpecificationDO.setSpecificationsName(updateReqVO.getSpecificationsName());
        specialMedicalFoodSpecificationDO.setId(updateReqVO.getId());

        Long count = specialMedicalFoodSpecificationMapper.findSelectCount(specialMedicalFoodSpecificationDO);
        if (count!=null && count>0) {
            return CommonResult.error(SPECIAL_MEDICAL_FOOD_SPECIFICATION_EXISTENCE);
        }
        // 更新
        SpecialMedicalFoodSpecificationDO updateObj = SpecialMedicalFoodSpecificationConvert.INSTANCE.convert(updateReqVO);
        specialMedicalFoodSpecificationMapper.updateById(updateObj);
        return CommonResult.success("成功");

    }

    @Override
    public void deleteSpecialMedicalFoodSpecification(String id) {
        // 校验存在
        this.validateSpecialMedicalFoodSpecificationExists(id);
        // 删除
        specialMedicalFoodSpecificationMapper.deleteById(id);
    }

    private void validateSpecialMedicalFoodSpecificationExists(String id) {
        if (specialMedicalFoodSpecificationMapper.selectById(id) == null) {
            throw exception(SPECIAL_MEDICAL_FOOD_SPECIFICATION_NOT_EXISTS);
        }
    }

    @Override
    public SpecialMedicalFoodSpecificationDO getSpecialMedicalFoodSpecification(String id) {
        return specialMedicalFoodSpecificationMapper.selectById(id);
    }

    @Override
    public List<SpecialMedicalFoodSpecificationDO> getSpecialMedicalFoodSpecificationList(Collection<String> ids) {
        return specialMedicalFoodSpecificationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<SpecialMedicalFoodSpecificationDO> getSpecialMedicalFoodSpecificationPage(SpecialMedicalFoodSpecPageReqVO pageReqVO) {
        return specialMedicalFoodSpecificationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<SpecialMedicalFoodSpecificationDO> getSpecialMedicalFoodSpecificationList(SpecialMedicalFoodSpecExportReqVO exportReqVO) {
        return specialMedicalFoodSpecificationMapper.selectList(exportReqVO);
    }

}
