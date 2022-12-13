package cn.acsm.module.transaction.order.controller.admin.orderdetail;

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

import cn.acsm.module.transaction.order.controller.admin.orderdetail.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.orderdetail.OrderDetailDO;
import cn.acsm.module.transaction.order.convert.orderdetail.OrderDetailConvert;
import cn.acsm.module.transaction.order.service.orderdetail.OrderDetailService;

@Api(tags = "管理后台 - 订单详情")
@RestController
@RequestMapping("/order/detail")
@Validated
public class OrderDetailController {

    @Resource
    private OrderDetailService detailService;

    @PostMapping("/create")
    @ApiOperation("创建订单详情")
    @PreAuthorize("@ss.hasPermission('order:detail:create')")
    public CommonResult<String> createDetail(@Valid @RequestBody OrderDetailCreateReqVO createReqVO) {
        return success(detailService.createDetail(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新订单详情")
    @PreAuthorize("@ss.hasPermission('order:detail:update')")
    public CommonResult<Boolean> updateDetail(@Valid @RequestBody OrderDetailUpdateReqVO updateReqVO) {
        detailService.updateDetail(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除订单详情")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:detail:delete')")
    public CommonResult<Boolean> deleteDetail(@RequestParam("id") String id) {
        detailService.deleteDetail(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得订单详情")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:detail:query')")
    public CommonResult<OrderDetailRespVO> getDetail(@RequestParam("id") String id) {
        OrderDetailDO detail = detailService.getDetail(id);
        return success(OrderDetailConvert.INSTANCE.convert(detail));
    }

    @GetMapping("/list")
    @ApiOperation("获得订单详情列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('order:detail:query')")
    public CommonResult<List<OrderDetailRespVO>> getDetailList(@RequestParam("ids") Collection<String> ids) {
        List<OrderDetailDO> list = detailService.getDetailList(ids);
        return success(OrderDetailConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得订单详情分页")
    @PreAuthorize("@ss.hasPermission('order:detail:query')")
    public CommonResult<PageResult<OrderDetailRespVO>> getDetailPage(@Valid OrderDetailPageReqVO pageVO) {
        PageResult<OrderDetailDO> pageResult = detailService.getDetailPage(pageVO);
        return success(OrderDetailConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出订单详情 Excel")
    @PreAuthorize("@ss.hasPermission('order:detail:export')")
    @OperateLog(type = EXPORT)
    public void exportDetailExcel(@Valid OrderDetailExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<OrderDetailDO> list = detailService.getDetailList(exportReqVO);
        // 导出 Excel
        List<OrderDetailExcelVO> datas = OrderDetailConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "订单详情.xls", "数据", OrderDetailExcelVO.class, datas);
    }

}
