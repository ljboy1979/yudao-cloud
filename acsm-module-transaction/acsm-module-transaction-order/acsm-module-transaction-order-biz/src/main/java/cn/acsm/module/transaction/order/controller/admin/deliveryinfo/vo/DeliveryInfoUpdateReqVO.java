package cn.acsm.module.transaction.order.controller.admin.deliveryinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 配送更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DeliveryInfoUpdateReqVO extends DeliveryInfoBaseVO {

    @ApiModelProperty(value = "ID", required = true)
    @NotNull(message = "ID不能为空")
    private String id;

}
