package cn.acsm.module.purchase.controller.admin.details.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
* 采购单明细 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PurchaseDetailsBaseVO {

    @ApiModelProperty(value = "采购单编号", required = true)
    @NotNull(message = "采购单编号不能为空")
    private Long purchaseId;

    @ApiModelProperty(value = "采购单号", required = true)
    @NotNull(message = "采购单号不能为空")
    private String purchaseNumber;

    @ApiModelProperty(value = "货品编号", required = true)
    @NotNull(message = "货品编号不能为空")
    private Long goodsId;

    @ApiModelProperty(value = "货品名称", required = true)
    @NotNull(message = "货品名称不能为空")
    private String goodsName;

    @ApiModelProperty(value = "包装规格id")
    private Long packagingSpecificationId;

    @ApiModelProperty(value = "包装规格")
    private String packagingSpecification;

    @ApiModelProperty(value = "计量单位", required = true)
    @NotNull(message = "计量单位不能为空")
    private String unit;

    @ApiModelProperty(value = "包装类型")
    private String packagingType;

    @ApiModelProperty(value = "采购数量/重量", required = true)
    @NotNull(message = "采购数量/重量不能为空")
    private BigDecimal buyNumber;

    @ApiModelProperty(value = "期望到货频次")
    private String frequency;

    @ApiModelProperty(value = "单价")
    private BigDecimal price;

    @ApiModelProperty(value = "优惠金额")
    private BigDecimal discount;

    @ApiModelProperty(value = "采购金额(总金额)")
    private BigDecimal total;

    @ApiModelProperty(value = "收货标准id")
    private Long standardId;

    @ApiModelProperty(value = "经营主体", required = true)
    @NotNull(message = "经营主体不能为空")
    private String subjectId;

}
