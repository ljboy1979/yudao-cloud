package cn.acsm.module.transaction.pricetag.controller.admin.marketclassify.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 市场分类 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MarketClassifyRespVO extends MarketClassifyBaseVO {

    @ApiModelProperty(value = "id", required = true)
    private String id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
