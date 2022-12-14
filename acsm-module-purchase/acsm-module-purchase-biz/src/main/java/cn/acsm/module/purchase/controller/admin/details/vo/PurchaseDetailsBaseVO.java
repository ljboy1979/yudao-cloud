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

    @ApiModelProperty(value = "采购单id", required = true)
    @NotNull(message = "采购单id不能为空")
    private Long orderId;

    @ApiModelProperty(value = "采购单号", required = true)
    @NotNull(message = "采购单号不能为空")
    private String purchaseOrderNumber;

    @ApiModelProperty(value = "货品id", required = true)
    @NotNull(message = "货品id不能为空")
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
    private String unitOfMeasurement;

    @ApiModelProperty(value = "包装类型")
    private String packagingType;

    @ApiModelProperty(value = "采购数量/重量", required = true)
    @NotNull(message = "采购数量/重量不能为空")
    private BigDecimal purchaseQuantity;

    @ApiModelProperty(value = "期望到货频次")
    private String expectedArrivalFrequency;

    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "优惠金额")
    private BigDecimal discountAmount;

    @ApiModelProperty(value = "采购金额")
    private BigDecimal purchaseAmount;

    @ApiModelProperty(value = "货品id")
    private Long chargingStandard;

    @ApiModelProperty(value = "经营主体", required = true)
    private String subjectId;

}
