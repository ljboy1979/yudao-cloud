package cn.acsm.module.transaction.sales.controller.admin.dishesorganization.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 菜品组成 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class DishesOrganizationBaseVO {

    @ApiModelProperty(value = "原料表id")
    private String rawMaterialId;

    @ApiModelProperty(value = "菜品id")
    private String dishesId;

    @ApiModelProperty(value = "组成编号")
    private String organizationNumber;

    @ApiModelProperty(value = "组成名称")
    private String organizationName;

    @ApiModelProperty(value = "分类")
    private String classify;

    @ApiModelProperty(value = "产地")
    private String origin;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

    @ApiModelProperty(value = "备注", required = true)
    private String remarks;
}
