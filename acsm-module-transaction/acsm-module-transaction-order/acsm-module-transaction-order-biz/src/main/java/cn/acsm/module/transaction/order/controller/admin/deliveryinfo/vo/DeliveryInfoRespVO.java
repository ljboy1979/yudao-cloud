package cn.acsm.module.transaction.order.controller.admin.deliveryinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 配送 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DeliveryInfoRespVO extends DeliveryInfoBaseVO {

    @ApiModelProperty(value = "ID", required = true)
    private String id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
