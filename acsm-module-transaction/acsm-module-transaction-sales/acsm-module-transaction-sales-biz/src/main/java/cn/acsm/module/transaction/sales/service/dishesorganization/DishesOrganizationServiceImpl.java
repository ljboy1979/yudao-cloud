package cn.acsm.module.transaction.sales.service.dishesorganization;

import cn.acsm.module.transaction.sales.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterial.RawMaterialDO;
import cn.acsm.module.transaction.sales.dal.mysql.rawmaterial.RawMaterialMapper;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.sales.controller.admin.dishesorganization.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.dishesorganization.DishesOrganizationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.dishesorganization.DishesOrganizationConvert;
import cn.acsm.module.transaction.sales.dal.mysql.dishesorganization.DishesOrganizationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 菜品组成 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class DishesOrganizationServiceImpl implements DishesOrganizationService {

    @Resource
    private DishesOrganizationMapper dishesOrganizationMapper;

    @Resource
    private RawMaterialMapper rawMaterialMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;
    @Override
    public CommonResult<String> createDishesOrganization(DishesOrganizationCreateReqVO createReqVO) {
        if ("0".equals(createReqVO.getTag())) {
            RawMaterialDO rawMaterialDO = rawMaterialMapper.selectById(createReqVO.getRawMaterialId());
            if (rawMaterialDO == null) {
                return CommonResult.error(RAW_MATERIAL_NOT_EXISTS);
            }
            createReqVO.setOrigin(rawMaterialDO.getOrigin());
            createReqVO.setClassify(rawMaterialDO.getClassify());
            createReqVO.setOrganizationName(rawMaterialDO.getName());
        }
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("sales_dishes"+tenantId);
        // 插入
        DishesOrganizationDO dishesOrganization = DishesOrganizationConvert.INSTANCE.convert(createReqVO);
        dishesOrganization.setId(UUID.randomUUID().toString());
        dishesOrganization.setOrganizationNumber("ZC"+number);
        dishesOrganizationMapper.insert(dishesOrganization);
        // 返回
        return CommonResult.success(dishesOrganization.getId());
    }

    @Override
    public void updateDishesOrganization(DishesOrganizationUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateDishesOrganizationExists(updateReqVO.getId());
        // 更新
        DishesOrganizationDO updateObj = DishesOrganizationConvert.INSTANCE.convert(updateReqVO);
        dishesOrganizationMapper.updateById(updateObj);
    }

    @Override
    public void deleteDishesOrganization(String id) {
        // 校验存在
        this.validateDishesOrganizationExists(id);
        // 删除
        dishesOrganizationMapper.deleteById(id);
    }

    private void validateDishesOrganizationExists(String id) {
        if (dishesOrganizationMapper.selectById(id) == null) {
            throw exception(DISHES_ORGANIZATION_NOT_EXISTS);
        }
    }

    @Override
    public DishesOrganizationDO getDishesOrganization(String id) {
        return dishesOrganizationMapper.selectById(id);
    }

    @Override
    public List<DishesOrganizationDO> getDishesOrganizationList(Collection<String> ids) {
        return dishesOrganizationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<DishesOrganizationDO> getDishesOrganizationPage(DishesOrganizationPageReqVO pageReqVO) {
        return dishesOrganizationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<DishesOrganizationDO> getDishesOrganizationList(DishesOrganizationExportReqVO exportReqVO) {
        return dishesOrganizationMapper.selectList(exportReqVO);
    }

}
