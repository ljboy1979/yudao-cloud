package cn.iocoder.yudao.module.transaction.sales.controller.admin.commoditysku.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 商品sku更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommoditySkuUpdateReqVO extends CommoditySkuBaseVO {

    @ApiModelProperty(value = "sku_id", required = true)
    @NotNull(message = "sku_id不能为空")
    private String id;

}
