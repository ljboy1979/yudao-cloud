package cn.acsm.module.transaction.sales.controller.admin.dishesspecification.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@ApiModel("管理后台 - 菜品规格分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DishesSpecificationPageReqVO extends PageParam {

    @ApiModelProperty(value = "规格名称")
    private String specificationsName;

}
