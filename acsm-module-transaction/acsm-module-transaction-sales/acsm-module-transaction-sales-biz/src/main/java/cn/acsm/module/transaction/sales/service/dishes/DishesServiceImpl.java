package cn.acsm.module.transaction.sales.service.dishes;

import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.acsm.module.transaction.sales.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.sales.controller.admin.dishes.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.dishes.DishesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.dishes.DishesConvert;
import cn.acsm.module.transaction.sales.dal.mysql.dishes.DishesMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 菜品 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class DishesServiceImpl implements DishesService {

    @Resource
    private DishesMapper dishesMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;
    @Override
    public CommonResult<String> createDishes(DishesCreateReqVO createReqVO) {
        DishesDO dishesDO = new DishesDO();
        dishesDO.setDishesName(createReqVO.getDishesName());
        dishesDO.setMenuClassification(createReqVO.getMenuClassification());
        Long num = dishesMapper.findSelectCount(dishesDO);
        if (num!=null && num>0){
            return CommonResult.error(ErrorCodeConstants.DISHES_NOT_EXISTENCE);
        }
        // 插入
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("sales_dishes"+tenantId);
        DishesDO dishes = DishesConvert.INSTANCE.convert(createReqVO);
        dishes.setId(UUID.randomUUID().toString());
        dishes.setIngredientNumber("CP"+number);
        dishesMapper.insert(dishes);
        // 返回
        return CommonResult.success(dishes.getId());
    }

    @Override
    public CommonResult<String> updateDishes(DishesUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateDishesExists(updateReqVO.getId());
        DishesDO dishesDO = new DishesDO();
        dishesDO.setDishesName(updateReqVO.getDishesName());
        dishesDO.setMenuClassification(updateReqVO.getMenuClassification());
        dishesDO.setId(updateReqVO.getId());
        Long num = dishesMapper.findSelectCount(dishesDO);
        if (num!=null && num>0){
            return CommonResult.error(ErrorCodeConstants.DISHES_NOT_EXISTENCE);
        }
        // 更新
        DishesDO updateObj = DishesConvert.INSTANCE.convert(updateReqVO);
        dishesMapper.updateById(updateObj);
        return CommonResult.success("成功");

    }

    @Override
    public void deleteDishes(String id) {
        // 校验存在
        this.validateDishesExists(id);
        // 删除
        dishesMapper.deleteById(id);
    }

    private void validateDishesExists(String id) {
        if (dishesMapper.selectById(id) == null) {
            throw exception(DISHES_NOT_EXISTS);
        }
    }

    @Override
    public DishesDO getDishes(String id) {
        return dishesMapper.selectById(id);
    }

    @Override
    public List<DishesDO> getDishesList(Collection<String> ids) {
        return dishesMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<DishesDO> getDishesPage(DishesPageReqVO pageReqVO) {
        return dishesMapper.selectPage(pageReqVO);
    }

    @Override
    public List<DishesDO> getDishesList(DishesExportReqVO exportReqVO) {
        return dishesMapper.selectList(exportReqVO);
    }

}
