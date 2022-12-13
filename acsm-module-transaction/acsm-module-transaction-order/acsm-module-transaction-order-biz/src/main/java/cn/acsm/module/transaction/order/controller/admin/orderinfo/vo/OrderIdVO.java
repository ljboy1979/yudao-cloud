package cn.acsm.module.transaction.order.controller.admin.orderinfo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderIdVO {
    @ApiModelProperty(value = "id", required = true)
    @NotNull(message = "id不能为空")
    private String id;
}
