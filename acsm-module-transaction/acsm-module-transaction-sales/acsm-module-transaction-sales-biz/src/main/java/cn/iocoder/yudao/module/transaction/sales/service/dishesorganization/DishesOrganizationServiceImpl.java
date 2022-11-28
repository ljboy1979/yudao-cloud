package cn.iocoder.yudao.module.transaction.sales.service.dishesorganization;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.rawmaterial.RawMaterialDO;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.rawmaterial.RawMaterialMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.dishesorganization.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.dishesorganization.DishesOrganizationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.transaction.sales.convert.dishesorganization.DishesOrganizationConvert;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.dishesorganization.DishesOrganizationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.transaction.sales.enums.ErrorCodeConstants.*;

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
    @Override
    public CommonResult<String> createDishesOrganization(DishesOrganizationCreateReqVO createReqVO) {
        RawMaterialDO rawMaterialDO = rawMaterialMapper.selectById(createReqVO.getRawMaterialId());
        if (rawMaterialDO!=null){
            return CommonResult.error(RAW_MATERIAL_NOT_EXISTS);
        }
        // 插入
        DishesOrganizationDO dishesOrganization = DishesOrganizationConvert.INSTANCE.convert(createReqVO);
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
