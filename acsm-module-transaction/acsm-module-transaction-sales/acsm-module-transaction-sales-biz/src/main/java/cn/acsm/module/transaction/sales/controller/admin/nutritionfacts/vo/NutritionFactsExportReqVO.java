package cn.acsm.module.transaction.sales.controller.admin.nutritionfacts.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 营养成分 Excel 导出 Request VO", description = "参数和 NutritionFactsPageReqVO 是一致的")
@Data
public class NutritionFactsExportReqVO {

    @ApiModelProperty(value = "类型（0菜品、1套餐、2特医食品）")
    private String type;

    @ApiModelProperty(value = "来源id（菜品、套餐、特医食品）")
    private String sourceId;

    @ApiModelProperty(value = "编号")
    private String number;

    @ApiModelProperty(value = "营养成分(字典id)")
    private String nutritionFacts;

    @ApiModelProperty(value = "营养成分名称")
    private String nutritionFactsName;

    @ApiModelProperty(value = "含量")
    private String content;

    @ApiModelProperty(value = "单位(字典id)")
    private String unit;

    @ApiModelProperty(value = "单位名称")
    private String unitName;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
