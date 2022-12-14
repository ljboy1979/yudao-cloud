package cn.acsm.module.transaction.order.controller.admin.orderinfo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CancelOrderVO  extends OrderIdVO{

    @ApiModelProperty(value = "取消原因")
    @NotNull(message = "取消原因不能为空")
    private String cause;
}
