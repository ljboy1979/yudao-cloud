package cn.acsm.module.transaction.order.controller.admin.sartinfo.vo;

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
* 购物车 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class SartInfoBaseVO {

    @ApiModelProperty(value = "货架id")
    private String shelvesId;

    @ApiModelProperty(value = "货架名称")
    private String shelvesName;

    @ApiModelProperty(value = "规格名称")
    private String specificationName;

    @ApiModelProperty(value = "计量单位")
    private String measureUnit;

    @ApiModelProperty(value = "预定的用户")
    private String userId;

    @ApiModelProperty(value = "餐次（1早 2中 3晚）")
    private String mealsTime;

    @ApiModelProperty(value = "购买数量")
    private String num;

    @ApiModelProperty(value = "订购日期(例：2021-12-13)")
    private String reserveDate;

    @ApiModelProperty(value = "付款状态 0 未付款  1 已付款 2 已退款")
    private String payStatus;

    @ApiModelProperty(value = "套餐状态（默认 0未付款 1已取消 2已锁定 3已完成）")
    private String planStatus;

    @ApiModelProperty(value = "配送状态 默认状态0待配送 1已配送")
    private String sendStatus;

    @ApiModelProperty(value = "配送号")
    private String sendNumber;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "来源")
    private String source;

    @ApiModelProperty(value = "赠品编号")
    private String giftNumber;

    @ApiModelProperty(value = "是否为赠品（0-否，1-是）")
    private String giftStatus;

    @ApiModelProperty(value = "已退金额")
    private BigDecimal refundPrice;

    @ApiModelProperty(value = "付款状态 0 未申请退款  1 已申请全额退 2 已申请部分退款")
    private String refundStatus;

    @ApiModelProperty(value = "选中状态 1默认选中（0-否，1-是）")
    private String selectedStatus;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

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

    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "处理规格")
    private String processTagName;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

}
