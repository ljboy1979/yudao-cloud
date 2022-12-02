package cn.acsm.module.transaction.sales.controller.admin.nutritionfacts.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 营养成分 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class NutritionFactsBaseVO {

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

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

}
