package cn.acsm.module.transaction.sales.controller.admin.rawmaterialspecification;

import cn.acsm.module.transaction.sales.controller.admin.rawmaterialspecification.vo.*;
import cn.acsm.module.transaction.sales.convert.rawmaterialspecification.RawMaterialSpecificationConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterialspecification.RawMaterialSpecificationDO;
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

import cn.acsm.module.transaction.sales.controller.admin.rawmaterialspecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterialspecification.RawMaterialSpecificationDO;
import cn.acsm.module.transaction.sales.convert.rawmaterialspecification.RawMaterialSpecificationConvert;
import cn.acsm.module.transaction.sales.service.rawmaterialspecification.RawMaterialSpecificationService;

@Api(tags = "管理后台 - 原料规格")
@RestController
@RequestMapping("/sales/raw-material-specification")
@Validated
public class RawMaterialSpecificationController {

    @Resource
    private RawMaterialSpecificationService rawMaterialSpecificationService;

    @PostMapping("/create")
    @ApiOperation("创建原料规格")
    @PreAuthorize("@ss.hasPermission('sales:raw-material-specification:create')")
    public CommonResult<String> createRawMaterialSpecification(@Valid @RequestBody RawMaterialSpecificationCreateReqVO createReqVO) {
        return success(rawMaterialSpecificationService.createRawMaterialSpecification(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新原料规格")
    @PreAuthorize("@ss.hasPermission('sales:raw-material-specification:update')")
    public CommonResult<Boolean> updateRawMaterialSpecification(@Valid @RequestBody RawMaterialSpecificationUpdateReqVO updateReqVO) {
        rawMaterialSpecificationService.updateRawMaterialSpecification(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除原料规格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:raw-material-specification:delete')")
    public CommonResult<Boolean> deleteRawMaterialSpecification(@RequestParam("id") String id) {
        rawMaterialSpecificationService.deleteRawMaterialSpecification(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得原料规格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('sales:raw-material-specification:query')")
    public CommonResult<RawMaterialSpecificationRespVO> getRawMaterialSpecification(@RequestParam("id") String id) {
        RawMaterialSpecificationDO rawMaterialSpecification = rawMaterialSpecificationService.getRawMaterialSpecification(id);
        return success(RawMaterialSpecificationConvert.INSTANCE.convert(rawMaterialSpecification));
    }

    @GetMapping("/list")
    @ApiOperation("获得原料规格列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('sales:raw-material-specification:query')")
    public CommonResult<List<RawMaterialSpecificationRespVO>> getRawMaterialSpecificationList(@RequestParam("ids") Collection<String> ids) {
        List<RawMaterialSpecificationDO> list = rawMaterialSpecificationService.getRawMaterialSpecificationList(ids);
        return success(RawMaterialSpecificationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得原料规格分页")
    @PreAuthorize("@ss.hasPermission('sales:raw-material-specification:query')")
    public CommonResult<PageResult<RawMaterialSpecificationRespVO>> getRawMaterialSpecificationPage(@Valid RawMaterialSpecificationPageReqVO pageVO) {
        PageResult<RawMaterialSpecificationDO> pageResult = rawMaterialSpecificationService.getRawMaterialSpecificationPage(pageVO);
        return success(RawMaterialSpecificationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出原料规格 Excel")
    @PreAuthorize("@ss.hasPermission('sales:raw-material-specification:export')")
    @OperateLog(type = EXPORT)
    public void exportRawMaterialSpecificationExcel(@Valid RawMaterialSpecificationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<RawMaterialSpecificationDO> list = rawMaterialSpecificationService.getRawMaterialSpecificationList(exportReqVO);
        // 导出 Excel
        List<RawMaterialSpecificationExcelVO> datas = RawMaterialSpecificationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "原料规格.xls", "数据", RawMaterialSpecificationExcelVO.class, datas);
    }

}
