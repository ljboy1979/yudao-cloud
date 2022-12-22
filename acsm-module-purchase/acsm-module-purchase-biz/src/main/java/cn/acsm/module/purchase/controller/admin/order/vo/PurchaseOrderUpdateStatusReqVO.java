package cn.acsm.module.purchase.controller.admin.order.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <pre>
 * 对象功能: PurchaseOrderUpdateStatusReqVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/19
 * <pre>
 */
@Data
public class PurchaseOrderUpdateStatusReqVO implements Serializable {

    @ApiModelProperty(value = "采购单明细id")
    private Long id;

    @ApiModelProperty(value = "采购单号")
    private String purchaseNumber;

    @ApiModelProperty(value = "单价")
    private BigDecimal price;

    @ApiModelProperty(value = "优惠金额")
    private BigDecimal discount;

    @ApiModelProperty(value = "采购金额(总金额)")
    private BigDecimal total;

    @ApiModelProperty(value = "付款方式")
    private Integer payWay;

    @ApiModelProperty(value = "采购状态")
    private Integer purchaseStatus;

}
