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

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 订单 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class OrderInfoExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("货架id")
    private String shelvesId;

    @ExcelProperty("计划id")
    private String planId;

    @ExcelProperty("预定的用户")
    private String userId;

    @ExcelProperty("餐次（1早 2中 3晚）")
    private String mealsTime;

    @ExcelProperty("订单价格")
    private BigDecimal price;

    @ExcelProperty("付款状态 0未付款 1进行中/付款 2已取消/退款 3已完成")
    private String payStatus;

    @ExcelProperty("配送状态 默认状态0待配送 1已配送")
    private String sendStatus;

    @ExcelProperty("配送号")
    private String sendNumber;

    @ExcelProperty("备注信息")
    private String remarks;

    @ExcelProperty("实收金额")
    private BigDecimal actualPrice;

    @ExcelProperty("支付方式 0 账单 1 微信  ")
    private String payType;

    @ExcelProperty("地址")
    private String address;

    @ExcelProperty("订单备注 ")
    private String orderRemarks;

    @ExcelProperty("发票申请状态（0-待申请，1-申请中，2-已申请）")
    private String invoiceStatus;

    @ExcelProperty("结账状态（0-未结账  1-已结账）")
    private String settleStatus;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("调价说明")
    private String priceExplain;

    @ExcelProperty("物流状态(0待确认，1备货中，2运输中，3已送达，4服务期结束，5已取消)")
    private String logisticsStatus;

    @ExcelProperty("预计发货时间")
    private Date estimatedDeliveryTime;

    @ExcelProperty("物流单号")
    private String ogisticsTicketNumber;

    @ExcelProperty("物流公司")
    private String logisticsCompanies;

    @ExcelProperty("取消订单原因")
    private String cause;

    @ExcelProperty("订单类型 0普通订单 1预订订单 2批量采购订单")
    private String orderType;

    @ExcelProperty("预订单id")
    private String skuPackageOrderReserveId;

    @ExcelProperty("分配状态 0未分配 1已分配")
    private String allotStatus;

    @ExcelProperty("采购方式 0单地址 1多地址")
    private String purchaseType;

    @ExcelProperty("物流费用")
    private BigDecimal logisticsPrice;

    @ExcelProperty("服务费用")
    private Double servicePrice;

    @ExcelProperty("优惠金额")
    private BigDecimal preferentialPrice;

    @ExcelProperty("退补差价")
    private BigDecimal spreadPrice;

    @ExcelProperty("佣金")
    private BigDecimal commission;

    @ExcelProperty("成交金额")
    private BigDecimal dealPrice;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("source")
    private String source;

}
