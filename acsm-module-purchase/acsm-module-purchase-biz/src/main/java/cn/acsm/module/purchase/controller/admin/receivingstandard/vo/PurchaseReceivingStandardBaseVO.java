package cn.acsm.module.purchase.controller.admin.receivingstandard.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
* 收货标准 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PurchaseReceivingStandardBaseVO {

    @ApiModelProperty(value = "标准名称", required = true)
    @NotNull(message = "标准名称不能为空")
    private String standardName;

    @ApiModelProperty(value = "范围上限", required = true)
    @NotNull(message = "范围上限不能为空")
    private String upperRange;

    @ApiModelProperty(value = "范围下限", required = true)
    @NotNull(message = "范围下限不能为空")
    private String lowerRange;

    @ApiModelProperty(value = "单位", required = true)
    @NotNull(message = "单位不能为空")
    private String company;

    @ApiModelProperty(value = "经营主体", required = true)
    @NotNull(message = "经营主体不能为空")
    private String subjectId;

}
