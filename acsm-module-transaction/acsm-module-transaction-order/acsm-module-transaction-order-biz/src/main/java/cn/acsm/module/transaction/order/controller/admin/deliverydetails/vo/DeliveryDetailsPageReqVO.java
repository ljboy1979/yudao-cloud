package cn.acsm.module.transaction.order.controller.admin.deliverydetails.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@ApiModel("管理后台 - 配送详情分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DeliveryDetailsPageReqVO extends PageParam {

    @ApiModelProperty(value = "配送id")
    private String deliveryId;

    @ApiModelProperty(value = "名称")
    private String name;

}
