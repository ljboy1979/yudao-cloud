package cn.iocoder.yudao.module.transaction.sales.controller.admin.dishes.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 菜品 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class DishesBaseVO {

    @ApiModelProperty(value = "菜品编号")
    private String ingredientNumber;

    @ApiModelProperty(value = "菜品名称")
    private String dishesName;

    @ApiModelProperty(value = "菜品分类")
    private String menuClassification;

    @ApiModelProperty(value = "菜系")
    private String cuisine;

    @ApiModelProperty(value = "烹饪方式")
    private Boolean cookingStyle;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

}
