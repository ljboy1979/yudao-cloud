package cn.acsm.module.transaction.pricetag.controller.admin.marketcommodity.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 市场商品 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MarketCommodityRespVO extends MarketCommodityBaseVO {

    @ApiModelProperty(value = "id", required = true)
    private String id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
