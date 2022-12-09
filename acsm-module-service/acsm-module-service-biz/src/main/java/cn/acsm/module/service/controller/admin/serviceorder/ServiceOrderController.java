package cn.acsm.module.service.controller.admin.serviceorder;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.acsm.module.service.controller.admin.serviceorder.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceorder.ServiceOrderDO;
import cn.acsm.module.service.convert.serviceorder.ServiceOrderConvert;
import cn.acsm.module.service.service.serviceorder.ServiceOrderService;

@Api(tags = "管理后台 - 服务交易单")
@RestController
@RequestMapping("/service/order")
@Validated
public class ServiceOrderController {

    @Resource
    private ServiceOrderService orderService;

    @PostMapping("/create")
    @ApiOperation("创建服务交易单")
    @PreAuthorize("@ss.hasPermission('service:order:create')")
    public CommonResult<Long> createOrder(@Valid @RequestBody ServiceOrderCreateReqVO createReqVO) {
        return success(orderService.createOrder(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新服务交易单")
    @PreAuthorize("@ss.hasPermission('service:order:update')")
    public CommonResult<Boolean> updateOrder(@Valid @RequestBody ServiceOrderUpdateReqVO updateReqVO) {
        orderService.updateOrder(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除服务交易单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:order:delete')")
    public CommonResult<Boolean> deleteOrder(@RequestParam("id") Long id) {
        orderService.deleteOrder(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得服务交易单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:order:query')")
    public CommonResult<ServiceOrderRespVO> getOrder(@RequestParam("id") Long id) {
        ServiceOrderDO order = orderService.getOrder(id);
        return success(ServiceOrderConvert.INSTANCE.convert(order));
    }

    @GetMapping("/list")
    @ApiOperation("获得服务交易单列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('service:order:query')")
    public CommonResult<List<ServiceOrderRespVO>> getOrderList(@RequestParam("ids") Collection<Long> ids) {
        List<ServiceOrderDO> list = orderService.getOrderList(ids);
        return success(ServiceOrderConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得服务交易单分页")
    @PreAuthorize("@ss.hasPermission('service:order:query')")
    public CommonResult<PageResult<ServiceOrderRespVO>> getOrderPage(@Valid ServiceOrderPageReqVO pageVO) {
        PageResult<ServiceOrderDO> pageResult = orderService.getOrderPage(pageVO);
        return success(ServiceOrderConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出服务交易单 Excel")
    @PreAuthorize("@ss.hasPermission('service:order:export')")
    @OperateLog(type = EXPORT)
    public void exportOrderExcel(@Valid ServiceOrderExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ServiceOrderDO> list = orderService.getOrderList(exportReqVO);
        // 导出 Excel
        List<ServiceOrderExcelVO> datas = ServiceOrderConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "服务交易单.xls", "数据", ServiceOrderExcelVO.class, datas);
    }

}
