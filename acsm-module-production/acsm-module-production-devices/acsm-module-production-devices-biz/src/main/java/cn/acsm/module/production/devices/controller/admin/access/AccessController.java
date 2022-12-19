package cn.acsm.module.production.devices.controller.admin.access;

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

import cn.acsm.module.production.devices.controller.admin.access.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.access.AccessDO;
import cn.acsm.module.production.devices.convert.access.AccessConvert;
import cn.acsm.module.production.devices.service.access.AccessService;

@Api(tags = "管理后台 - 设备允许访问名单信息")
@RestController
@RequestMapping("/devices/access")
@Validated
public class AccessController {

    @Resource
    private AccessService accessService;

    @PostMapping("/create")
    @ApiOperation("创建设备允许访问名单信息")
    @PreAuthorize("@ss.hasPermission('devices:access:create')")
    public CommonResult<Long> createAccess(@Valid @RequestBody AccessCreateReqVO createReqVO) {
        return success(accessService.createAccess(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新设备允许访问名单信息")
    @PreAuthorize("@ss.hasPermission('devices:access:update')")
    public CommonResult<Boolean> updateAccess(@Valid @RequestBody AccessUpdateReqVO updateReqVO) {
        accessService.updateAccess(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除设备允许访问名单信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:access:delete')")
    public CommonResult<Boolean> deleteAccess(@RequestParam("id") Long id) {
        accessService.deleteAccess(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得设备允许访问名单信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('devices:access:query')")
    public CommonResult<AccessRespVO> getAccess(@RequestParam("id") Long id) {
        AccessDO access = accessService.getAccess(id);
        return success(AccessConvert.INSTANCE.convert(access));
    }

    @GetMapping("/list")
    @ApiOperation("获得设备允许访问名单信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('devices:access:query')")
    public CommonResult<List<AccessRespVO>> getAccessList(@RequestParam("ids") Collection<Long> ids) {
        List<AccessDO> list = accessService.getAccessList(ids);
        return success(AccessConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得设备允许访问名单信息分页")
    @PreAuthorize("@ss.hasPermission('devices:access:query')")
    public CommonResult<PageResult<AccessRespVO>> getAccessPage(@Valid AccessPageReqVO pageVO) {
        PageResult<AccessDO> pageResult = accessService.getAccessPage(pageVO);
        return success(AccessConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出设备允许访问名单信息 Excel")
    @PreAuthorize("@ss.hasPermission('devices:access:export')")
    @OperateLog(type = EXPORT)
    public void exportAccessExcel(@Valid AccessExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<AccessDO> list = accessService.getAccessList(exportReqVO);
        // 导出 Excel
        List<AccessExcelVO> datas = AccessConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "设备允许访问名单信息.xls", "数据", AccessExcelVO.class, datas);
    }

}
