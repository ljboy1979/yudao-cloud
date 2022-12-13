package cn.acsm.module.transaction.order.controller.admin.orderinfo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DeliverGoodsVO  extends OrderIdVO{
;
    @ApiModelProperty(value = "物流单号")
    @NotNull(message = "物流单号不能为空")
    private String ogisticsTicketNumber;

    @ApiModelProperty(value = "物流公司")
    @NotNull(message = "物流单号不能为空")
    private String logisticsCompanies;
}
