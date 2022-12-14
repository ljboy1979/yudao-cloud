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
import javax.validation.constraints.*;

/**
* 订单详情 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class OrderDetailBaseVO {

    @ApiModelProperty(value = "编码", required = true)
    private String code;

    @ApiModelProperty(value = "订单id", required = true)
    @NotNull(message = "订单id不能为空")
    private String orderId;

    @ApiModelProperty(value = "计划id")
    private String planId;

    @ApiModelProperty(value = "货架id")
    private String shelvesId;

    @ApiModelProperty(value = "货架名称")
    private String shelvesName;

    @ApiModelProperty(value = "规格id")
    private String specificationId;

    @ApiModelProperty(value = "规格名称")
    private String specificationName;

    @ApiModelProperty(value = "计量单位")
    private String measureUnit;

    @ApiModelProperty(value = "预定的用户")
    private String userId;

    @ApiModelProperty(value = " 餐次（1早 2中 3晚）")
    private String mealsTime;

    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "购买量")
    private BigDecimal num;

    @ApiModelProperty(value = "总价")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "收货单价")
    private BigDecimal takeUnitPrice;

    @ApiModelProperty(value = "收货数量")
    private String takeNum;

    @ApiModelProperty(value = "收货金额")
    private BigDecimal takePrice;

    @ApiModelProperty(value = "退补说明")
    private String priceSpreadExplain;

    @ApiModelProperty(value = "退补差价")
    private BigDecimal priceSpread;

    @ApiModelProperty(value = "付款状态 0 未付款  1 已付款  2退款", required = true)
    @NotNull(message = "付款状态 0 未付款  1 已付款  2退款不能为空")
    private String payStatus;

    @ApiModelProperty(value = "配送状态 默认状态0待配送 1已配送", required = true)
    @NotNull(message = "配送状态 默认状态0待配送 1已配送不能为空")
    private String sendStatus;

    @ApiModelProperty(value = "配送时间")
    private Date deliveryTime;

    @ApiModelProperty(value = "处理规格")
    private String processTagName;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

}
