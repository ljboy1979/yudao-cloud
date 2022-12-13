package cn.acsm.module.transaction.order.controller.admin.orderinfo.vo;

import cn.acsm.module.transaction.order.controller.admin.orderdetail.vo.OrderDetailCreateReqVO;
import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 订单创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OrderInfoCreateReqVO extends OrderInfoBaseVO {

    @ApiModelProperty(value = "订单详情")
    @NotNull(message = "订单详情不能为空")
    private List<OrderDetailCreateReqVO> orderDetailCreateReqVOS;
}
