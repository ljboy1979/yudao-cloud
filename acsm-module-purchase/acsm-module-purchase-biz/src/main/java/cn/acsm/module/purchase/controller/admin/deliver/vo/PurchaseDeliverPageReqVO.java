package cn.acsm.module.purchase.controller.admin.deliver.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 采购交付分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PurchaseDeliverPageReqVO extends PageParam {

    @ApiModelProperty(value = "采购单id")
    private Long orderId;

    @ApiModelProperty(value = "采购单明细id")
    private Long orderDetailsId;

    @ApiModelProperty(value = "采购单号")
    private String purchaseOrderNumber;

    @ApiModelProperty(value = "交付批次号(系统自动生成)")
    private String deliveryBatch;

    @ApiModelProperty(value = "期望交付时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] expectedDeliveryTime;

    @ApiModelProperty(value = "实际交付时间")
    private Date actualDelivery;

    @ApiModelProperty(value = "期望交付数量")
    private Integer expectedDeliveryCount;

    @ApiModelProperty(value = "实际交付数量")
    private Integer actualDeliveryCount;

    @ApiModelProperty(value = "单位(字典id)")
    private Long companyId;

    @ApiModelProperty(value = "结算时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] settlementTime;

    @ApiModelProperty(value = "结算金额")
    private BigDecimal settlementAmount;

    @ApiModelProperty(value = "1.未交付 2.已交付")
    private String deliveryStatus;

    @ApiModelProperty(value = "发货单号")
    private String shipmentNo;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体")
    private String subjectId;

}
