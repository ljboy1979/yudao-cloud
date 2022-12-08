package cn.acsm.module.transaction.order.controller.admin.reservedetails;

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

import cn.acsm.module.transaction.order.controller.admin.reservedetails.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.reservedetails.ReserveDetailsDO;
import cn.acsm.module.transaction.order.convert.reservedetails.ReserveDetailsConvert;
import cn.acsm.module.transaction.order.service.reservedetails.ReserveDetailsService;

@Api(tags = "管理后台 - 订单预定详情")
@RestController
@RequestMapping("/order/reserve-details")
@Validated
public class ReserveDetailsController {

    @Resource
    private ReserveDetailsService reserveDetailsService;

    @PostMapping("/create")
    @ApiOperation("创建订单预定详情")
    @PreAuthorize("@ss.hasPermission('order:reserve-details:create')")
    public CommonResult<String> createReserveDetails(@Valid @RequestBody ReserveDetailsCreateReqVO createReqVO) {
        return success(reserveDetailsService.createReserveDetails(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新订单预定详情")
    @PreAuthorize("@ss.hasPermission('order:reserve-details:update')")
    public CommonResult<Boolean> updateReserveDetails(@Valid @RequestBody ReserveDetailsUpdateReqVO updateReqVO) {
        reserveDetailsService.updateReserveDetails(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除订单预定详情")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:reserve-details:delete')")
    public CommonResult<Boolean> deleteReserveDetails(@RequestParam("id") String id) {
        reserveDetailsService.deleteReserveDetails(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得订单预定详情")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:reserve-details:query')")
    public CommonResult<ReserveDetailsRespVO> getReserveDetails(@RequestParam("id") String id) {
        ReserveDetailsDO reserveDetails = reserveDetailsService.getReserveDetails(id);
        return success(ReserveDetailsConvert.INSTANCE.convert(reserveDetails));
    }

    @GetMapping("/list")
    @ApiOperation("获得订单预定详情列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('order:reserve-details:query')")
    public CommonResult<List<ReserveDetailsRespVO>> getReserveDetailsList(@RequestParam("ids") Collection<String> ids) {
        List<ReserveDetailsDO> list = reserveDetailsService.getReserveDetailsList(ids);
        return success(ReserveDetailsConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得订单预定详情分页")
    @PreAuthorize("@ss.hasPermission('order:reserve-details:query')")
    public CommonResult<PageResult<ReserveDetailsRespVO>> getReserveDetailsPage(@Valid ReserveDetailsPageReqVO pageVO) {
        PageResult<ReserveDetailsDO> pageResult = reserveDetailsService.getReserveDetailsPage(pageVO);
        return success(ReserveDetailsConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出订单预定详情 Excel")
    @PreAuthorize("@ss.hasPermission('order:reserve-details:export')")
    @OperateLog(type = EXPORT)
    public void exportReserveDetailsExcel(@Valid ReserveDetailsExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ReserveDetailsDO> list = reserveDetailsService.getReserveDetailsList(exportReqVO);
        // 导出 Excel
        List<ReserveDetailsExcelVO> datas = ReserveDetailsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "订单预定详情.xls", "数据", ReserveDetailsExcelVO.class, datas);
    }

}
