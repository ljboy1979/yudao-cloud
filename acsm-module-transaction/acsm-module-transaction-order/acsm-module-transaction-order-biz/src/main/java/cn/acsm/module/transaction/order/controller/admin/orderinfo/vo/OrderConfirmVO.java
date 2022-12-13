package cn.acsm.module.transaction.order.controller.admin.orderinfo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class OrderConfirmVO extends OrderIdVO{

    @ApiModelProperty(value = "预计发货时间")
    @NotNull(message = "预计发货时间不能为空")
    private Date estimatedDeliveryTime;
}
