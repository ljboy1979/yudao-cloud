package cn.acsm.module.transaction.sales.controller.admin.rawmaterialclassify;

import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterialclassify.RawMaterialClassifyDO;
import cn.acsm.module.transaction.sales.service.rawmaterialclassify.RawMaterialClassifyService;
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

import cn.acsm.module.transaction.sales.controller.admin.rawmaterialclassify.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterialclassify.RawMaterialClassifyDO;
import cn.acsm.module.transaction.sales.convert.rawmaterialclassify.RawMaterialClassifyConvert;
import cn.acsm.module.transaction.sales.service.rawmaterialclassify.RawMaterialClassifyService;

@Api(tags = "管理后台 - 原料分类")
@RestController
@RequestMapping("/sales/raw-material-classify")
@Validated
public class RawMaterialClassifyController {

    @Resource
    private RawMaterialClassifyService rawMaterialClassifyService;

    @PostMapping("/create")
    @ApiOperation("创建原料分类")
    @PreAuthorize("@ss.hasPermission('sales:raw-material-classify:create')")
    public CommonResult<String> createRawMaterialClassify(@Valid @RequestBody RawMaterialClassifyCreateReqVO createReqVO) {
        return success(rawMaterialClassifyService.createRawMaterialClassify(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新原料分类")
    @PreAuthorize("@ss.hasPermission('sales:raw-material-classify:update')")
    public CommonResult<Boolean> updateRawMaterialClassify(@Valid @RequestBody RawMaterialClassifyUpdateReqVO updateReqVO) {
        rawMaterialClassifyService.updateRawMaterialClassify(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除原料分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:raw-material-classify:delete')")
    public CommonResult<Boolean> deleteRawMaterialClassify(@RequestParam("id") String id) {
        rawMaterialClassifyService.deleteRawMaterialClassify(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得原料分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:raw-material-classify:query')")
    public CommonResult<RawMaterialClassifyRespVO> getRawMaterialClassify(@RequestParam("id") String id) {
        RawMaterialClassifyDO rawMaterialClassify = rawMaterialClassifyService.getRawMaterialClassify(id);
        return success(RawMaterialClassifyConvert.INSTANCE.convert(rawMaterialClassify));
    }

    @GetMapping("/list")
    @ApiOperation("获得原料分类列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:raw-material-classify:query')")
    public CommonResult<List<RawMaterialClassifyRespVO>> getRawMaterialClassifyList(@RequestParam("ids") Collection<String> ids) {
        List<RawMaterialClassifyDO> list = rawMaterialClassifyService.getRawMaterialClassifyList(ids);
        return success(RawMaterialClassifyConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得原料分类分页")
    @PreAuthorize("@ss.hasPermission('sales:raw-material-classify:query')")
    public CommonResult<PageResult<RawMaterialClassifyRespVO>> getRawMaterialClassifyPage(@Valid RawMaterialClassifyPageReqVO pageVO) {
        PageResult<RawMaterialClassifyDO> pageResult = rawMaterialClassifyService.getRawMaterialClassifyPage(pageVO);
        return success(RawMaterialClassifyConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出原料分类 Excel")
    @PreAuthorize("@ss.hasPermission('sales:raw-material-classify:export')")
    @OperateLog(type = EXPORT)
    public void exportRawMaterialClassifyExcel(@Valid RawMaterialClassifyExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<RawMaterialClassifyDO> list = rawMaterialClassifyService.getRawMaterialClassifyList(exportReqVO);
        // 导出 Excel
        List<RawMaterialClassifyExcelVO> datas = RawMaterialClassifyConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "原料分类.xls", "数据", RawMaterialClassifyExcelVO.class, datas);
    }

}
