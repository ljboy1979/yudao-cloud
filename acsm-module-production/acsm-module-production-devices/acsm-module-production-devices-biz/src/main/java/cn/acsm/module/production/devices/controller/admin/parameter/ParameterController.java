package cn.acsm.module.production.devices.controller.admin.parameter;

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

import cn.acsm.module.production.devices.controller.admin.parameter.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.parameter.ParameterDO;
import cn.acsm.module.production.devices.convert.parameter.ParameterConvert;
import cn.acsm.module.production.devices.service.parameter.ParameterService;

@Api(tags = "管理后台 - 设备表参数")
@RestController
@RequestMapping("/devices/parameter")
@Validated
public class ParameterController {

    @Resource
    private ParameterService parameterService;

    @PostMapping("/create")
    @ApiOperation("创建设备表参数")
    @PreAuthorize("@ss.hasPermission('devices:parameter:create')")
    public CommonResult<Long> createParameter(@Valid @RequestBody ParameterCreateReqVO createReqVO) {
        return success(parameterService.createParameter(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新设备表参数")
    @PreAuthorize("@ss.hasPermission('devices:parameter:update')")
    public CommonResult<Boolean> updateParameter(@Valid @RequestBody ParameterUpdateReqVO updateReqVO) {
        parameterService.updateParameter(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除设备表参数")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:parameter:delete')")
    public CommonResult<Boolean> deleteParameter(@RequestParam("id") Long id) {
        parameterService.deleteParameter(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得设备表参数")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:parameter:query')")
    public CommonResult<ParameterRespVO> getParameter(@RequestParam("id") Long id) {
        ParameterDO parameter = parameterService.getParameter(id);
        return success(ParameterConvert.INSTANCE.convert(parameter));
    }

    @GetMapping("/list")
    @ApiOperation("获得设备表参数列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('devices:parameter:query')")
    public CommonResult<List<ParameterRespVO>> getParameterList(@RequestParam("ids") Collection<Long> ids) {
        List<ParameterDO> list = parameterService.getParameterList(ids);
        return success(ParameterConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得设备表参数分页")
    @PreAuthorize("@ss.hasPermission('devices:parameter:query')")
    public CommonResult<PageResult<ParameterRespVO>> getParameterPage(@Valid ParameterPageReqVO pageVO) {
        PageResult<ParameterDO> pageResult = parameterService.getParameterPage(pageVO);
        return success(ParameterConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出设备表参数 Excel")
    @PreAuthorize("@ss.hasPermission('devices:parameter:export')")
    @OperateLog(type = EXPORT)
    public void exportParameterExcel(@Valid ParameterExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ParameterDO> list = parameterService.getParameterList(exportReqVO);
        // 导出 Excel
        List<ParameterExcelVO> datas = ParameterConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "设备表参数.xls", "数据", ParameterExcelVO.class, datas);
    }

}
