package cn.acsm.module.transaction.order.controller.admin.giftinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 赠品更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GiftInfoUpdateReqVO extends GiftInfoBaseVO {

    @ApiModelProperty(value = "赠品id", required = true)
    @NotNull(message = "赠品id不能为空")
    private Integer id;

}
