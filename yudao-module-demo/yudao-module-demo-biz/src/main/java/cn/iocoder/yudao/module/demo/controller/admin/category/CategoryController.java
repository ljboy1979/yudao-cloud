package cn.iocoder.yudao.module.demo.controller.admin.category;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeUtils;
import cn.iocoder.yudao.module.demo.dal.dataobject.category.CategoryDO;
import cn.iocoder.yudao.module.demo.service.category.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Api(tags = "管理后台 - 商品分类")
@RestController
@RequestMapping("/demo/category")
@Validated
public class CategoryController /*extends BaseController */{

    @Resource
    private CategoryService categoryService;

    /**
     * 查询某个id组织架构树状结构列表（仅包含名称、id、子节点）
     */
    @GetMapping("/tree/{id}")
    @ApiOperation("获得商品分类树表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryDO", value = "产品分类", required = true, example = "", dataTypeClass = CategoryDO.class),
            @ApiImplicitParam(name = "id", value = "产品分类id", required = true, example = "1", dataTypeClass = Long.class)
    })
    public CommonResult<List<TreeSelect>> treeSelect(CategoryDO categoryDO, @PathVariable Long id) {
        List<TreeSelect> treeSelects = TreeUtils.
                buildTreeSelect(categoryService.selectCategoryList(categoryDO),id);
        return success(treeSelects);
    }

    /**
     * 查询全部组织架构树状结构列表（仅包含名称、id、子节点）
     */
    @GetMapping("/tree/all")
    @ApiOperation("获得指定ID商品分类树表")
    @ApiImplicitParam(name = "categoryDO", value = "产品分类", required = true, example = "", dataTypeClass = CategoryDO.class)
    public CommonResult<List<TreeSelect>> treeSelect(CategoryDO categoryDO) {
        List<TreeSelect> treeSelects = TreeUtils.
                buildTreeSelect(categoryService.selectCategoryList(categoryDO));
        return success(treeSelects);
    }

    /*
    @PostMapping("/create")
    @ApiOperation("创建商品分类")
    @PreAuthorize("@ss.hasPermission('product:category:create')")
    public CommonResult<Long> createCategory(@Valid @RequestBody CategoryCreateReqVO createReqVO) {
        return success(categoryService.createCategory(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新商品分类")
    @PreAuthorize("@ss.hasPermission('product:category:update')")
    public CommonResult<Boolean> updateCategory(@Valid @RequestBody CategoryUpdateReqVO updateReqVO) {
        categoryService.updateCategory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除商品分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('product:category:delete')")
    public CommonResult<Boolean> deleteCategory(@RequestParam("id") Long id) {
        categoryService.deleteCategory(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得商品分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('product:category:query')")
    public CommonResult<CategoryRespVO> getCategory(@RequestParam("id") Long id) {
        CategoryDO category = categoryService.getCategory(id);
        return success(CategoryConvert.INSTANCE.convert(category));
    }

    @GetMapping("/list")
    @ApiOperation("获得商品分类列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('product:category:query')")
    public CommonResult<List<CategoryRespVO>> getCategoryList(@RequestParam("ids") Collection<Long> ids) {
        List<CategoryDO> list = categoryService.getCategoryList(ids);
        return success(CategoryConvert.INSTANCE.convertList(list));
    }


    @GetMapping("/page")
    @ApiOperation("获得商品分类分页")
    @PreAuthorize("@ss.hasPermission('product:category:query')")
    public CommonResult<PageResult<CategoryRespVO>> getCategoryPage(@Valid CategoryPageReqVO pageVO) {
        PageResult<CategoryDO> pageResult = categoryService.getCategoryPage(pageVO);
        return success(CategoryConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出商品分类 Excel")
    @PreAuthorize("@ss.hasPermission('product:category:export')")
    @OperateLog(type = EXPORT)
    public void exportCategoryExcel(@Valid CategoryExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CategoryDO> list = categoryService.getCategoryList(exportReqVO);
        // 导出 Excel
        List<CategoryExcelVO> datas = CategoryConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "商品分类.xls", "数据", CategoryExcelVO.class, datas);
    }
*/
}
