package cn.acsm.module.transaction.sales.controller.admin.nutritionfacts;

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

import cn.acsm.module.transaction.sales.controller.admin.nutritionfacts.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.nutritionfacts.NutritionFactsDO;
import cn.acsm.module.transaction.sales.convert.nutritionfacts.NutritionFactsConvert;
import cn.acsm.module.transaction.sales.service.nutritionfacts.NutritionFactsService;

@Api(tags = "管理后台 - 营养成分")
@RestController
@RequestMapping("/sales/nutrition-facts")
@Validated
public class NutritionFactsController {

    @Resource
    private NutritionFactsService nutritionFactsService;

    @PostMapping("/create")
    @ApiOperation("创建营养成分")
    public CommonResult<String> createNutritionFacts(@Valid @RequestBody NutritionFactsCreateReqVO createReqVO) {
        return success(nutritionFactsService.createNutritionFacts(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新营养成分")
    public CommonResult<Boolean> updateNutritionFacts(@Valid @RequestBody NutritionFactsUpdateReqVO updateReqVO) {
        nutritionFactsService.updateNutritionFacts(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除营养成分")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:nutrition-facts:delete')")
    public CommonResult<Boolean> deleteNutritionFacts(@RequestParam("id") String id) {
        nutritionFactsService.deleteNutritionFacts(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得营养成分")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:nutrition-facts:query')")
    public CommonResult<NutritionFactsRespVO> getNutritionFacts(@RequestParam("id") String id) {
        NutritionFactsDO nutritionFacts = nutritionFactsService.getNutritionFacts(id);
        return success(NutritionFactsConvert.INSTANCE.convert(nutritionFacts));
    }

    @GetMapping("/list")
    @ApiOperation("获得营养成分列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:nutrition-facts:query')")
    public CommonResult<List<NutritionFactsRespVO>> getNutritionFactsList(@RequestParam("ids") Collection<String> ids) {
        List<NutritionFactsDO> list = nutritionFactsService.getNutritionFactsList(ids);
        return success(NutritionFactsConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得营养成分分页")
    public CommonResult<PageResult<NutritionFactsRespVO>> getNutritionFactsPage(@Valid NutritionFactsPageReqVO pageVO) {
        PageResult<NutritionFactsDO> pageResult = nutritionFactsService.getNutritionFactsPage(pageVO);
        return success(NutritionFactsConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出营养成分 Excel")
    @PreAuthorize("@ss.hasPermission('sales:nutrition-facts:export')")
    @OperateLog(type = EXPORT)
    public void exportNutritionFactsExcel(@Valid NutritionFactsExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<NutritionFactsDO> list = nutritionFactsService.getNutritionFactsList(exportReqVO);
        // 导出 Excel
        List<NutritionFactsExcelVO> datas = NutritionFactsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "营养成分.xls", "数据", NutritionFactsExcelVO.class, datas);
    }

}
