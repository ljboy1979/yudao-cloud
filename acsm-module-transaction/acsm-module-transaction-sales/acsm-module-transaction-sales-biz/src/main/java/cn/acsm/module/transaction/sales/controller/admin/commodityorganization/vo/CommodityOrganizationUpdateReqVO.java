package cn.acsm.module.transaction.sales.controller.admin.commodityorganization.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 商品组成更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommodityOrganizationUpdateReqVO extends CommodityOrganizationBaseVO {

    @ApiModelProperty(value = "id", required = true)
    @NotNull(message = "id不能为空")
    private String id;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;


}
