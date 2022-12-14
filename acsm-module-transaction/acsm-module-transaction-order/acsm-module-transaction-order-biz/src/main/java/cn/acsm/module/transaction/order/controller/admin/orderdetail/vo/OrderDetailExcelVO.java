package cn.acsm.module.transaction.order.controller.admin.orderdetail.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 订单详情 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class OrderDetailExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("编码")
    private String code;

    @ExcelProperty("订单id")
    private String orderId;

    @ExcelProperty("计划id")
    private String planId;

    @ExcelProperty("货架id")
    private String shelvesId;

    @ExcelProperty("货架名称")
    private String shelvesName;

    @ExcelProperty("规格id")
    private String specificationId;

    @ExcelProperty("规格名称")
    private String specificationName;

    @ExcelProperty("计量单位")
    private String measureUnit;

    @ExcelProperty("预定的用户")
    private String userId;

    @ExcelProperty(" 餐次（1早 2中 3晚）")
    private String mealsTime;

    @ExcelProperty("单价")
    private BigDecimal unitPrice;

    @ExcelProperty("购买量")
    private BigDecimal num;

    @ExcelProperty("总价")
    private BigDecimal totalPrice;

    @ExcelProperty("收货单价")
    private BigDecimal takeUnitPrice;

    @ExcelProperty("收货数量")
    private String takeNum;

    @ExcelProperty("收货金额")
    private BigDecimal takePrice;

    @ExcelProperty("退补说明")
    private String priceSpreadExplain;

    @ExcelProperty("退补差价")
    private BigDecimal priceSpread;

    @ExcelProperty("付款状态 0 未付款  1 已付款  2退款")
    private String payStatus;

    @ExcelProperty("配送状态 默认状态0待配送 1已配送")
    private String sendStatus;

    @ExcelProperty("配送时间")
    private Date deliveryTime;

    @ExcelProperty("处理规格")
    private String processTagName;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("source")
    private String source;

}
