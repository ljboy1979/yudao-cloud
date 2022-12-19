package cn.acsm.module.production.devices.controller.admin.paramscfg;

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

import cn.acsm.module.production.devices.controller.admin.paramscfg.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.paramscfg.ParamsCfgDO;
import cn.acsm.module.production.devices.convert.paramscfg.ParamsCfgConvert;
import cn.acsm.module.production.devices.service.paramscfg.ParamsCfgService;

@Api(tags = "管理后台 - 设备参数配置")
@RestController
@RequestMapping("/devices/params-cfg")
@Validated
public class ParamsCfgController {

    @Resource
    private ParamsCfgService paramsCfgService;

    @PostMapping("/create")
    @ApiOperation("创建设备参数配置")
    @PreAuthorize("@ss.hasPermission('devices:params-cfg:create')")
    public CommonResult<Long> createParamsCfg(@Valid @RequestBody ParamsCfgCreateReqVO createReqVO) {
        return success(paramsCfgService.createParamsCfg(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新设备参数配置")
    @PreAuthorize("@ss.hasPermission('devices:params-cfg:update')")
    public CommonResult<Boolean> updateParamsCfg(@Valid @RequestBody ParamsCfgUpdateReqVO updateReqVO) {
        paramsCfgService.updateParamsCfg(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除设备参数配置")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:params-cfg:delete')")
    public CommonResult<Boolean> deleteParamsCfg(@RequestParam("id") Long id) {
        paramsCfgService.deleteParamsCfg(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得设备参数配置")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:params-cfg:query')")
    public CommonResult<ParamsCfgRespVO> getParamsCfg(@RequestParam("id") Long id) {
        ParamsCfgDO paramsCfg = paramsCfgService.getParamsCfg(id);
        return success(ParamsCfgConvert.INSTANCE.convert(paramsCfg));
    }

    @GetMapping("/list")
    @ApiOperation("获得设备参数配置列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('devices:params-cfg:query')")
    public CommonResult<List<ParamsCfgRespVO>> getParamsCfgList(@RequestParam("ids") Collection<Long> ids) {
        List<ParamsCfgDO> list = paramsCfgService.getParamsCfgList(ids);
        return success(ParamsCfgConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得设备参数配置分页")
    @PreAuthorize("@ss.hasPermission('devices:params-cfg:query')")
    public CommonResult<PageResult<ParamsCfgRespVO>> getParamsCfgPage(@Valid ParamsCfgPageReqVO pageVO) {
        PageResult<ParamsCfgDO> pageResult = paramsCfgService.getParamsCfgPage(pageVO);
        return success(ParamsCfgConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出设备参数配置 Excel")
    @PreAuthorize("@ss.hasPermission('devices:params-cfg:export')")
    @OperateLog(type = EXPORT)
    public void exportParamsCfgExcel(@Valid ParamsCfgExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ParamsCfgDO> list = paramsCfgService.getParamsCfgList(exportReqVO);
        // 导出 Excel
        List<ParamsCfgExcelVO> datas = ParamsCfgConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "设备参数配置.xls", "数据", ParamsCfgExcelVO.class, datas);
    }

}
