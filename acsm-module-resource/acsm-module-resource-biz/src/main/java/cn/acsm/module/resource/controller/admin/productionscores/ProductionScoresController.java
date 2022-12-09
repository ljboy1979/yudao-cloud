package cn.acsm.module.resource.controller.admin.productionscores;

import cn.acsm.module.resource.controller.admin.productionscores.vo.*;
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

import cn.acsm.module.resource.dal.dataobject.productionscores.ProductionScoresDO;
import cn.acsm.module.resource.convert.productionscores.ProductionScoresConvert;
import cn.acsm.module.resource.service.productionscores.ProductionScoresService;

@Api(tags = "管理后台 - 服务资源-生产品种")
@RestController
@RequestMapping("/resource/production-scores")
@Validated
public class ProductionScoresController {

    @Resource
    private ProductionScoresService productionScoresService;

    @PostMapping("/create")
    @ApiOperation("创建服务资源-生产品种")
    @PreAuthorize("@ss.hasPermission('service:production-scores:create')")
    public CommonResult<Long> createProductionScores(@Valid @RequestBody ProductionScoresCreateReqVO createReqVO) {
        return success(productionScoresService.createProductionScores(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新服务资源-生产品种")
    @PreAuthorize("@ss.hasPermission('service:production-scores:update')")
    public CommonResult<Boolean> updateProductionScores(@Valid @RequestBody ProductionScoresUpdateReqVO updateReqVO) {
        productionScoresService.updateProductionScores(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除服务资源-生产品种")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:production-scores:delete')")
    public CommonResult<Boolean> deleteProductionScores(@RequestParam("id") Long id) {
        productionScoresService.deleteProductionScores(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得服务资源-生产品种")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:production-scores:query')")
    public CommonResult<ProductionScoresRespVO> getProductionScores(@RequestParam("id") Long id) {
        ProductionScoresDO productionScores = productionScoresService.getProductionScores(id);
        return success(ProductionScoresConvert.INSTANCE.convert(productionScores));
    }

    @GetMapping("/list")
    @ApiOperation("获得服务资源-生产品种列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('service:production-scores:query')")
    public CommonResult<List<ProductionScoresRespVO>> getProductionScoresList(@RequestParam("ids") Collection<Long> ids) {
        List<ProductionScoresDO> list = productionScoresService.getProductionScoresList(ids);
        return success(ProductionScoresConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得服务资源-生产品种分页")
    @PreAuthorize("@ss.hasPermission('service:production-scores:query')")
    public CommonResult<PageResult<ProductionScoresRespVO>> getProductionScoresPage(@Valid ProductionScoresPageReqVO pageVO) {
        PageResult<ProductionScoresDO> pageResult = productionScoresService.getProductionScoresPage(pageVO);
        return success(ProductionScoresConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出服务资源-生产品种 Excel")
    @PreAuthorize("@ss.hasPermission('service:production-scores:export')")
    @OperateLog(type = EXPORT)
    public void exportProductionScoresExcel(@Valid ProductionScoresExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ProductionScoresDO> list = productionScoresService.getProductionScoresList(exportReqVO);
        // 导出 Excel
        List<ProductionScoresExcelVO> datas = ProductionScoresConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "服务资源-生产品种.xls", "数据", ProductionScoresExcelVO.class, datas);
    }

}
