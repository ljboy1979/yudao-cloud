package cn.iocoder.yudao.module.transaction.sales.controller.admin.commodity.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 商品 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommodityRespVO extends CommodityBaseVO {

    @ApiModelProperty(value = "商品id", required = true)
    private String id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
