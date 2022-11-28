package cn.iocoder.yudao.module.transaction.sales.service.dishes;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.dishes.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.dishes.DishesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.transaction.sales.convert.dishes.DishesConvert;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.dishes.DishesMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.transaction.sales.enums.ErrorCodeConstants.*;

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

    @Override
    public String createDishes(DishesCreateReqVO createReqVO) {
        // 插入
        DishesDO dishes = DishesConvert.INSTANCE.convert(createReqVO);
        dishesMapper.insert(dishes);
        // 返回
        return dishes.getId();
    }

    @Override
    public void updateDishes(DishesUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateDishesExists(updateReqVO.getId());
        // 更新
        DishesDO updateObj = DishesConvert.INSTANCE.convert(updateReqVO);
        dishesMapper.updateById(updateObj);
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
