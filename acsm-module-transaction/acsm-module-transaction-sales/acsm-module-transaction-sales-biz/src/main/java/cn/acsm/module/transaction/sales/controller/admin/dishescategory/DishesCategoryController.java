package cn.acsm.module.transaction.sales.controller.admin.dishescategory;

import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryPageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryUpdateReqVO;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.dishescategory.DishesCategoryDO;
import cn.acsm.module.transaction.sales.convert.dishescategory.DishesCategoryConvert;
import cn.acsm.module.transaction.sales.service.dishescategory.DishesCategoryService;

@Api(tags = "管理后台 - 菜品分类")
@RestController
@RequestMapping("/sales/dishes-category")
@Validated
public class DishesCategoryController {

    @Resource
    private DishesCategoryService dishesCategoryService;

    @PostMapping("/create")
    @ApiOperation("创建菜品分类")
    @PreAuthorize("@ss.hasPermission('sales:dishes-category:create')")
    public CommonResult<String> createDishesCategory(@Valid @RequestBody DishesCategoryCreateReqVO createReqVO) {
        return success(dishesCategoryService.createDishesCategory(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新菜品分类")
    @PreAuthorize("@ss.hasPermission('sales:dishes-category:update')")
    public CommonResult<Boolean> updateDishesCategory(@Valid @RequestBody DishesCategoryUpdateReqVO updateReqVO) {
        dishesCategoryService.updateDishesCategory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除菜品分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:dishes-category:delete')")
    public CommonResult<Boolean> deleteDishesCategory(@RequestParam("id") String id) {
        dishesCategoryService.deleteDishesCategory(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得菜品分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:dishes-category:query')")
    public CommonResult<DishesCategoryRespVO> getDishesCategory(@RequestParam("id") String id) {
        DishesCategoryDO dishesCategory = dishesCategoryService.getDishesCategory(id);
        return success(DishesCategoryConvert.INSTANCE.convert(dishesCategory));
    }

    @GetMapping("/list")
    @ApiOperation("获得菜品分类列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:dishes-category:query')")
    public CommonResult<List<DishesCategoryRespVO>> getDishesCategoryList(@RequestParam("ids") Collection<String> ids) {
        List<DishesCategoryDO> list = dishesCategoryService.getDishesCategoryList(ids);
        return success(DishesCategoryConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得菜品分类分页")
    @PreAuthorize("@ss.hasPermission('sales:dishes-category:query')")
    public CommonResult<PageResult<DishesCategoryRespVO>> getDishesCategoryPage(@Valid DishesCategoryPageReqVO pageVO) {
        PageResult<DishesCategoryDO> pageResult = dishesCategoryService.getDishesCategoryPage(pageVO);
        return success(DishesCategoryConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出菜品分类 Excel")
    @PreAuthorize("@ss.hasPermission('sales:dishes-category:export')")
    @OperateLog(type = EXPORT)
    public void exportDishesCategoryExcel(@Valid DishesCategoryExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<DishesCategoryDO> list = dishesCategoryService.getDishesCategoryList(exportReqVO);
        // 导出 Excel
        List<DishesCategoryExcelVO> datas = DishesCategoryConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "菜品分类.xls", "数据", DishesCategoryExcelVO.class, datas);
    }

    @PostMapping("/treeList")
    @ApiOperation("树形分类列表")
    @PreAuthorize("@ss.hasPermission('sales:input-classify:query')")
    @Cacheable(value = "/sales/dishes-category/treeList",key = "#dishesCategoryTreeVO.categoryName")
    public CommonResult<List<TreeSelect>> treeList(@Valid DishesCategoryTreeVO dishesCategoryTreeVO) {
        List<TreeSelect> list = dishesCategoryService.findTreeList(dishesCategoryTreeVO);
        return success(list);
    }

}
