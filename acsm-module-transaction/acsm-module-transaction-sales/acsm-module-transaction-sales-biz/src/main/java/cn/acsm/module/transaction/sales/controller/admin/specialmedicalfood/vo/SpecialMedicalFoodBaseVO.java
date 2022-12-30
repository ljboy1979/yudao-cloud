package cn.acsm.module.transaction.sales.controller.admin.specialmedicalfood.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 特医食品 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class SpecialMedicalFoodBaseVO {

    @ApiModelProperty(value = "特医食品编号")
    private String number;

    @ApiModelProperty(value = "特医食品名称")
    private String name;

    @ApiModelProperty(value = "特医食品分类id")
    private String classify;

    @ApiModelProperty(value = "特医食品图片")
    private String imgUrl;

    @ApiModelProperty(value = "备注")
    @Size(max = 200 , min = 0 ,message = "备注个数必须在0和200之间")
    private String remark;

    @ApiModelProperty(value = "专家建议")
    @Size(max = 200 , min = 0 ,message = "专家建议个数必须在0和200之间")
    private String expertAdvice;

    @ApiModelProperty(value = "状态", required = true)
    //@NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

}
