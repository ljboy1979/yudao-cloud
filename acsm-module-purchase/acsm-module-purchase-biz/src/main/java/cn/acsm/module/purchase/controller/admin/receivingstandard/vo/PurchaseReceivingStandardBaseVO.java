package cn.acsm.module.purchase.controller.admin.receivingstandard.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
* 收货标准 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PurchaseReceivingStandardBaseVO {

    @ApiModelProperty(value = "标准名称", required = true)
    @NotNull(message = "标准名称不能为空")
    private String name;

    @ApiModelProperty(value = "范围上限")
    private BigDecimal upperLimit;

    @ApiModelProperty(value = "范围下限")
    private BigDecimal lowerLimit;

    @ApiModelProperty(value = "单位(字典id)", required = true)
    @NotNull(message = "单位(字典id)不能为空")
    private String unit;

    @ApiModelProperty(value = "经营主体", required = true)
    @NotNull(message = "经营主体不能为空")
    private String subjectId;

}
