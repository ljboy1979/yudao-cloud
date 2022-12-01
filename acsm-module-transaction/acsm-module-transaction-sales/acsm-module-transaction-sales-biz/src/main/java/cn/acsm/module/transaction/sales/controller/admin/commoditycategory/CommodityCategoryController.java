package cn.acsm.module.transaction.sales.controller.admin.commoditycategory;

import cn.acsm.module.transaction.sales.controller.admin.commoditycategory.vo.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeUtils;
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
import cn.acsm.module.transaction.sales.dal.dataobject.commoditycategory.CommodityCategoryDO;
import cn.acsm.module.transaction.sales.convert.commoditycategory.CommodityCategoryConvert;
import cn.acsm.module.transaction.sales.service.commoditycategory.CommodityCategoryService;

@Api(tags = "管理后台 - 商品分类")
@RestController
@RequestMapping("/sales/commodity-category")
@Validated
public class CommodityCategoryController {

    @Resource
    private CommodityCategoryService commodityCategoryService;

    @PostMapping("/create")
    @ApiOperation("创建商品分类")
    @PreAuthorize("@ss.hasPermission('sales:commodity-category:create')")
    public CommonResult<String> createCommodityCategory(@Valid @RequestBody CommodityCategoryCreateReqVO createReqVO) {
        return success(commodityCategoryService.createCommodityCategory(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新商品分类")
    @PreAuthorize("@ss.hasPermission('sales:commodity-category:update')")
    public CommonResult<Boolean> updateCommodityCategory(@Valid @RequestBody CommodityCategoryUpdateReqVO updateReqVO) {
        commodityCategoryService.updateCommodityCategory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除商品分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:commodity-category:delete')")
    public CommonResult<Boolean> deleteCommodityCategory(@RequestParam("id") String id) {
        commodityCategoryService.deleteCommodityCategory(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得商品分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:commodity-category:query')")
    public CommonResult<CommodityCategoryRespVO> getCommodityCategory(@RequestParam("id") String id) {
        CommodityCategoryDO commodityCategory = commodityCategoryService.getCommodityCategory(id);
        return success(CommodityCategoryConvert.INSTANCE.convert(commodityCategory));
    }

    @GetMapping("/list")
    @ApiOperation("获得商品分类列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:commodity-category:query')")
    public CommonResult<List<CommodityCategoryRespVO>> getCommodityCategoryList(@RequestParam("ids") Collection<String> ids) {
        List<CommodityCategoryDO> list = commodityCategoryService.getCommodityCategoryList(ids);
        return success(CommodityCategoryConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得商品分类分页")
    @PreAuthorize("@ss.hasPermission('sales:commodity-category:query')")
    public CommonResult<PageResult<CommodityCategoryRespVO>> getCommodityCategoryPage(@Valid CommodityCategoryPageReqVO pageVO) {
        PageResult<CommodityCategoryDO> pageResult = commodityCategoryService.getCommodityCategoryPage(pageVO);
        return success(CommodityCategoryConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出商品分类 Excel")
    @PreAuthorize("@ss.hasPermission('sales:commodity-category:export')")
    @OperateLog(type = EXPORT)
    public void exportCommodityCategoryExcel(@Valid CommodityCategoryExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CommodityCategoryDO> list = commodityCategoryService.getCommodityCategoryList(exportReqVO);
        // 导出 Excel
        List<CommodityCategoryExcelVO> datas = CommodityCategoryConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "商品分类.xls", "数据", CommodityCategoryExcelVO.class, datas);
    }


    @PostMapping("/treeList")
    @ApiOperation("树形分类列表")
    @PreAuthorize("@ss.hasPermission('sales:raw-material-classify:query')")
    @Cacheable(value = "/sales/commodity-category/treeList",key = "#commodityCategoryTreeVO.commodityCategoryName")
    public CommonResult<List<TreeSelect>> treeList(@Valid CommodityCategoryTreeVO commodityCategoryTreeVO) {
        List<TreeSelect> list = commodityCategoryService.findTreeList(commodityCategoryTreeVO);
        return success(list);
    }

}
