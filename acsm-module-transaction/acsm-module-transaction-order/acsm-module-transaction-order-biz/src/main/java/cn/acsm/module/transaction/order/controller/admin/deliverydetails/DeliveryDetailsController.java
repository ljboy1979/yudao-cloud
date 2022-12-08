package cn.acsm.module.transaction.order.controller.admin.deliverydetails;

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

import cn.acsm.module.transaction.order.controller.admin.deliverydetails.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.deliverydetails.DeliveryDetailsDO;
import cn.acsm.module.transaction.order.convert.deliverydetails.DeliveryDetailsConvert;
import cn.acsm.module.transaction.order.service.deliverydetails.DeliveryDetailsService;

@Api(tags = "管理后台 - 配送详情")
@RestController
@RequestMapping("/order/delivery-details")
@Validated
public class DeliveryDetailsController {

    @Resource
    private DeliveryDetailsService deliveryDetailsService;

    @PostMapping("/create")
    @ApiOperation("创建配送详情")
    @PreAuthorize("@ss.hasPermission('order:delivery-details:create')")
    public CommonResult<String> createDeliveryDetails(@Valid @RequestBody DeliveryDetailsCreateReqVO createReqVO) {
        return success(deliveryDetailsService.createDeliveryDetails(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新配送详情")
    @PreAuthorize("@ss.hasPermission('order:delivery-details:update')")
    public CommonResult<Boolean> updateDeliveryDetails(@Valid @RequestBody DeliveryDetailsUpdateReqVO updateReqVO) {
        deliveryDetailsService.updateDeliveryDetails(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除配送详情")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:delivery-details:delete')")
    public CommonResult<Boolean> deleteDeliveryDetails(@RequestParam("id") String id) {
        deliveryDetailsService.deleteDeliveryDetails(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得配送详情")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:delivery-details:query')")
    public CommonResult<DeliveryDetailsRespVO> getDeliveryDetails(@RequestParam("id") String id) {
        DeliveryDetailsDO deliveryDetails = deliveryDetailsService.getDeliveryDetails(id);
        return success(DeliveryDetailsConvert.INSTANCE.convert(deliveryDetails));
    }

    @GetMapping("/list")
    @ApiOperation("获得配送详情列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('order:delivery-details:query')")
    public CommonResult<List<DeliveryDetailsRespVO>> getDeliveryDetailsList(@RequestParam("ids") Collection<String> ids) {
        List<DeliveryDetailsDO> list = deliveryDetailsService.getDeliveryDetailsList(ids);
        return success(DeliveryDetailsConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得配送详情分页")
    @PreAuthorize("@ss.hasPermission('order:delivery-details:query')")
    public CommonResult<PageResult<DeliveryDetailsRespVO>> getDeliveryDetailsPage(@Valid DeliveryDetailsPageReqVO pageVO) {
        PageResult<DeliveryDetailsDO> pageResult = deliveryDetailsService.getDeliveryDetailsPage(pageVO);
        return success(DeliveryDetailsConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出配送详情 Excel")
    @PreAuthorize("@ss.hasPermission('order:delivery-details:export')")
    @OperateLog(type = EXPORT)
    public void exportDeliveryDetailsExcel(@Valid DeliveryDetailsExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<DeliveryDetailsDO> list = deliveryDetailsService.getDeliveryDetailsList(exportReqVO);
        // 导出 Excel
        List<DeliveryDetailsExcelVO> datas = DeliveryDetailsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "配送详情.xls", "数据", DeliveryDetailsExcelVO.class, datas);
    }

}
