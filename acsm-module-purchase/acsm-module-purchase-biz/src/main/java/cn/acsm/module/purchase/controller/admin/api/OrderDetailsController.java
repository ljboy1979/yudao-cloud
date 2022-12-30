package cn.acsm.module.purchase.controller.admin.api;

import cn.acsm.module.purchase.api.orderdetails.vo.OrderDetailsApiVO;
import cn.acsm.module.purchase.service.details.PurchaseDetailsService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * <pre>
 * 对象功能: OrderDetailsController.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/29
 * <pre>
 */
@Api(tags = "管理后台 - 采购交付")
@RestController
@RequestMapping("/purchase/deliver")
@Validated
public class OrderDetailsController {

    @Resource
    private PurchaseDetailsService detailsService;

    @GetMapping("/get/order")
    @ApiOperation("查询采购单")
    @PreAuthorize("@ss.hasPermission('purchase:deliver:orders')")
    public CommonResult<List<OrderDetailsApiVO>> getOrderDetails() {
        return success(detailsService.getDetailsList());
    }

}
