package cn.acsm.module.transaction.order.controller.admin.orderinfo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ModifyPriceVO extends OrderIdVO {
    @ApiModelProperty(value = "优惠金额")
    private BigDecimal preferentialPrice;
}
