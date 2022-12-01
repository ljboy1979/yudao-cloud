package cn.acsm.module.transaction.sales.controller.admin.packagespecification;

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

import cn.acsm.module.transaction.sales.controller.admin.packagespecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.packagespecification.PackageSpecificationDO;
import cn.acsm.module.transaction.sales.convert.packagespecification.PackageSpecificationConvert;
import cn.acsm.module.transaction.sales.service.packagespecification.PackageSpecificationService;

@Api(tags = "管理后台 - 套餐规格")
@RestController
@RequestMapping("/sales/package-specification")
@Validated
public class PackageSpecificationController {

    @Resource
    private PackageSpecificationService packageSpecificationService;

    @PostMapping("/create")
    @ApiOperation("创建套餐规格")
    @PreAuthorize("@ss.hasPermission('sales:package-specification:create')")
    public CommonResult<String> createPackageSpecification(@Valid @RequestBody PackageSpecificationCreateReqVO createReqVO) {
        return packageSpecificationService.createPackageSpecification(createReqVO);
    }

    @PutMapping("/update")
    @ApiOperation("更新套餐规格")
    @PreAuthorize("@ss.hasPermission('sales:package-specification:update')")
    public CommonResult<String> updatePackageSpecification(@Valid @RequestBody PackageSpecificationUpdateReqVO updateReqVO) {

        return packageSpecificationService.updatePackageSpecification(updateReqVO);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除套餐规格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:package-specification:delete')")
    public CommonResult<Boolean> deletePackageSpecification(@RequestParam("id") String id) {
        packageSpecificationService.deletePackageSpecification(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得套餐规格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:package-specification:query')")
    public CommonResult<PackageSpecificationRespVO> getPackageSpecification(@RequestParam("id") String id) {
        PackageSpecificationDO packageSpecification = packageSpecificationService.getPackageSpecification(id);
        return success(PackageSpecificationConvert.INSTANCE.convert(packageSpecification));
    }

    @GetMapping("/list")
    @ApiOperation("获得套餐规格列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:package-specification:query')")
    public CommonResult<List<PackageSpecificationRespVO>> getPackageSpecificationList(@RequestParam("ids") Collection<String> ids) {
        List<PackageSpecificationDO> list = packageSpecificationService.getPackageSpecificationList(ids);
        return success(PackageSpecificationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得套餐规格分页")
    @PreAuthorize("@ss.hasPermission('sales:package-specification:query')")
    public CommonResult<PageResult<PackageSpecificationRespVO>> getPackageSpecificationPage(@Valid PackageSpecificationPageReqVO pageVO) {
        PageResult<PackageSpecificationDO> pageResult = packageSpecificationService.getPackageSpecificationPage(pageVO);
        return success(PackageSpecificationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出套餐规格 Excel")
    @PreAuthorize("@ss.hasPermission('sales:package-specification:export')")
    @OperateLog(type = EXPORT)
    public void exportPackageSpecificationExcel(@Valid PackageSpecificationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PackageSpecificationDO> list = packageSpecificationService.getPackageSpecificationList(exportReqVO);
        // 导出 Excel
        List<PackageSpecificationExcelVO> datas = PackageSpecificationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "套餐规格.xls", "数据", PackageSpecificationExcelVO.class, datas);
    }

}
