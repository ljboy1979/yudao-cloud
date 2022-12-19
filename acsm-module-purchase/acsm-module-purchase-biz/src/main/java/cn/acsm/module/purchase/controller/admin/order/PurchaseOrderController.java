package cn.acsm.module.purchase.controller.admin.order;

import cn.acsm.module.purchase.controller.admin.order.vo.*;
import cn.acsm.module.purchase.convert.order.PurchaseOrderConvert;
import cn.acsm.module.purchase.dal.dataobject.order.PurchaseOrderDO;
import cn.acsm.module.purchase.group.PurchaseOrderCreateVO;
import cn.acsm.module.purchase.service.order.PurchaseOrderService;
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

@Api(tags = "管理后台 - 采购单")
@RestController
@RequestMapping("/purchase/order")
@Validated
public class PurchaseOrderController {

    @Resource
    private PurchaseOrderService orderService;

    @PostMapping("/create")
    @ApiOperation("创建采购单")
    @PreAuthorize("@ss.hasPermission('purchase:order:create')")
    public CommonResult<String> createOrder(@Valid @Validated(PurchaseOrderCreateVO.class) @RequestBody PurchaseOrderCreateReqVO createReqVO) {
        return orderService.createOrder(createReqVO);
    }

    @PutMapping("/update")
    @ApiOperation("更新采购单")
    @PreAuthorize("@ss.hasPermission('purchase:order:update')")
    public CommonResult<Boolean> updateOrder(@Valid @RequestBody PurchaseOrderUpdateReqVO updateReqVO) {
        orderService.updateOrder(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除采购单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:order:delete')")
    public CommonResult<Boolean> deleteOrder(@Valid @RequestBody PurchaseOrderDelReqVO purchaseOrderDelReqVO) {
        orderService.deleteOrder(purchaseOrderDelReqVO);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得采购单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:order:query')")
    public CommonResult<PurchaseOrderRespVO> getOrder(@RequestParam("id") Long id) {
        PurchaseOrderDO order = orderService.getOrder(id);
        return success(PurchaseOrderConvert.INSTANCE.convert(order));
    }

    @GetMapping("/list")
    @ApiOperation("获得采购单列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('purchase:order:query')")
    public CommonResult<List<PurchaseOrderRespVO>> getOrderList(@RequestParam("ids") Collection<Long> ids) {
        List<PurchaseOrderDO> list = orderService.getOrderList(ids);
        return success(PurchaseOrderConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("查询采购合同单")
    @PreAuthorize("@ss.hasPermission('purchase:order:query')")
    public CommonResult<PageResult<PurchaseOrderRespVO>> getOrderPage(@Valid PurchaseOrderPageReqVO pageVO) {
        PageResult<PurchaseOrderDO> pageResult = orderService.getOrderPage(pageVO);
        return success(PurchaseOrderConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出采购单 Excel")
    @PreAuthorize("@ss.hasPermission('purchase:order:export')")
    @OperateLog(type = EXPORT)
    public void exportOrderExcel(@Valid PurchaseOrderExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PurchaseOrderDO> list = orderService.getOrderList(exportReqVO);
        // 导出 Excel
        List<PurchaseOrderExcelVO> datas = PurchaseOrderConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "采购单.xls", "数据", PurchaseOrderExcelVO.class, datas);
    }

    @PutMapping("/update/status")
    @ApiOperation("变更采购状态")
    @PreAuthorize("@ss.hasPermission('purchase:order:update:status')")
    public CommonResult<Boolean> updateOrderStatus(@Valid @RequestBody PurchaseOrderUpdateStatusReqVO updateReqVO) {
        orderService.updateOrderStatus(updateReqVO);
        return success(true);
    }

}
