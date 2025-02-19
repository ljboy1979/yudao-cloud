package cn.iocoder.yudao.module.demo.service.category;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.demo.controller.admin.category.vo.CategoryCreateReqVO;
import cn.iocoder.yudao.module.demo.controller.admin.category.vo.CategoryExportReqVO;
import cn.iocoder.yudao.module.demo.controller.admin.category.vo.CategoryPageReqVO;
import cn.iocoder.yudao.module.demo.controller.admin.category.vo.CategoryUpdateReqVO;
import cn.iocoder.yudao.module.demo.convert.category.CategoryConvert;
import cn.iocoder.yudao.module.demo.dal.dataobject.category.CategoryDO;
import cn.iocoder.yudao.module.demo.dal.mysql.category.CategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.demo.enums.ErrorCodeConstants.CATEGORY_NOT_EXISTS;

/**
 * 商品分类 Service 实现类
 *
 * @author liuj
 */
@Service
@Validated
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public Long createCategory(CategoryCreateReqVO createReqVO) {
        // 插入
        CategoryDO category = CategoryConvert.INSTANCE.convert(createReqVO);
        categoryMapper.insert(category);
        // 返回
        return category.getId();
    }

    @Override
    public void updateCategory(CategoryUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateCategoryExists(updateReqVO.getId());
        // 更新
        CategoryDO updateObj = CategoryConvert.INSTANCE.convert(updateReqVO);
        categoryMapper.updateById(updateObj);
    }

    @Override
    public void deleteCategory(Long id) {
        // 校验存在
        this.validateCategoryExists(id);
        // 删除
        categoryMapper.deleteById(id);
    }

    private void validateCategoryExists(Long id) {
        if (categoryMapper.selectById(id) == null) {
            throw exception(CATEGORY_NOT_EXISTS);
        }
    }

    @Override
    public CategoryDO getCategory(Long id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public List<CategoryDO> getCategoryList(Collection<Long> ids) {
        return categoryMapper.selectBatchIds(ids);
    }

    @Override
    public List<CategoryDO> selectCategoryList(CategoryDO categoryDO) {
        return categoryMapper.selectList();
    }

    @Override
    public PageResult<CategoryDO> getCategoryPage(CategoryPageReqVO pageReqVO) {
        return categoryMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CategoryDO> getCategoryList(CategoryExportReqVO exportReqVO) {
        return categoryMapper.selectList(exportReqVO);
    }

}
