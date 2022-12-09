package cn.acsm.module.resource.controller.admin.maintenancerecord;

import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.*;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

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

import cn.acsm.module.resource.dal.dataobject.maintenancerecord.MaintenanceRecordDO;
import cn.acsm.module.resource.convert.maintenancerecord.MaintenanceRecordConvert;
import cn.acsm.module.resource.service.maintenancerecord.MaintenanceRecordService;

@Api(tags = "管理后台 - 服务资源-养护记录")
@RestController
@RequestMapping("/resource/maintenance-record")
@Validated
public class MaintenanceRecordController {

    @Resource
    private MaintenanceRecordService maintenanceRecordService;

    @PostMapping("/create")
    @ApiOperation("创建服务资源-养护记录")
    @PreAuthorize("@ss.hasPermission('service:maintenance-record:create')")
    public CommonResult<Long> createMaintenanceRecord(@Valid @RequestBody MaintenanceRecordCreateReqVO createReqVO) {
        return success(maintenanceRecordService.createMaintenanceRecord(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新服务资源-养护记录")
    @PreAuthorize("@ss.hasPermission('service:maintenance-record:update')")
    public CommonResult<Boolean> updateMaintenanceRecord(@Valid @RequestBody MaintenanceRecordUpdateReqVO updateReqVO) {
        maintenanceRecordService.updateMaintenanceRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除服务资源-养护记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:maintenance-record:delete')")
    public CommonResult<Boolean> deleteMaintenanceRecord(@RequestParam("id") Long id) {
        maintenanceRecordService.deleteMaintenanceRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得服务资源-养护记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:maintenance-record:query')")
    public CommonResult<MaintenanceRecordRespVO> getMaintenanceRecord(@RequestParam("id") Long id) {
        MaintenanceRecordDO maintenanceRecord = maintenanceRecordService.getMaintenanceRecord(id);
        return success(MaintenanceRecordConvert.INSTANCE.convert(maintenanceRecord));
    }

    @GetMapping("/list")
    @ApiOperation("获得服务资源-养护记录列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('service:maintenance-record:query')")
    public CommonResult<List<MaintenanceRecordRespVO>> getMaintenanceRecordList(@RequestParam("ids") Collection<Long> ids) {
        List<MaintenanceRecordDO> list = maintenanceRecordService.getMaintenanceRecordList(ids);
        return success(MaintenanceRecordConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得服务资源-养护记录分页")
    @PreAuthorize("@ss.hasPermission('service:maintenance-record:query')")
    public CommonResult<PageResult<MaintenanceRecordRespVO>> getMaintenanceRecordPage(@Valid MaintenanceRecordPageReqVO pageVO) {
        PageResult<MaintenanceRecordDO> pageResult = maintenanceRecordService.getMaintenanceRecordPage(pageVO);
        return success(MaintenanceRecordConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出服务资源-养护记录 Excel")
    @PreAuthorize("@ss.hasPermission('service:maintenance-record:export')")
    @OperateLog(type = EXPORT)
    public void exportMaintenanceRecordExcel(@Valid MaintenanceRecordExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MaintenanceRecordDO> list = maintenanceRecordService.getMaintenanceRecordList(exportReqVO);
        // 导出 Excel
        List<MaintenanceRecordExcelVO> datas = MaintenanceRecordConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "服务资源-养护记录.xls", "数据", MaintenanceRecordExcelVO.class, datas);
    }

}
