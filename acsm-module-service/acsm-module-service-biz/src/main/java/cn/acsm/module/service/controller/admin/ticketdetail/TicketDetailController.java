package cn.acsm.module.service.controller.admin.ticketdetail;

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

import cn.acsm.module.service.controller.admin.ticketdetail.vo.*;
import cn.acsm.module.service.dal.dataobject.ticketdetail.TicketDetailDO;
import cn.acsm.module.service.convert.ticketdetail.TicketDetailConvert;
import cn.acsm.module.service.service.ticketdetail.TicketDetailService;

@Api(tags = "管理后台 - 套票详情")
@RestController
@RequestMapping("/service/ticket-detail")
@Validated
public class TicketDetailController {

    @Resource
    private TicketDetailService ticketDetailService;

    @PostMapping("/create")
    @ApiOperation("创建套票详情")
    @PreAuthorize("@ss.hasPermission('service:ticket-detail:create')")
    public CommonResult<Long> createTicketDetail(@Valid @RequestBody TicketDetailCreateReqVO createReqVO) {
        return success(ticketDetailService.createTicketDetail(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新套票详情")
    @PreAuthorize("@ss.hasPermission('service:ticket-detail:update')")
    public CommonResult<Boolean> updateTicketDetail(@Valid @RequestBody TicketDetailUpdateReqVO updateReqVO) {
        ticketDetailService.updateTicketDetail(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除套票详情")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:ticket-detail:delete')")
    public CommonResult<Boolean> deleteTicketDetail(@RequestParam("id") Long id) {
        ticketDetailService.deleteTicketDetail(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得套票详情")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:ticket-detail:query')")
    public CommonResult<TicketDetailRespVO> getTicketDetail(@RequestParam("id") Long id) {
        TicketDetailDO ticketDetail = ticketDetailService.getTicketDetail(id);
        return success(TicketDetailConvert.INSTANCE.convert(ticketDetail));
    }

    @GetMapping("/list")
    @ApiOperation("获得套票详情列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('service:ticket-detail:query')")
    public CommonResult<List<TicketDetailRespVO>> getTicketDetailList(@RequestParam("ids") Collection<Long> ids) {
        List<TicketDetailDO> list = ticketDetailService.getTicketDetailList(ids);
        return success(TicketDetailConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得套票详情分页")
    @PreAuthorize("@ss.hasPermission('service:ticket-detail:query')")
    public CommonResult<PageResult<TicketDetailRespVO>> getTicketDetailPage(@Valid TicketDetailPageReqVO pageVO) {
        PageResult<TicketDetailDO> pageResult = ticketDetailService.getTicketDetailPage(pageVO);
        return success(TicketDetailConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出套票详情 Excel")
    @PreAuthorize("@ss.hasPermission('service:ticket-detail:export')")
    @OperateLog(type = EXPORT)
    public void exportTicketDetailExcel(@Valid TicketDetailExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<TicketDetailDO> list = ticketDetailService.getTicketDetailList(exportReqVO);
        // 导出 Excel
        List<TicketDetailExcelVO> datas = TicketDetailConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "套票详情.xls", "数据", TicketDetailExcelVO.class, datas);
    }

}
