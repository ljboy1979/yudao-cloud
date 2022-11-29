package cn.acsm.module.transaction.sales.controller.admin.rawmaterial.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 原料 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class RawMaterialBaseVO {

    @ApiModelProperty(value = "原料编号")
    private String ingredientNumber;

    @ApiModelProperty(value = "分类id")
    private String classify;

    @ApiModelProperty(value = "原料名称")
    private String name;

    @ApiModelProperty(value = "产地(字典值)")
    private String origin;

    @ApiModelProperty(value = "原料图片")
    private String imgUrl;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "专家建议")
    private String expertAdvice;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

}
