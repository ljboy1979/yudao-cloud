package cn.acsm.module.production.devices.controller.admin.alarmnotifier;

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

import cn.acsm.module.production.devices.controller.admin.alarmnotifier.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.alarmnotifier.AlarmNotifierDO;
import cn.acsm.module.production.devices.convert.alarmnotifier.AlarmNotifierConvert;
import cn.acsm.module.production.devices.service.alarmnotifier.AlarmNotifierService;

@Api(tags = "管理后台 - 告警通知规则")
@RestController
@RequestMapping("/devices/alarm-notifier")
@Validated
public class AlarmNotifierController {

    @Resource
    private AlarmNotifierService alarmNotifierService;

    @PostMapping("/create")
    @ApiOperation("创建告警通知规则")
    @PreAuthorize("@ss.hasPermission('devices:alarm-notifier:create')")
    public CommonResult<Long> createAlarmNotifier(@Valid @RequestBody AlarmNotifierCreateReqVO createReqVO) {
        return success(alarmNotifierService.createAlarmNotifier(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新告警通知规则")
    @PreAuthorize("@ss.hasPermission('devices:alarm-notifier:update')")
    public CommonResult<Boolean> updateAlarmNotifier(@Valid @RequestBody AlarmNotifierUpdateReqVO updateReqVO) {
        alarmNotifierService.updateAlarmNotifier(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除告警通知规则")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:alarm-notifier:delete')")
    public CommonResult<Boolean> deleteAlarmNotifier(@RequestParam("id") Long id) {
        alarmNotifierService.deleteAlarmNotifier(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得告警通知规则")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:alarm-notifier:query')")
    public CommonResult<AlarmNotifierRespVO> getAlarmNotifier(@RequestParam("id") Long id) {
        AlarmNotifierDO alarmNotifier = alarmNotifierService.getAlarmNotifier(id);
        return success(AlarmNotifierConvert.INSTANCE.convert(alarmNotifier));
    }

    @GetMapping("/list")
    @ApiOperation("获得告警通知规则列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('devices:alarm-notifier:query')")
    public CommonResult<List<AlarmNotifierRespVO>> getAlarmNotifierList(@RequestParam("ids") Collection<Long> ids) {
        List<AlarmNotifierDO> list = alarmNotifierService.getAlarmNotifierList(ids);
        return success(AlarmNotifierConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得告警通知规则分页")
    @PreAuthorize("@ss.hasPermission('devices:alarm-notifier:query')")
    public CommonResult<PageResult<AlarmNotifierRespVO>> getAlarmNotifierPage(@Valid AlarmNotifierPageReqVO pageVO) {
        PageResult<AlarmNotifierDO> pageResult = alarmNotifierService.getAlarmNotifierPage(pageVO);
        return success(AlarmNotifierConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出告警通知规则 Excel")
    @PreAuthorize("@ss.hasPermission('devices:alarm-notifier:export')")
    @OperateLog(type = EXPORT)
    public void exportAlarmNotifierExcel(@Valid AlarmNotifierExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<AlarmNotifierDO> list = alarmNotifierService.getAlarmNotifierList(exportReqVO);
        // 导出 Excel
        List<AlarmNotifierExcelVO> datas = AlarmNotifierConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "告警通知规则.xls", "数据", AlarmNotifierExcelVO.class, datas);
    }

}
