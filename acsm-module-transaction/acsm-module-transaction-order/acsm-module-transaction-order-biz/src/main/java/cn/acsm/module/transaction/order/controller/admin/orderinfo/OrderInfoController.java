package cn.acsm.module.transaction.order.controller.admin.orderinfo;

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

import cn.acsm.module.transaction.order.controller.admin.orderinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.orderinfo.OrderInfoDO;
import cn.acsm.module.transaction.order.convert.orderinfo.OrderInfoConvert;
import cn.acsm.module.transaction.order.service.orderinfo.OrderInfoService;

@Api(tags = "管理后台 - 订单")
@RestController
@RequestMapping("/order/info")
@Validated
public class OrderInfoController {

    @Resource
    private OrderInfoService infoService;

    @PostMapping("/create")
    @ApiOperation("创建订单")
    @PreAuthorize("@ss.hasPermission('order:info:create')")
    public CommonResult<String> createInfo(@Valid @RequestBody OrderInfoCreateReqVO createReqVO) {
        return success(infoService.createInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新订单")
    @PreAuthorize("@ss.hasPermission('order:info:update')")
    public CommonResult<Boolean> updateInfo(@Valid @RequestBody OrderInfoUpdateReqVO updateReqVO) {
        infoService.updateInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除订单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:info:delete')")
    public CommonResult<Boolean> deleteInfo(@RequestParam("id") String id) {
        infoService.deleteInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得订单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:info:query')")
    public CommonResult<OrderInfoRespVO> getInfo(@RequestParam("id") String id) {
        OrderInfoDO info = infoService.getInfo(id);
        return success(OrderInfoConvert.INSTANCE.convert(info));
    }

    @GetMapping("/list")
    @ApiOperation("获得订单列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('order:info:query')")
    public CommonResult<List<OrderInfoRespVO>> getInfoList(@RequestParam("ids") Collection<String> ids) {
        List<OrderInfoDO> list = infoService.getInfoList(ids);
        return success(OrderInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得订单分页")
    @PreAuthorize("@ss.hasPermission('order:info:query')")
    public CommonResult<PageResult<OrderInfoRespVO>> getInfoPage(@Valid OrderInfoPageReqVO pageVO) {
        PageResult<OrderInfoDO> pageResult = infoService.getInfoPage(pageVO);
        return success(OrderInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出订单 Excel")
    @PreAuthorize("@ss.hasPermission('order:info:export')")
    @OperateLog(type = EXPORT)
    public void exportInfoExcel(@Valid OrderInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<OrderInfoDO> list = infoService.getInfoList(exportReqVO);
        // 导出 Excel
        List<OrderInfoExcelVO> datas = OrderInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "订单.xls", "数据", OrderInfoExcelVO.class, datas);
    }

}
