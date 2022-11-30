package cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 商品规格创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommoditySpecificationCreateReqVO extends CommoditySpecificationBaseVO {

    @ApiModelProperty(value = "商品id")
    @NotNull(message = "商品id不能为空")
    private String commodityId;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

}
