package cn.acsm.module.transaction.sales.controller.admin.salespackage;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

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

import cn.acsm.module.transaction.sales.controller.admin.salespackage.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.salespackage.PackageDO;
import cn.acsm.module.transaction.sales.convert.salespackage.PackageConvert;
import cn.acsm.module.transaction.sales.service.salespackage.PackageService;

@Api(tags = "管理后台 - 套餐")
@RestController
@RequestMapping("/sales/package")
@Validated
public class PackageController {

    @Resource
    private PackageService packageService;

    @PostMapping("/create")
    @ApiOperation("创建套餐")
    @PreAuthorize("@ss.hasPermission('sales:package:create')")
    public CommonResult<String> createPackage(@Valid @RequestBody PackageCreateReqVO createReqVO) {
        return packageService.createPackage(createReqVO);
    }

    @PutMapping("/update")
    @ApiOperation("更新套餐")
    @PreAuthorize("@ss.hasPermission('sales:package:update')")
    public CommonResult<String> updatePackage(@Valid @RequestBody PackageUpdateReqVO updateReqVO) {

        return packageService.updatePackage(updateReqVO);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除套餐")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:package:delete')")
    public CommonResult<Boolean> deletePackage(@RequestParam("id") String id) {
        packageService.deletePackage(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得套餐")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:package:query')")
    public CommonResult<PackageRespVO> getPackage(@RequestParam("id") String id) {
        PackageDO packageDO = packageService.getPackage(id);
        return success(PackageConvert.INSTANCE.convert(packageDO));
    }

    @GetMapping("/list")
    @ApiOperation("获得套餐列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:package:query')")
    public CommonResult<List<PackageRespVO>> getPackageList(@RequestParam("ids") Collection<String> ids) {
        List<PackageDO> list = packageService.getPackageList(ids);
        return success(PackageConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得套餐分页")
    @PreAuthorize("@ss.hasPermission('sales:package:query')")
    public CommonResult<PageResult<PackageRespVO>> getPackagePage(@Valid PackagePageReqVO pageVO) {
        PageResult<PackageDO> pageResult = packageService.getPackagePage(pageVO);
        return success(PackageConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出套餐 Excel")
    @PreAuthorize("@ss.hasPermission('sales:package:export')")
    @OperateLog(type = EXPORT)
    public void exportPackageExcel(@Valid PackageExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PackageDO> list = packageService.getPackageList(exportReqVO);
        // 导出 Excel
        List<PackageExcelVO> datas = PackageConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "套餐.xls", "数据", PackageExcelVO.class, datas);
    }

}
