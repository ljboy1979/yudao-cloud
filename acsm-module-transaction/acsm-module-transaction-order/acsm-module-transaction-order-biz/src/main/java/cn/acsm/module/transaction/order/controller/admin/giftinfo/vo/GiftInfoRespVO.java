package cn.acsm.module.transaction.order.controller.admin.giftinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 赠品 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GiftInfoRespVO extends GiftInfoBaseVO {

    @ApiModelProperty(value = "赠品id", required = true)
    private Integer id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
