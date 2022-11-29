package cn.acsm.module.transaction.sales.controller.admin.commoditycategory.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 商品分类更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommodityCategoryUpdateReqVO extends CommodityCategoryBaseVO {

    @ApiModelProperty(value = "商品分类id", required = true)
    @NotNull(message = "商品分类id不能为空")
    private String id;

}
