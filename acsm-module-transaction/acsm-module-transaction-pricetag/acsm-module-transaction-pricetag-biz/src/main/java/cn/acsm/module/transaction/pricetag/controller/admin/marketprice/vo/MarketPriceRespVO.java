package cn.acsm.module.transaction.pricetag.controller.admin.marketprice.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 市场价格 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MarketPriceRespVO extends MarketPriceBaseVO {

    @ApiModelProperty(value = "id", required = true)
    private String id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
