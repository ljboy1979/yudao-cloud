package cn.acsm.module.purchase.controller.admin.quotation.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
* 采购询价电子 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PurchaseQuotationBaseVO {

    @ApiModelProperty(value = "报价单编号", required = true)
    @NotNull(message = "报价单编号不能为空")
    private String quotationNo;

    @ApiModelProperty(value = "报价单名称", required = true)
    @NotNull(message = "报价单名称不能为空")
    private String quotationName;

    @ApiModelProperty(value = "采购商id", required = true)
    @NotNull(message = "采购商id不能为空")
    private Long purchaserId;

    @ApiModelProperty(value = "询价单id", required = true)
    @NotNull(message = "询价单id不能为空")
    private Long inquiryId;

    @ApiModelProperty(value = "询价单编号", required = true)
    @NotNull(message = "询价单编号不能为空")
    private String inquiryNo;

    @ApiModelProperty(value = "报价有效期")
    private Date quotationValidTime;

    @ApiModelProperty(value = "是否提交 0：未提交 1：已提交")
    private Boolean isSubmit;

    @ApiModelProperty(value = "经营主体", required = true)
    private String subjectId;

}
