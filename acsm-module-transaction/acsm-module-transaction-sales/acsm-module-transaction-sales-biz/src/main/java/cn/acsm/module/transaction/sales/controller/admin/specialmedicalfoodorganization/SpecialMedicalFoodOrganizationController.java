package cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodorganization;

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

import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodorganization.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodorganization.SpecialMedicalFoodOrganizationDO;
import cn.acsm.module.transaction.sales.convert.specialmedicalfoodorganization.SpecialMedicalFoodOrganizationConvert;
import cn.acsm.module.transaction.sales.service.specialmedicalfoodorganization.SpecialMedicalFoodOrganizationService;

@Api(tags = "管理后台 - 特医食品组成")
@RestController
@RequestMapping("/sales/special-medical-food-organization")
@Validated
public class SpecialMedicalFoodOrganizationController {

    @Resource
    private SpecialMedicalFoodOrganizationService specialMedicalFoodOrganizationService;

    @PostMapping("/create")
    @ApiOperation("创建特医食品组成")
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-organization:create')")
    public CommonResult<String> createSpecialMedicalFoodOrganization(@Valid @RequestBody SpecialMedicalFoodOrganCreateReqVO createReqVO) {
        return success(specialMedicalFoodOrganizationService.createSpecialMedicalFoodOrganization(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新特医食品组成")
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-organization:update')")
    public CommonResult<Boolean> updateSpecialMedicalFoodOrganization(@Valid @RequestBody SpecialMedicalFoodOrganUpdateReqVO updateReqVO) {
        specialMedicalFoodOrganizationService.updateSpecialMedicalFoodOrganization(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除特医食品组成")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-organization:delete')")
    public CommonResult<Boolean> deleteSpecialMedicalFoodOrganization(@RequestParam("id") String id) {
        specialMedicalFoodOrganizationService.deleteSpecialMedicalFoodOrganization(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得特医食品组成")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-organization:query')")
    public CommonResult<SpecialMedicalFoodOrganizationRespVO> getSpecialMedicalFoodOrganization(@RequestParam("id") String id) {
        SpecialMedicalFoodOrganizationDO specialMedicalFoodOrganization = specialMedicalFoodOrganizationService.getSpecialMedicalFoodOrganization(id);
        return success(SpecialMedicalFoodOrganizationConvert.INSTANCE.convert(specialMedicalFoodOrganization));
    }

    @GetMapping("/list")
    @ApiOperation("获得特医食品组成列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-organization:query')")
    public CommonResult<List<SpecialMedicalFoodOrganizationRespVO>> getSpecialMedicalFoodOrganizationList(@RequestParam("ids") Collection<String> ids) {
        List<SpecialMedicalFoodOrganizationDO> list = specialMedicalFoodOrganizationService.getSpecialMedicalFoodOrganizationList(ids);
        return success(SpecialMedicalFoodOrganizationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得特医食品组成分页")
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-organization:query')")
    public CommonResult<PageResult<SpecialMedicalFoodOrganizationRespVO>> getSpecialMedicalFoodOrganizationPage(@Valid SpecialMedicalFoodOrganizationPageReqVO pageVO) {
        PageResult<SpecialMedicalFoodOrganizationDO> pageResult = specialMedicalFoodOrganizationService.getSpecialMedicalFoodOrganizationPage(pageVO);
        return success(SpecialMedicalFoodOrganizationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出特医食品组成 Excel")
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-organization:export')")
    @OperateLog(type = EXPORT)
    public void exportSpecialMedicalFoodOrganizationExcel(@Valid SpecialMedicalFoodOrganExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<SpecialMedicalFoodOrganizationDO> list = specialMedicalFoodOrganizationService.getSpecialMedicalFoodOrganizationList(exportReqVO);
        // 导出 Excel
        List<SpecialMedicalFoodOrganizationExcelVO> datas = SpecialMedicalFoodOrganizationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "特医食品组成.xls", "数据", SpecialMedicalFoodOrganizationExcelVO.class, datas);
    }

}
