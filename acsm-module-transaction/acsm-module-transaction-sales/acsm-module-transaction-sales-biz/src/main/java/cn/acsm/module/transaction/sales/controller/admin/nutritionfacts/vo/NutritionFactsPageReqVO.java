package cn.acsm.module.transaction.sales.controller.admin.nutritionfacts.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 营养成分分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NutritionFactsPageReqVO extends PageParam {

    @ApiModelProperty(value = "类型（0菜品、1套餐、2特医食品）")
    //@NotNull(message = "类型不能为空")
    private String type;

    @ApiModelProperty(value = "来源id（菜品、套餐、特医食品）")
    @NotNull(message = "来源id不能为空")
    private String sourceId;

    @ApiModelProperty(value = "编号")
    private String number;

    @ApiModelProperty(value = "营养成分(字典id)")
    //@NotNull(message = "营养成分不能为空")
    private String nutritionFacts;

    @ApiModelProperty(value = "营养成分名称")
    //@NotNull(message = "营养成分名称不能为空")
    private String nutritionFactsName;



    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
