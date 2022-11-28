package cn.iocoder.yudao.module.transaction.sales.service.dishescategory;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.dishescategory.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.dishescategory.DishesCategoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.transaction.sales.convert.dishescategory.DishesCategoryConvert;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.dishescategory.DishesCategoryMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 菜品分类 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class DishesCategoryServiceImpl implements DishesCategoryService {

    @Resource
    private DishesCategoryMapper dishesCategoryMapper;

    @Override
    public String createDishesCategory(DishesCategoryCreateReqVO createReqVO) {
        // 插入
        DishesCategoryDO dishesCategory = DishesCategoryConvert.INSTANCE.convert(createReqVO);
        dishesCategoryMapper.insert(dishesCategory);
        // 返回
        return dishesCategory.getId();
    }

    @Override
    public void updateDishesCategory(DishesCategoryUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateDishesCategoryExists(updateReqVO.getId());
        // 更新
        DishesCategoryDO updateObj = DishesCategoryConvert.INSTANCE.convert(updateReqVO);
        dishesCategoryMapper.updateById(updateObj);
    }

    @Override
    public void deleteDishesCategory(String id) {
        // 校验存在
        this.validateDishesCategoryExists(id);
        // 删除
        dishesCategoryMapper.deleteById(id);
    }

    private void validateDishesCategoryExists(String id) {
        if (dishesCategoryMapper.selectById(id) == null) {
            throw exception(DISHES_CATEGORY_NOT_EXISTS);
        }
    }

    @Override
    public DishesCategoryDO getDishesCategory(String id) {
        return dishesCategoryMapper.selectById(id);
    }

    @Override
    public List<DishesCategoryDO> getDishesCategoryList(Collection<String> ids) {
        return dishesCategoryMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<DishesCategoryDO> getDishesCategoryPage(DishesCategoryPageReqVO pageReqVO) {
        return dishesCategoryMapper.selectPage(pageReqVO);
    }

    @Override
    public List<DishesCategoryDO> getDishesCategoryList(DishesCategoryExportReqVO exportReqVO) {
        return dishesCategoryMapper.selectList(exportReqVO);
    }

}
