package cn.acsm.module.transaction.sales.controller.admin.specialmedicalfood;

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

import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfood.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfood.SpecialMedicalFoodDO;
import cn.acsm.module.transaction.sales.convert.specialmedicalfood.SpecialMedicalFoodConvert;
import cn.acsm.module.transaction.sales.service.specialmedicalfood.SpecialMedicalFoodService;

@Api(tags = "管理后台 - 特医食品")
@RestController
@RequestMapping("/sales/special-medical-food")
@Validated
public class SpecialMedicalFoodController {

    @Resource
    private SpecialMedicalFoodService specialMedicalFoodService;

    @PostMapping("/create")
    @ApiOperation("创建特医食品")
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food:create')")
    public CommonResult<String> createSpecialMedicalFood(@Valid @RequestBody SpecialMedicalFoodCreateReqVO createReqVO) {
        return specialMedicalFoodService.createSpecialMedicalFood(createReqVO);
    }

    @PutMapping("/update")
    @ApiOperation("更新特医食品")
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food:update')")
    public CommonResult<String> updateSpecialMedicalFood(@Valid @RequestBody SpecialMedicalFoodUpdateReqVO updateReqVO) {
        return  specialMedicalFoodService.updateSpecialMedicalFood(updateReqVO);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除特医食品")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food:delete')")
    public CommonResult<Boolean> deleteSpecialMedicalFood(@RequestParam("id") String id) {
        specialMedicalFoodService.deleteSpecialMedicalFood(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得特医食品")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food:query')")
    public CommonResult<SpecialMedicalFoodRespVO> getSpecialMedicalFood(@RequestParam("id") String id) {
        SpecialMedicalFoodDO specialMedicalFood = specialMedicalFoodService.getSpecialMedicalFood(id);
        return success(SpecialMedicalFoodConvert.INSTANCE.convert(specialMedicalFood));
    }

    @GetMapping("/list")
    @ApiOperation("获得特医食品列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food:query')")
    public CommonResult<List<SpecialMedicalFoodRespVO>> getSpecialMedicalFoodList(@RequestParam("ids") Collection<String> ids) {
        List<SpecialMedicalFoodDO> list = specialMedicalFoodService.getSpecialMedicalFoodList(ids);
        return success(SpecialMedicalFoodConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得特医食品分页")
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food:query')")
    public CommonResult<PageResult<SpecialMedicalFoodRespVO>> getSpecialMedicalFoodPage(@Valid SpecialMedicalFoodPageReqVO pageVO) {
        PageResult<SpecialMedicalFoodDO> pageResult = specialMedicalFoodService.getSpecialMedicalFoodPage(pageVO);
        return success(SpecialMedicalFoodConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出特医食品 Excel")
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food:export')")
    @OperateLog(type = EXPORT)
    public void exportSpecialMedicalFoodExcel(@Valid SpecialMedicalFoodExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<SpecialMedicalFoodDO> list = specialMedicalFoodService.getSpecialMedicalFoodList(exportReqVO);
        // 导出 Excel
        List<SpecialMedicalFoodExcelVO> datas = SpecialMedicalFoodConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "特医食品.xls", "数据", SpecialMedicalFoodExcelVO.class, datas);
    }

}
