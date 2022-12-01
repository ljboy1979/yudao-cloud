package cn.acsm.module.transaction.sales.controller.admin.packageclassify;

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

import cn.acsm.module.transaction.sales.controller.admin.packageclassify.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.packageclassify.PackageClassifyDO;
import cn.acsm.module.transaction.sales.convert.packageclassify.PackageClassifyConvert;
import cn.acsm.module.transaction.sales.service.packageclassify.PackageClassifyService;

@Api(tags = "管理后台 - 套餐分类")
@RestController
@RequestMapping("/sales/package-classify")
@Validated
public class PackageClassifyController {

    @Resource
    private PackageClassifyService packageClassifyService;

    @PostMapping("/create")
    @ApiOperation("创建套餐分类")
    @PreAuthorize("@ss.hasPermission('sales:package-classify:create')")
    public CommonResult<String> createPackageClassify(@Valid @RequestBody PackageClassifyCreateReqVO createReqVO) {
        return success(packageClassifyService.createPackageClassify(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新套餐分类")
    @PreAuthorize("@ss.hasPermission('sales:package-classify:update')")
    public CommonResult<Boolean> updatePackageClassify(@Valid @RequestBody PackageClassifyUpdateReqVO updateReqVO) {
        packageClassifyService.updatePackageClassify(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除套餐分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:package-classify:delete')")
    public CommonResult<Boolean> deletePackageClassify(@RequestParam("id") String id) {
        packageClassifyService.deletePackageClassify(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得套餐分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:package-classify:query')")
    public CommonResult<PackageClassifyRespVO> getPackageClassify(@RequestParam("id") String id) {
        PackageClassifyDO packageClassify = packageClassifyService.getPackageClassify(id);
        return success(PackageClassifyConvert.INSTANCE.convert(packageClassify));
    }

    @GetMapping("/list")
    @ApiOperation("获得套餐分类列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:package-classify:query')")
    public CommonResult<List<PackageClassifyRespVO>> getPackageClassifyList(@RequestParam("ids") Collection<String> ids) {
        List<PackageClassifyDO> list = packageClassifyService.getPackageClassifyList(ids);
        return success(PackageClassifyConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得套餐分类分页")
    @PreAuthorize("@ss.hasPermission('sales:package-classify:query')")
    public CommonResult<PageResult<PackageClassifyRespVO>> getPackageClassifyPage(@Valid PackageClassifyPageReqVO pageVO) {
        PageResult<PackageClassifyDO> pageResult = packageClassifyService.getPackageClassifyPage(pageVO);
        return success(PackageClassifyConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出套餐分类 Excel")
    @PreAuthorize("@ss.hasPermission('sales:package-classify:export')")
    @OperateLog(type = EXPORT)
    public void exportPackageClassifyExcel(@Valid PackageClassifyExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PackageClassifyDO> list = packageClassifyService.getPackageClassifyList(exportReqVO);
        // 导出 Excel
        List<PackageClassifyExcelVO> datas = PackageClassifyConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "套餐分类.xls", "数据", PackageClassifyExcelVO.class, datas);
    }

    @PostMapping("/treeList")
    @ApiOperation("树形分类列表")
    @PreAuthorize("@ss.hasPermission('sales:raw-material-classify:query')")
    @Cacheable(value = "/sales/package-classify/treeList",key = "#packageClassifyTreeVO.categoryName")
    public CommonResult<List<TreeSelect>> treeList(@Valid PackageClassifyTreeVO packageClassifyTreeVO) {
        List<TreeSelect> list = packageClassifyService.findTreeList(packageClassifyTreeVO);
        return success(list);
    }

}
