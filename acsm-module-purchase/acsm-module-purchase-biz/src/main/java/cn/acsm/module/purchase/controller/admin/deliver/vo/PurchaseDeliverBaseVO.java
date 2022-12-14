package cn.acsm.module.purchase.controller.admin.deliver.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
* 采购交付 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PurchaseDeliverBaseVO {

    @ApiModelProperty(value = "采购单id", required = true)
    @NotNull(message = "采购单id不能为空")
    private Long orderId;

    @ApiModelProperty(value = "采购单明细id", required = true)
    @NotNull(message = "采购单明细id不能为空")
    private Long orderDetailsId;

    @ApiModelProperty(value = "采购单号", required = true)
    @NotNull(message = "采购单号不能为空")
    private String purchaseOrderNumber;

    @ApiModelProperty(value = "交付批次号(系统自动生成)", required = true)
    @NotNull(message = "交付批次号(系统自动生成)不能为空")
    private String deliveryBatch;

    @ApiModelProperty(value = "期望交付时间", required = true)
    @NotNull(message = "期望交付时间不能为空")
    private Date expectedDeliveryTime;

    @ApiModelProperty(value = "实际交付时间")
    private Date actualDelivery;

    @ApiModelProperty(value = "期望交付数量", required = true)
    @NotNull(message = "期望交付数量不能为空")
    private Integer expectedDeliveryCount;

    @ApiModelProperty(value = "实际交付数量")
    private Integer actualDeliveryCount;

    @ApiModelProperty(value = "单位(字典id)", required = true)
    @NotNull(message = "单位(字典id)不能为空")
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
    @NotNull(message = "经营主体不能为空")
    private String subjectId;

}
