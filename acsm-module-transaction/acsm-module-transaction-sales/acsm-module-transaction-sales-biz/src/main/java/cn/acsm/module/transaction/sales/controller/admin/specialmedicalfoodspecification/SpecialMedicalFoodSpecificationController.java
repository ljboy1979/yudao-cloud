package cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodspecification;

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

import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodspecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodspecification.SpecialMedicalFoodSpecificationDO;
import cn.acsm.module.transaction.sales.convert.specialmedicalfoodspecification.SpecialMedicalFoodSpecificationConvert;
import cn.acsm.module.transaction.sales.service.specialmedicalfoodspecification.SpecialMedicalFoodSpecificationService;

@Api(tags = "管理后台 - 特医食品规格")
@RestController
@RequestMapping("/sales/special-medical-food-specification")
@Validated
public class SpecialMedicalFoodSpecificationController {

    @Resource
    private SpecialMedicalFoodSpecificationService specialMedicalFoodSpecificationService;

    @PostMapping("/create")
    @ApiOperation("创建特医食品规格")
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-specification:create')")
    public CommonResult<String> createSpecialMedicalFoodSpecification(@Valid @RequestBody SpecialMedicalFoodSpecificationCreateReqVO createReqVO) {
        return specialMedicalFoodSpecificationService.createSpecialMedicalFoodSpecification(createReqVO);
    }

    @PutMapping("/update")
    @ApiOperation("更新特医食品规格")
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-specification:update')")
    public CommonResult<String> updateSpecialMedicalFoodSpecification(@Valid @RequestBody SpecialMedicalFoodSpecificationUpdateReqVO updateReqVO) {

        return specialMedicalFoodSpecificationService.updateSpecialMedicalFoodSpecification(updateReqVO);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除特医食品规格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-specification:delete')")
    public CommonResult<Boolean> deleteSpecialMedicalFoodSpecification(@RequestParam("id") String id) {
        specialMedicalFoodSpecificationService.deleteSpecialMedicalFoodSpecification(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得特医食品规格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-specification:query')")
    public CommonResult<SpecialMedicalFoodSpecificationRespVO> getSpecialMedicalFoodSpecification(@RequestParam("id") String id) {
        SpecialMedicalFoodSpecificationDO specialMedicalFoodSpecification = specialMedicalFoodSpecificationService.getSpecialMedicalFoodSpecification(id);
        return success(SpecialMedicalFoodSpecificationConvert.INSTANCE.convert(specialMedicalFoodSpecification));
    }

    @GetMapping("/list")
    @ApiOperation("获得特医食品规格列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-specification:query')")
    public CommonResult<List<SpecialMedicalFoodSpecificationRespVO>> getSpecialMedicalFoodSpecificationList(@RequestParam("ids") Collection<String> ids) {
        List<SpecialMedicalFoodSpecificationDO> list = specialMedicalFoodSpecificationService.getSpecialMedicalFoodSpecificationList(ids);
        return success(SpecialMedicalFoodSpecificationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得特医食品规格分页")
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-specification:query')")
    public CommonResult<PageResult<SpecialMedicalFoodSpecificationRespVO>> getSpecialMedicalFoodSpecificationPage(@Valid SpecialMedicalFoodSpecificationPageReqVO pageVO) {
        PageResult<SpecialMedicalFoodSpecificationDO> pageResult = specialMedicalFoodSpecificationService.getSpecialMedicalFoodSpecificationPage(pageVO);
        return success(SpecialMedicalFoodSpecificationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出特医食品规格 Excel")
    @PreAuthorize("@ss.hasPermission('sales:special-medical-food-specification:export')")
    @OperateLog(type = EXPORT)
    public void exportSpecialMedicalFoodSpecificationExcel(@Valid SpecialMedicalFoodSpecificationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<SpecialMedicalFoodSpecificationDO> list = specialMedicalFoodSpecificationService.getSpecialMedicalFoodSpecificationList(exportReqVO);
        // 导出 Excel
        List<SpecialMedicalFoodSpecificationExcelVO> datas = SpecialMedicalFoodSpecificationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "特医食品规格.xls", "数据", SpecialMedicalFoodSpecificationExcelVO.class, datas);
    }

}
