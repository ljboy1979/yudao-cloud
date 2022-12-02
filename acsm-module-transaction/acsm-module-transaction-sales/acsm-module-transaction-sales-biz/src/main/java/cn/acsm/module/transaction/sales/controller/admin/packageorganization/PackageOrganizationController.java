package cn.acsm.module.transaction.sales.controller.admin.packageorganization;

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

import cn.acsm.module.transaction.sales.controller.admin.packageorganization.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.packageorganization.PackageOrganizationDO;
import cn.acsm.module.transaction.sales.convert.packageorganization.PackageOrganizationConvert;
import cn.acsm.module.transaction.sales.service.packageorganization.PackageOrganizationService;

@Api(tags = "管理后台 - 套餐组成")
@RestController
@RequestMapping("/sales/package-organization")
@Validated
public class PackageOrganizationController {

    @Resource
    private PackageOrganizationService packageOrganizationService;

    @PostMapping("/create")
    @ApiOperation("创建套餐组成")
    @PreAuthorize("@ss.hasPermission('sales:package-organization:create')")
    public CommonResult<String> createPackageOrganization(@Valid @RequestBody PackageOrganizationCreateReqVO createReqVO) {
        return packageOrganizationService.createPackageOrganization(createReqVO);
    }

    @PutMapping("/update")
    @ApiOperation("更新套餐组成")
    @PreAuthorize("@ss.hasPermission('sales:package-organization:update')")
    public CommonResult<String> updatePackageOrganization(@Valid @RequestBody PackageOrganizationUpdateReqVO updateReqVO) {

        return packageOrganizationService.updatePackageOrganization(updateReqVO);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除套餐组成")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:package-organization:delete')")
    public CommonResult<Boolean> deletePackageOrganization(@RequestParam("id") String id) {
        packageOrganizationService.deletePackageOrganization(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得套餐组成")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:package-organization:query')")
    public CommonResult<PackageOrganizationRespVO> getPackageOrganization(@RequestParam("id") String id) {
        PackageOrganizationDO packageOrganization = packageOrganizationService.getPackageOrganization(id);
        return success(PackageOrganizationConvert.INSTANCE.convert(packageOrganization));
    }

    @GetMapping("/list")
    @ApiOperation("获得套餐组成列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:package-organization:query')")
    public CommonResult<List<PackageOrganizationRespVO>> getPackageOrganizationList(@RequestParam("ids") Collection<String> ids) {
        List<PackageOrganizationDO> list = packageOrganizationService.getPackageOrganizationList(ids);
        return success(PackageOrganizationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得套餐组成分页")
    @PreAuthorize("@ss.hasPermission('sales:package-organization:query')")
    public CommonResult<PageResult<PackageOrganizationRespVO>> getPackageOrganizationPage(@Valid PackageOrganizationPageReqVO pageVO) {
        PageResult<PackageOrganizationDO> pageResult = packageOrganizationService.getPackageOrganizationPage(pageVO);
        return success(PackageOrganizationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出套餐组成 Excel")
    @PreAuthorize("@ss.hasPermission('sales:package-organization:export')")
    @OperateLog(type = EXPORT)
    public void exportPackageOrganizationExcel(@Valid PackageOrganizationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PackageOrganizationDO> list = packageOrganizationService.getPackageOrganizationList(exportReqVO);
        // 导出 Excel
        List<PackageOrganizationExcelVO> datas = PackageOrganizationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "套餐组成.xls", "数据", PackageOrganizationExcelVO.class, datas);
    }

}
