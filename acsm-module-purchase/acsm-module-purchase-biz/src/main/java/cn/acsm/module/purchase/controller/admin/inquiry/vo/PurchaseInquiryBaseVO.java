package cn.acsm.module.purchase.controller.admin.inquiry.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
* 采购询价电子 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PurchaseInquiryBaseVO {

    @ApiModelProperty(value = "询价单编号", required = true)
    @NotNull(message = "询价单编号不能为空")
    private String inquiryNo;

    @ApiModelProperty(value = "商品id", required = true)
    @NotNull(message = "商品id不能为空")
    private Long productId;

    @ApiModelProperty(value = "分类id", required = true)
    @NotNull(message = "分类id不能为空")
    private Long classifyId;

    @ApiModelProperty(value = "规格id")
    private Long specificationsId;

    @ApiModelProperty(value = "计划数量最低")
    private Integer lowestPlannedQuantity;

    @ApiModelProperty(value = "计划数量最高")
    private Integer highestPlannedQuantity;

    @ApiModelProperty(value = "经营主体", required = true)
    private String subjectId;

}
