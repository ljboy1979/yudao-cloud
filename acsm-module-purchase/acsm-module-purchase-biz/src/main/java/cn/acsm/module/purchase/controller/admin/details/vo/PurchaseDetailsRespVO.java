package cn.acsm.module.purchase.controller.admin.details.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel("管理后台 - 采购单明细 Response VO")
@Data
@ToString(callSuper = true)
public class PurchaseDetailsRespVO {

    @ApiModelProperty(value = "编号", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "采购单id", required = true)
    private Long orderId;

    @ApiModelProperty(value = "采购单号", required = true)
    private String purchaseOrderNumber;

    @ApiModelProperty(value = "货品id", required = true)
    private Long goodsId;

    @ApiModelProperty(value = "货品名称", required = true)
    private String goodsName;

    @ApiModelProperty(value = "包装规格id")
    private Long packagingSpecificationId;

    @ApiModelProperty(value = "包装规格")
    private String packagingSpecification;

    @ApiModelProperty(value = "计量单位", required = true)
    private String unitOfMeasurement;

    @ApiModelProperty(value = "包装类型")
    private String packagingType;

    @ApiModelProperty(value = "采购数量/重量", required = true)
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
