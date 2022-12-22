package cn.acsm.module.purchase.controller.admin.deliver.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel("管理后台 - 采购交付创建 Request VO")
@Data
@ToString(callSuper = true)
public class PurchaseDeliverCreateReqVO implements Serializable {

    @ApiModelProperty(value = "交付数量", required = true)
    private BigDecimal deliveryQuantity;

    @ApiModelProperty(value = "采购单明细id", required = true)
    private Long purchaseDetailsId;

    @ApiModelProperty(value = "期望交付时间", required = true)
    private Date expectedDeliveryTime;

    @ApiModelProperty(value = "实际交付时间")
    private Date actualDelivery;

    @ApiModelProperty(value = "期望交付数量", required = true)
    private Double expectedDeliveryCount;

    @ApiModelProperty(value = "实际交付数量")
    private Double actualDeliveryCount;

    @ApiModelProperty(value = "单位(字典id)", required = true)
    private Long companyId;

    @ApiModelProperty(value = "结算时间")
    private Date settlementTime;

    @ApiModelProperty(value = "结算金额")
    private BigDecimal settlementAmount;

    @ApiModelProperty(value = "1.未交付 2.已交付")
    private String deliveryStatus;

    @ApiModelProperty(value = "发货单号")
    private String shipmentNo;

    @ApiModelProperty(value = "经营主体", required = true)
    private String subjectId;

    @ApiModelProperty(value = "租户id", required = true)
    private String tenantId;

    @ApiModelProperty(value = "用户id", required = true)
    private Long userId;

    @ApiModelProperty(value = "租户集合", required = true)
    private Long sourceId;

}
