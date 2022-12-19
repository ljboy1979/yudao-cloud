package cn.acsm.module.production.devices.controller.admin.alarminfo;

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

import cn.acsm.module.production.devices.controller.admin.alarminfo.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.alarminfo.AlarmInfoDO;
import cn.acsm.module.production.devices.convert.alarminfo.AlarmInfoConvert;
import cn.acsm.module.production.devices.service.alarminfo.AlarmInfoService;

@Api(tags = "管理后台 - 告警信息")
@RestController
@RequestMapping("/devices/alarm-info")
@Validated
public class AlarmInfoController {

    @Resource
    private AlarmInfoService alarmInfoService;

    @PostMapping("/create")
    @ApiOperation("创建告警信息")
    @PreAuthorize("@ss.hasPermission('devices:alarm-info:create')")
    public CommonResult<Long> createAlarmInfo(@Valid @RequestBody AlarmInfoCreateReqVO createReqVO) {
        return success(alarmInfoService.createAlarmInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新告警信息")
    @PreAuthorize("@ss.hasPermission('devices:alarm-info:update')")
    public CommonResult<Boolean> updateAlarmInfo(@Valid @RequestBody AlarmInfoUpdateReqVO updateReqVO) {
        alarmInfoService.updateAlarmInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除告警信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:alarm-info:delete')")
    public CommonResult<Boolean> deleteAlarmInfo(@RequestParam("id") Long id) {
        alarmInfoService.deleteAlarmInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得告警信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:alarm-info:query')")
    public CommonResult<AlarmInfoRespVO> getAlarmInfo(@RequestParam("id") Long id) {
        AlarmInfoDO alarmInfo = alarmInfoService.getAlarmInfo(id);
        return success(AlarmInfoConvert.INSTANCE.convert(alarmInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得告警信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('devices:alarm-info:query')")
    public CommonResult<List<AlarmInfoRespVO>> getAlarmInfoList(@RequestParam("ids") Collection<Long> ids) {
        List<AlarmInfoDO> list = alarmInfoService.getAlarmInfoList(ids);
        return success(AlarmInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得告警信息分页")
    @PreAuthorize("@ss.hasPermission('devices:alarm-info:query')")
    public CommonResult<PageResult<AlarmInfoRespVO>> getAlarmInfoPage(@Valid AlarmInfoPageReqVO pageVO) {
        PageResult<AlarmInfoDO> pageResult = alarmInfoService.getAlarmInfoPage(pageVO);
        return success(AlarmInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出告警信息 Excel")
    @PreAuthorize("@ss.hasPermission('devices:alarm-info:export')")
    @OperateLog(type = EXPORT)
    public void exportAlarmInfoExcel(@Valid AlarmInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<AlarmInfoDO> list = alarmInfoService.getAlarmInfoList(exportReqVO);
        // 导出 Excel
        List<AlarmInfoExcelVO> datas = AlarmInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "告警信息.xls", "数据", AlarmInfoExcelVO.class, datas);
    }

}
