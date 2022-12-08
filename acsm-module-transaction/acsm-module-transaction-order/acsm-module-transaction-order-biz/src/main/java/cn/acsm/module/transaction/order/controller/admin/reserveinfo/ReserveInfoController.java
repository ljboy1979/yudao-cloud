package cn.acsm.module.transaction.order.controller.admin.reserveinfo;

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

import cn.acsm.module.transaction.order.controller.admin.reserveinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.reserveinfo.ReserveInfoDO;
import cn.acsm.module.transaction.order.convert.reserveinfo.ReserveInfoConvert;
import cn.acsm.module.transaction.order.service.reserveinfo.ReserveInfoService;

@Api(tags = "管理后台 - 预定订单")
@RestController
@RequestMapping("/order/reserve-info")
@Validated
public class ReserveInfoController {

    @Resource
    private ReserveInfoService reserveInfoService;

    @PostMapping("/create")
    @ApiOperation("创建预定订单")
    @PreAuthorize("@ss.hasPermission('order:reserve-info:create')")
    public CommonResult<String> createReserveInfo(@Valid @RequestBody ReserveInfoCreateReqVO createReqVO) {
        return success(reserveInfoService.createReserveInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新预定订单")
    @PreAuthorize("@ss.hasPermission('order:reserve-info:update')")
    public CommonResult<Boolean> updateReserveInfo(@Valid @RequestBody ReserveInfoUpdateReqVO updateReqVO) {
        reserveInfoService.updateReserveInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除预定订单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:reserve-info:delete')")
    public CommonResult<Boolean> deleteReserveInfo(@RequestParam("id") String id) {
        reserveInfoService.deleteReserveInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得预定订单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:reserve-info:query')")
    public CommonResult<ReserveInfoRespVO> getReserveInfo(@RequestParam("id") String id) {
        ReserveInfoDO reserveInfo = reserveInfoService.getReserveInfo(id);
        return success(ReserveInfoConvert.INSTANCE.convert(reserveInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得预定订单列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('order:reserve-info:query')")
    public CommonResult<List<ReserveInfoRespVO>> getReserveInfoList(@RequestParam("ids") Collection<String> ids) {
        List<ReserveInfoDO> list = reserveInfoService.getReserveInfoList(ids);
        return success(ReserveInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得预定订单分页")
    @PreAuthorize("@ss.hasPermission('order:reserve-info:query')")
    public CommonResult<PageResult<ReserveInfoRespVO>> getReserveInfoPage(@Valid ReserveInfoPageReqVO pageVO) {
        PageResult<ReserveInfoDO> pageResult = reserveInfoService.getReserveInfoPage(pageVO);
        return success(ReserveInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出预定订单 Excel")
    @PreAuthorize("@ss.hasPermission('order:reserve-info:export')")
    @OperateLog(type = EXPORT)
    public void exportReserveInfoExcel(@Valid ReserveInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ReserveInfoDO> list = reserveInfoService.getReserveInfoList(exportReqVO);
        // 导出 Excel
        List<ReserveInfoExcelVO> datas = ReserveInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "预定订单.xls", "数据", ReserveInfoExcelVO.class, datas);
    }

}
