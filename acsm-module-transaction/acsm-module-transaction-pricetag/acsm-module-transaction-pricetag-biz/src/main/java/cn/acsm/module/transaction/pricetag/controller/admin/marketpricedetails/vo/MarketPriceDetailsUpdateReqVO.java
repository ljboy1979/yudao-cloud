package cn.acsm.module.transaction.pricetag.controller.admin.marketpricedetails.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 市场价格明细更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MarketPriceDetailsUpdateReqVO extends MarketPriceDetailsBaseVO {

    @ApiModelProperty(value = "id", required = true)
    @NotNull(message = "id不能为空")
    private String id;

}
