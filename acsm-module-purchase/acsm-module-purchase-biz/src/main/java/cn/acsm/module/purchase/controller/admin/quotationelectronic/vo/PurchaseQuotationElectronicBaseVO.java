package cn.acsm.module.purchase.controller.admin.quotationelectronic.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
* 采购报价单电子 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PurchaseQuotationElectronicBaseVO {

    @ApiModelProperty(value = "报价单id", required = true)
    @NotNull(message = "报价单id不能为空")
    private Long quotationId;

    @ApiModelProperty(value = "报价单编号", required = true)
    @NotNull(message = "报价单编号不能为空")
    private String quotationNo;

    @ApiModelProperty(value = "询价单明细id", required = true)
    @NotNull(message = "询价单明细id不能为空")
    private Long inquiryId;

    @ApiModelProperty(value = "商品id", required = true)
    @NotNull(message = "商品id不能为空")
    private Long commodityId;

    @ApiModelProperty(value = "分类id", required = true)
    @NotNull(message = "分类id不能为空")
    private Long classifyId;

    @ApiModelProperty(value = "规格id")
    private Long specificationsId;

    @ApiModelProperty(value = "起批数量")
    private Integer initialBatchCount;

    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "采购数量")
    private Integer purchaseCount;

    @ApiModelProperty(value = "总价")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "经营主体", required = true)
    private String subjectId;

}
