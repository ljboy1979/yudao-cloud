package cn.iocoder.yudao.module.transaction.sales.controller.admin.commoditysku.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 商品sku Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommoditySkuRespVO extends CommoditySkuBaseVO {

    @ApiModelProperty(value = "sku_id", required = true)
    private String id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
