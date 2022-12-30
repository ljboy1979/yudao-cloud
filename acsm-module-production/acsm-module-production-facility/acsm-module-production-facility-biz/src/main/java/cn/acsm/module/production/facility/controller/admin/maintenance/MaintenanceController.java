package cn.acsm.module.production.facility.controller.admin.maintenance;

import cn.acsm.module.production.facility.controller.admin.maintenance.vo.*;
import cn.acsm.module.production.facility.convert.maintenance.MaintenanceConvert;
import cn.acsm.module.production.facility.dal.dataobject.maintenance.MaintenanceDO;
import cn.acsm.module.production.facility.service.maintenance.MaintenanceService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;


@Api(tags = "管理后台 - 设施维护记录")
@RestController
@RequestMapping("/facility/maintenance")
@Validated
public class MaintenanceController {

    @Resource
    private MaintenanceService maintenanceService;

    @PostMapping("/create")
    @ApiOperation("创建设施维护记录")
    @PreAuthorize("@ss.hasPermission('facility:maintenance:create')")
    public CommonResult<Long> createMaintenance(@Valid @RequestBody MaintenanceCreateReqVO createReqVO) {
        return success(maintenanceService.createMaintenance(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新设施维护记录")
    @PreAuthorize("@ss.hasPermission('facility:maintenance:update')")
    public CommonResult<Boolean> updateMaintenance(@Valid @RequestBody MaintenanceUpdateReqVO updateReqVO) {
        maintenanceService.updateMaintenance(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除设施维护记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('facility:maintenance:delete')")
    public CommonResult<Boolean> deleteMaintenance(@RequestParam("id") Long id) {
        maintenanceService.deleteMaintenance(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得设施维护记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('facility:maintenance:query')")
    public CommonResult<MaintenanceRespVO> getMaintenance(@RequestParam("id") Long id) {
        MaintenanceDO maintenance = maintenanceService.getMaintenance(id);
        return success(MaintenanceConvert.INSTANCE.convert(maintenance));
    }

    @GetMapping("/list")
    @ApiOperation("获得设施维护记录列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('facility:maintenance:query')")
    public CommonResult<List<MaintenanceRespVO>> getMaintenanceList(@RequestParam("ids") Collection<Long> ids) {
        List<MaintenanceDO> list = maintenanceService.getMaintenanceList(ids);
        return success(MaintenanceConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得设施维护记录分页")
    @PreAuthorize("@ss.hasPermission('facility:maintenance:query')")
    public CommonResult<PageResult<MaintenanceRespVO>> getMaintenancePage(@Valid MaintenancePageReqVO pageVO) {
        PageResult<MaintenanceDO> pageResult = maintenanceService.getMaintenancePage(pageVO);
        return success(MaintenanceConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出设施维护记录 Excel")
    @PreAuthorize("@ss.hasPermission('facility:maintenance:export')")
    @OperateLog(type = EXPORT)
    public void exportMaintenanceExcel(@Valid MaintenanceExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MaintenanceDO> list = maintenanceService.getMaintenanceList(exportReqVO);
        // 导出 Excel
        List<MaintenanceExcelVO> datas = MaintenanceConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "设施维护记录.xls", "数据", MaintenanceExcelVO.class, datas);
    }

}
