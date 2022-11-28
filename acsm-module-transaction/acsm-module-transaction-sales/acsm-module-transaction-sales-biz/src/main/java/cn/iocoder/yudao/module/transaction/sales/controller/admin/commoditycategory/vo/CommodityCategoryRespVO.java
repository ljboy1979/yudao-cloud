package cn.iocoder.yudao.module.transaction.sales.controller.admin.commoditycategory.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 商品分类 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommodityCategoryRespVO extends CommodityCategoryBaseVO {

    @ApiModelProperty(value = "商品分类id", required = true)
    private String id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
