package cn.acsm.module.production.devices.controller.admin.alarmrule;

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

import cn.acsm.module.production.devices.controller.admin.alarmrule.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.alarmrule.AlarmRuleDO;
import cn.acsm.module.production.devices.convert.alarmrule.AlarmRuleConvert;
import cn.acsm.module.production.devices.service.alarmrule.AlarmRuleService;

@Api(tags = "管理后台 - 告警规则")
@RestController
@RequestMapping("/devices/alarm-rule")
@Validated
public class AlarmRuleController {

    @Resource
    private AlarmRuleService alarmRuleService;

    @PostMapping("/create")
    @ApiOperation("创建告警规则")
    @PreAuthorize("@ss.hasPermission('devices:alarm-rule:create')")
    public CommonResult<Long> createAlarmRule(@Valid @RequestBody AlarmRuleCreateReqVO createReqVO) {
        return success(alarmRuleService.createAlarmRule(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新告警规则")
    @PreAuthorize("@ss.hasPermission('devices:alarm-rule:update')")
    public CommonResult<Boolean> updateAlarmRule(@Valid @RequestBody AlarmRuleUpdateReqVO updateReqVO) {
        alarmRuleService.updateAlarmRule(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除告警规则")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:alarm-rule:delete')")
    public CommonResult<Boolean> deleteAlarmRule(@RequestParam("id") Long id) {
        alarmRuleService.deleteAlarmRule(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得告警规则")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:alarm-rule:query')")
    public CommonResult<AlarmRuleRespVO> getAlarmRule(@RequestParam("id") Long id) {
        AlarmRuleDO alarmRule = alarmRuleService.getAlarmRule(id);
        return success(AlarmRuleConvert.INSTANCE.convert(alarmRule));
    }

    @GetMapping("/list")
    @ApiOperation("获得告警规则列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('devices:alarm-rule:query')")
    public CommonResult<List<AlarmRuleRespVO>> getAlarmRuleList(@RequestParam("ids") Collection<Long> ids) {
        List<AlarmRuleDO> list = alarmRuleService.getAlarmRuleList(ids);
        return success(AlarmRuleConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得告警规则分页")
    @PreAuthorize("@ss.hasPermission('devices:alarm-rule:query')")
    public CommonResult<PageResult<AlarmRuleRespVO>> getAlarmRulePage(@Valid AlarmRulePageReqVO pageVO) {
        PageResult<AlarmRuleDO> pageResult = alarmRuleService.getAlarmRulePage(pageVO);
        return success(AlarmRuleConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出告警规则 Excel")
    @PreAuthorize("@ss.hasPermission('devices:alarm-rule:export')")
    @OperateLog(type = EXPORT)
    public void exportAlarmRuleExcel(@Valid AlarmRuleExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<AlarmRuleDO> list = alarmRuleService.getAlarmRuleList(exportReqVO);
        // 导出 Excel
        List<AlarmRuleExcelVO> datas = AlarmRuleConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "告警规则.xls", "数据", AlarmRuleExcelVO.class, datas);
    }

}
