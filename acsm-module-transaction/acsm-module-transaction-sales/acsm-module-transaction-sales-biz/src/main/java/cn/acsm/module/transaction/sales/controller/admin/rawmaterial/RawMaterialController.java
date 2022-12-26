package cn.acsm.module.transaction.sales.controller.admin.rawmaterial;

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

import cn.acsm.module.transaction.sales.controller.admin.rawmaterial.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterial.RawMaterialDO;
import cn.acsm.module.transaction.sales.convert.rawmaterial.RawMaterialConvert;
import cn.acsm.module.transaction.sales.service.rawmaterial.RawMaterialService;

@Api(tags = "管理后台 - 原料")
@RestController
@RequestMapping("/sales/raw-material")
@Validated
public class RawMaterialController {

    @Resource
    private RawMaterialService rawMaterialService;

    @PostMapping("/create")
    @ApiOperation("创建原料")
    @PreAuthorize("@ss.hasPermission('sales:raw-material:create')")
    public CommonResult<String> createRawMaterial(@Valid @RequestBody RawMaterialCreateReqVO createReqVO) {
        return rawMaterialService.createRawMaterial(createReqVO);
    }

    @PutMapping("/update")
    @ApiOperation("更新原料")
    @PreAuthorize("@ss.hasPermission('sales:raw-material:update')")
    public  CommonResult<String>  updateRawMaterial(@Valid @RequestBody RawMaterialUpdateReqVO updateReqVO) {
        return rawMaterialService.updateRawMaterial(updateReqVO);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除原料")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:raw-material:delete')")
    public CommonResult<Boolean> deleteRawMaterial(@RequestParam("id") String id) {
        rawMaterialService.deleteRawMaterial(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得原料")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:raw-material:query')")
    public CommonResult<RawMaterialRespVO> getRawMaterial(@RequestParam("id") String id) {
        RawMaterialDO rawMaterial = rawMaterialService.getRawMaterial(id);
        return success(RawMaterialConvert.INSTANCE.convert(rawMaterial));
    }

    @GetMapping("/list")
    @ApiOperation("获得原料列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:raw-material:query')")
    public CommonResult<List<RawMaterialRespVO>> getRawMaterialList(@RequestParam("ids") Collection<String> ids) {
        List<RawMaterialDO> list = rawMaterialService.getRawMaterialList(ids);
        return success(RawMaterialConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得原料分页")
    @PreAuthorize("@ss.hasPermission('sales:raw-material:query')")
    public CommonResult<PageResult<RawMaterialRespVO>> getRawMaterialPage(@Valid RawMaterialPageReqVO pageVO) {
        PageResult<RawMaterialDO> pageResult = rawMaterialService.getRawMaterialPage(pageVO);
        return success(RawMaterialConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出原料 Excel")
    @PreAuthorize("@ss.hasPermission('sales:raw-material:export')")
    @OperateLog(type = EXPORT)
    public void exportRawMaterialExcel(@Valid RawMaterialExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<RawMaterialDO> list = rawMaterialService.getRawMaterialList(exportReqVO);
        // 导出 Excel
        List<RawMaterialExcelVO> datas = RawMaterialConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "原料.xls", "数据", RawMaterialExcelVO.class, datas);
    }

    @GetMapping("/findList")
    @ApiOperation("获得原料列表")
    @PreAuthorize("@ss.hasPermission('sales:raw-material:query')")
    public CommonResult<List<RawMaterialRespVO>> findList(@RequestBody RawMaterialReqVO rawMaterialReqVO) {
        List<RawMaterialDO> list = rawMaterialService.findList(rawMaterialReqVO);
        return success(RawMaterialConvert.INSTANCE.convertList(list));
    }

}
