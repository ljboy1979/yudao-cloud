package cn.acsm.module.production.bases.controller.admin.productioncapacityplans;

import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.*;
import cn.acsm.module.production.bases.convert.productioncapacityplans.ProductionCapacityPlansConvert;
import cn.acsm.module.production.bases.dal.dataobject.productioncapacityplans.ProductionCapacityPlansDO;
import cn.acsm.module.production.bases.service.productioncapacityplans.ProductionCapacityPlansService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

@Api(tags = "管理后台 - 产能计划")
@RestController
@RequestMapping("/bases/production-capacity-plans")
@Validated
public class ProductionCapacityPlansController {

    @Resource
    private ProductionCapacityPlansService productionCapacityPlansService;

    @PostMapping("/create")
    @ApiOperation("创建产能计划")
    @PreAuthorize("@ss.hasPermission('bases:production-capacity-plans:create')")
    public CommonResult<Long> createProductionCapacityPlans(@Valid @RequestBody ProductionCapacityPlansCreateReqVO createReqVO) {
        return success(productionCapacityPlansService.createProductionCapacityPlans(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新产能计划")
    @PreAuthorize("@ss.hasPermission('bases:production-capacity-plans:update')")
    public CommonResult<Boolean> updateProductionCapacityPlans(@Valid @RequestBody ProductionCapacityPlansUpdateReqVO updateReqVO) {
        productionCapacityPlansService.updateProductionCapacityPlans(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除产能计划")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bases:production-capacity-plans:delete')")
    public CommonResult<Boolean> deleteProductionCapacityPlans(@RequestParam("id") Long id) {
        productionCapacityPlansService.deleteProductionCapacityPlans(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得产能计划")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bases:production-capacity-plans:query')")
    public CommonResult<ProductionCapacityPlansRespVO> getProductionCapacityPlans(@RequestParam("id") Long id) {
        ProductionCapacityPlansDO productionCapacityPlans = productionCapacityPlansService.getProductionCapacityPlans(id);
        return success(ProductionCapacityPlansConvert.INSTANCE.convert(productionCapacityPlans));
    }

    @GetMapping("/list")
    @ApiOperation("获得产能计划列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('bases:production-capacity-plans:query')")
    public CommonResult<List<ProductionCapacityPlansRespVO>> getProductionCapacityPlansList(@RequestParam("ids") Collection<Long> ids) {
        List<ProductionCapacityPlansDO> list = productionCapacityPlansService.getProductionCapacityPlansList(ids);
        return success(ProductionCapacityPlansConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得产能计划分页")
    @PreAuthorize("@ss.hasPermission('bases:production-capacity-plans:query')")
    public CommonResult<PageResult<ProductionCapacityPlansRespVO>> getProductionCapacityPlansPage(@Valid ProductionCapacityPlansPageReqVO pageVO) {
        PageResult<ProductionCapacityPlansDO> pageResult = productionCapacityPlansService.getProductionCapacityPlansPage(pageVO);
        return success(ProductionCapacityPlansConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出产能计划 Excel")
    @PreAuthorize("@ss.hasPermission('bases:production-capacity-plans:export')")
    @OperateLog(type = EXPORT)
    public void exportProductionCapacityPlansExcel(@Valid ProductionCapacityPlansExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ProductionCapacityPlansDO> list = productionCapacityPlansService.getProductionCapacityPlansList(exportReqVO);
        // 导出 Excel
        List<ProductionCapacityPlansExcelVO> datas = ProductionCapacityPlansConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "产能计划.xls", "数据", ProductionCapacityPlansExcelVO.class, datas);
    }

}
