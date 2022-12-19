package cn.acsm.module.production.devices.controller.admin.time;

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

import cn.acsm.module.production.devices.controller.admin.time.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.time.TimeDO;
import cn.acsm.module.production.devices.convert.time.TimeConvert;
import cn.acsm.module.production.devices.service.time.TimeService;

@Api(tags = "管理后台 - 设备运行时间")
@RestController
@RequestMapping("/devices/time")
@Validated
public class TimeController {

    @Resource
    private TimeService timeService;

    @PostMapping("/create")
    @ApiOperation("创建设备运行时间")
    @PreAuthorize("@ss.hasPermission('devices:time:create')")
    public CommonResult<Integer> createTime(@Valid @RequestBody TimeCreateReqVO createReqVO) {
        return success(timeService.createTime(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新设备运行时间")
    @PreAuthorize("@ss.hasPermission('devices:time:update')")
    public CommonResult<Boolean> updateTime(@Valid @RequestBody TimeUpdateReqVO updateReqVO) {
        timeService.updateTime(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除设备运行时间")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Integer.class)
    @PreAuthorize("@ss.hasPermission('devices:time:delete')")
    public CommonResult<Boolean> deleteTime(@RequestParam("id") Integer id) {
        timeService.deleteTime(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得设备运行时间")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Integer.class)
    @PreAuthorize("@ss.hasPermission('devices:time:query')")
    public CommonResult<TimeRespVO> getTime(@RequestParam("id") Integer id) {
        TimeDO time = timeService.getTime(id);
        return success(TimeConvert.INSTANCE.convert(time));
    }

    @GetMapping("/list")
    @ApiOperation("获得设备运行时间列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('devices:time:query')")
    public CommonResult<List<TimeRespVO>> getTimeList(@RequestParam("ids") Collection<Integer> ids) {
        List<TimeDO> list = timeService.getTimeList(ids);
        return success(TimeConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得设备运行时间分页")
    @PreAuthorize("@ss.hasPermission('devices:time:query')")
    public CommonResult<PageResult<TimeRespVO>> getTimePage(@Valid TimePageReqVO pageVO) {
        PageResult<TimeDO> pageResult = timeService.getTimePage(pageVO);
        return success(TimeConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出设备运行时间 Excel")
    @PreAuthorize("@ss.hasPermission('devices:time:export')")
    @OperateLog(type = EXPORT)
    public void exportTimeExcel(@Valid TimeExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<TimeDO> list = timeService.getTimeList(exportReqVO);
        // 导出 Excel
        List<TimeExcelVO> datas = TimeConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "设备运行时间.xls", "数据", TimeExcelVO.class, datas);
    }

}
