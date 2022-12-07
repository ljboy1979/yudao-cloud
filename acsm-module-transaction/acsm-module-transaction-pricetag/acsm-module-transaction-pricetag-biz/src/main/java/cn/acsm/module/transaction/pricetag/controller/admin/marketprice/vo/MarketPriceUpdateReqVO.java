package cn.acsm.module.transaction.pricetag.controller.admin.marketprice.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 市场价格更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MarketPriceUpdateReqVO extends MarketPriceBaseVO {

    @ApiModelProperty(value = "id", required = true)
    @NotNull(message = "id不能为空")
    private String id;

}
