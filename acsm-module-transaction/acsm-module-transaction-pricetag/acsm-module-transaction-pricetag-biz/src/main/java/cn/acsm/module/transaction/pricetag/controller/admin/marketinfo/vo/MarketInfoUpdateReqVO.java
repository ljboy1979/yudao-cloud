package cn.acsm.module.transaction.pricetag.controller.admin.marketinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 市场信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MarketInfoUpdateReqVO extends MarketInfoBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    @NotNull(message = "编号不能为空")
    private String id;

}
