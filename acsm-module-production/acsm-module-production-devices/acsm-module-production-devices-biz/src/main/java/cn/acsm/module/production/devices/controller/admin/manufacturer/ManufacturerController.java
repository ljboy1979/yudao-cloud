package cn.acsm.module.production.devices.controller.admin.manufacturer;

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

import cn.acsm.module.production.devices.controller.admin.manufacturer.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.manufacturer.ManufacturerDO;
import cn.acsm.module.production.devices.convert.manufacturer.ManufacturerConvert;
import cn.acsm.module.production.devices.service.manufacturer.ManufacturerService;

@Api(tags = "管理后台 - 设备厂家")
@RestController
@RequestMapping("/devices/manufacturer")
@Validated
public class ManufacturerController {

    @Resource
    private ManufacturerService manufacturerService;

    @PostMapping("/create")
    @ApiOperation("创建设备厂家")
    @PreAuthorize("@ss.hasPermission('devices:manufacturer:create')")
    public CommonResult<Long> createManufacturer(@Valid @RequestBody ManufacturerCreateReqVO createReqVO) {
        return success(manufacturerService.createManufacturer(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新设备厂家")
    @PreAuthorize("@ss.hasPermission('devices:manufacturer:update')")
    public CommonResult<Boolean> updateManufacturer(@Valid @RequestBody ManufacturerUpdateReqVO updateReqVO) {
        manufacturerService.updateManufacturer(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除设备厂家")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:manufacturer:delete')")
    public CommonResult<Boolean> deleteManufacturer(@RequestParam("id") Long id) {
        manufacturerService.deleteManufacturer(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得设备厂家")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:manufacturer:query')")
    public CommonResult<ManufacturerRespVO> getManufacturer(@RequestParam("id") Long id) {
        ManufacturerDO manufacturer = manufacturerService.getManufacturer(id);
        return success(ManufacturerConvert.INSTANCE.convert(manufacturer));
    }

    @GetMapping("/list")
    @ApiOperation("获得设备厂家列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('devices:manufacturer:query')")
    public CommonResult<List<ManufacturerRespVO>> getManufacturerList(@RequestParam("ids") Collection<Long> ids) {
        List<ManufacturerDO> list = manufacturerService.getManufacturerList(ids);
        return success(ManufacturerConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得设备厂家分页")
    @PreAuthorize("@ss.hasPermission('devices:manufacturer:query')")
    public CommonResult<PageResult<ManufacturerRespVO>> getManufacturerPage(@Valid ManufacturerPageReqVO pageVO) {
        PageResult<ManufacturerDO> pageResult = manufacturerService.getManufacturerPage(pageVO);
        return success(ManufacturerConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出设备厂家 Excel")
    @PreAuthorize("@ss.hasPermission('devices:manufacturer:export')")
    @OperateLog(type = EXPORT)
    public void exportManufacturerExcel(@Valid ManufacturerExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ManufacturerDO> list = manufacturerService.getManufacturerList(exportReqVO);
        // 导出 Excel
        List<ManufacturerExcelVO> datas = ManufacturerConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "设备厂家.xls", "数据", ManufacturerExcelVO.class, datas);
    }

}
