package cn.acsm.module.service.controller.admin.ticketpackage;

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

import cn.acsm.module.service.controller.admin.ticketpackage.vo.*;
import cn.acsm.module.service.dal.dataobject.ticketpackage.TicketPackageDO;
import cn.acsm.module.service.convert.ticketpackage.TicketPackageConvert;
import cn.acsm.module.service.service.ticketpackage.TicketPackageService;

@Api(tags = "管理后台 - 套票")
@RestController
@RequestMapping("/service/ticket-package")
@Validated
public class TicketPackageController {

    @Resource
    private TicketPackageService ticketPackageService;

    @PostMapping("/create")
    @ApiOperation("创建套票")
    @PreAuthorize("@ss.hasPermission('service:ticket-package:create')")
    public CommonResult<Long> createTicketPackage(@Valid @RequestBody TicketPackageCreateReqVO createReqVO) {
        return success(ticketPackageService.createTicketPackage(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新套票")
    @PreAuthorize("@ss.hasPermission('service:ticket-package:update')")
    public CommonResult<Boolean> updateTicketPackage(@Valid @RequestBody TicketPackageUpdateReqVO updateReqVO) {
        ticketPackageService.updateTicketPackage(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除套票")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:ticket-package:delete')")
    public CommonResult<Boolean> deleteTicketPackage(@RequestParam("id") Long id) {
        ticketPackageService.deleteTicketPackage(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得套票")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:ticket-package:query')")
    public CommonResult<TicketPackageRespVO> getTicketPackage(@RequestParam("id") Long id) {
        TicketPackageDO ticketPackage = ticketPackageService.getTicketPackage(id);
        return success(TicketPackageConvert.INSTANCE.convert(ticketPackage));
    }

    @GetMapping("/list")
    @ApiOperation("获得套票列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('service:ticket-package:query')")
    public CommonResult<List<TicketPackageRespVO>> getTicketPackageList(@RequestParam("ids") Collection<Long> ids) {
        List<TicketPackageDO> list = ticketPackageService.getTicketPackageList(ids);
        return success(TicketPackageConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得套票分页")
    @PreAuthorize("@ss.hasPermission('service:ticket-package:query')")
    public CommonResult<PageResult<TicketPackageRespVO>> getTicketPackagePage(@Valid TicketPackagePageReqVO pageVO) {
        PageResult<TicketPackageRespVO> pageResult = ticketPackageService.getTicketPackagePage(pageVO);
        //PageResult<TicketPackageRespVO> ticketPackageRespVOPageResult = TicketPackageConvert.INSTANCE.convertPage(pageResult);
        return success(pageResult);
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出套票 Excel")
    @PreAuthorize("@ss.hasPermission('service:ticket-package:export')")
    @OperateLog(type = EXPORT)
    public void exportTicketPackageExcel(@Valid TicketPackageExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<TicketPackageDO> list = ticketPackageService.getTicketPackageList(exportReqVO);
        // 导出 Excel
        List<TicketPackageExcelVO> datas = TicketPackageConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "套票.xls", "数据", TicketPackageExcelVO.class, datas);
    }

    @PostMapping("/createTicketPackageService")
    @ApiOperation("创建套票关联服务")
    public CommonResult<String> createTicketPackageService(@Valid @RequestBody TicketPackageUpdateReqVO createReqVO) {
        return success(ticketPackageService.createTicketPackageService(createReqVO));
    }

    @PostMapping("/deleteTicketPackageService")
    @ApiOperation("删除套票关联服务")
    public CommonResult<String> deleteTicketPackageService(@Valid @RequestBody TicketPackageUpdateReqVO reqVO) {
        return success(ticketPackageService.deleteTicketPackageService(reqVO));
    }

}
