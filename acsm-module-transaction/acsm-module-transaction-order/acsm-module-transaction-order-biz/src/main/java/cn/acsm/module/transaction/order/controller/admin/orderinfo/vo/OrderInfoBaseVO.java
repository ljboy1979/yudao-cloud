package cn.acsm.module.transaction.order.controller.admin.orderinfo.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 订单 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class OrderInfoBaseVO {

    @ApiModelProperty(value = "货架id")
    private String shelvesId;
    @ApiModelProperty(value = "编号")
    private String code;

    @ApiModelProperty(value = "计划id")
    private String planId;

    @ApiModelProperty(value = "预定的用户")
    private String userId;

    @ApiModelProperty(value = "餐次（1早 2中 3晚）")
    private String mealsTime;

    @ApiModelProperty(value = "订单价格")
    private BigDecimal price;

    @ApiModelProperty(value = "付款状态 0未付款 1进行中/付款 2已取消/退款 3已完成", required = true)
    private String payStatus;

    @ApiModelProperty(value = "配送状态 默认状态0待配送 1已配送", required = true)
    private String sendStatus;

    @ApiModelProperty(value = "配送号")
    private String sendNumber;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "实收金额")
    private BigDecimal actualPrice;

    @ApiModelProperty(value = "支付方式 0 账单 1 微信  ")
    private String payType;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "订单备注 ")
    private String orderRemarks;

    @ApiModelProperty(value = "发票申请状态（0-待申请，1-申请中，2-已申请）")
    private String invoiceStatus;

    @ApiModelProperty(value = "结账状态（0-未结账  1-已结账）")
    private String settleStatus;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "调价说明")
    private String priceExplain;

    @ApiModelProperty(value = "物流状态(0待确认，1备货中，2运输中，3已送达，4服务期结束，5已取消)")
    private String logisticsStatus;

    @ApiModelProperty(value = "预计发货时间")
    private Date estimatedDeliveryTime;

    @ApiModelProperty(value = "物流单号")
    private String ogisticsTicketNumber;

    @ApiModelProperty(value = "物流公司")
    private String logisticsCompanies;

    @ApiModelProperty(value = "取消订单原因")
    private String cause;

    @ApiModelProperty(value = "订单类型 0普通订单 1预订订单 2批量采购订单")
    private String orderType;

    @ApiModelProperty(value = "预订单id")
    private String skuPackageOrderReserveId;

    @ApiModelProperty(value = "分配状态 0未分配 1已分配")
    private String allotStatus;

    @ApiModelProperty(value = "采购方式 0单地址 1多地址")
    private String purchaseType;

    @ApiModelProperty(value = "物流费用")
    private BigDecimal logisticsPrice;

    @ApiModelProperty(value = "服务费用")
    private Double servicePrice;

    @ApiModelProperty(value = "优惠金额")
    private BigDecimal preferentialPrice;

    @ApiModelProperty(value = "退补差价")
    private BigDecimal spreadPrice;

    @ApiModelProperty(value = "佣金")
    private BigDecimal commission;

    @ApiModelProperty(value = "成交金额")
    private BigDecimal dealPrice;

    @ApiModelProperty(value = "状态", required = true)
    private Integer status;

    @ApiModelProperty(value = "source")
    private String source;

}
