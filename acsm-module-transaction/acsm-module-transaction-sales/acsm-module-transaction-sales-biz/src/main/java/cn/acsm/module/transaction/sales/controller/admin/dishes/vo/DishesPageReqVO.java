package cn.acsm.module.transaction.sales.controller.admin.dishes.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 菜品分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DishesPageReqVO extends PageParam {

    @ApiModelProperty(value = "菜品编号")
    private String ingredientNumber;

    @ApiModelProperty(value = "菜品名称")
    private String dishesName;

    @ApiModelProperty(value = "菜品分类")
    private String menuClassification;
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
