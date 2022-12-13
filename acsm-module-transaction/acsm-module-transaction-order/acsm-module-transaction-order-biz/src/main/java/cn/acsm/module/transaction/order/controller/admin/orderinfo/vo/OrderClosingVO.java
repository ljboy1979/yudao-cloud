package cn.acsm.module.transaction.order.controller.admin.orderinfo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderClosingVO {

    @ApiModelProperty(value = "订单id")
    private String orderIds;

    @ApiModelProperty(value = "结账金额")
    private BigDecimal settlePrice;

    @ApiModelProperty(value = "实付金额")
    private BigDecimal actualPrice;

    @ApiModelProperty(value = "支付方式 0 对公转账  ")
    private String payType;
}
