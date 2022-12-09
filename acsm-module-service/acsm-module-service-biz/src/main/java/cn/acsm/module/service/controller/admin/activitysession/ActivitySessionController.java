package cn.acsm.module.service.controller.admin.activitysession;

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

import cn.acsm.module.service.controller.admin.activitysession.vo.*;
import cn.acsm.module.service.dal.dataobject.activitysession.ActivitySessionDO;
import cn.acsm.module.service.convert.activitysession.ActivitySessionConvert;
import cn.acsm.module.service.service.activitysession.ActivitySessionService;

@Api(tags = "管理后台 - 时间排期")
@RestController
@RequestMapping("/service/activity-session")
@Validated
public class ActivitySessionController {

    @Resource
    private ActivitySessionService activitySessionService;

    @PostMapping("/create")
    @ApiOperation("创建时间排期")
    @PreAuthorize("@ss.hasPermission('service:activity-session:create')")
    public CommonResult<String> createActivitySession(@Valid @RequestBody ActivitySessionCreateReqVO createReqVO) {
        return success(activitySessionService.createActivitySession(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新时间排期")
    @PreAuthorize("@ss.hasPermission('service:activity-session:update')")
    public CommonResult<Boolean> updateActivitySession(@Valid @RequestBody ActivitySessionUpdateReqVO updateReqVO) {
        activitySessionService.updateActivitySession(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除时间排期")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:activity-session:delete')")
    public CommonResult<Boolean> deleteActivitySession(@RequestParam("id") Long id) {
        activitySessionService.deleteActivitySession(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得时间排期")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:activity-session:query')")
    public CommonResult<ActivitySessionRespVO> getActivitySession(@RequestParam("id") Long id) {
        ActivitySessionDO activitySession = activitySessionService.getActivitySession(id);
        return success(ActivitySessionConvert.INSTANCE.convert(activitySession));
    }

    @GetMapping("/list")
    @ApiOperation("获得时间排期列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('service:activity-session:query')")
    public CommonResult<List<ActivitySessionRespVO>> getActivitySessionList(@RequestParam("ids") Collection<Long> ids) {
        List<ActivitySessionDO> list = activitySessionService.getActivitySessionList(ids);
        return success(ActivitySessionConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得时间排期分页")
    @PreAuthorize("@ss.hasPermission('service:activity-session:query')")
    public CommonResult<PageResult<ActivitySessionRespVO>> getActivitySessionPage(@Valid ActivitySessionPageReqVO pageVO) {
        PageResult<ActivitySessionDO> pageResult = activitySessionService.getActivitySessionPage(pageVO);
        return success(ActivitySessionConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出时间排期 Excel")
    @PreAuthorize("@ss.hasPermission('service:activity-session:export')")
    @OperateLog(type = EXPORT)
    public void exportActivitySessionExcel(@Valid ActivitySessionExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ActivitySessionDO> list = activitySessionService.getActivitySessionList(exportReqVO);
        // 导出 Excel
        List<ActivitySessionExcelVO> datas = ActivitySessionConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "时间排期.xls", "数据", ActivitySessionExcelVO.class, datas);
    }

}
