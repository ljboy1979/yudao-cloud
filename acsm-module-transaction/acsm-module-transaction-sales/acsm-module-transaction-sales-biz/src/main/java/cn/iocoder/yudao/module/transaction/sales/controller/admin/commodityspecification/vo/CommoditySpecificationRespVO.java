package cn.iocoder.yudao.module.transaction.sales.controller.admin.commodityspecification.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 商品规格 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommoditySpecificationRespVO extends CommoditySpecificationBaseVO {

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
