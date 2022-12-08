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

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 购物车 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class SartInfoExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("货架id")
    private String shelvesId;

    @ExcelProperty("货架名称")
    private String shelvesName;

    @ExcelProperty("规格名称")
    private String specificationName;

    @ExcelProperty("计量单位")
    private String measureUnit;

    @ExcelProperty("预定的用户")
    private String userId;

    @ExcelProperty("餐次（1早 2中 3晚）")
    private String mealsTime;

    @ExcelProperty("购买数量")
    private String num;

    @ExcelProperty("订购日期(例：2021-12-13)")
    private String reserveDate;

    @ExcelProperty("付款状态 0 未付款  1 已付款 2 已退款")
    private String payStatus;

    @ExcelProperty("套餐状态（默认 0未付款 1已取消 2已锁定 3已完成）")
    private String planStatus;

    @ExcelProperty("配送状态 默认状态0待配送 1已配送")
    private String sendStatus;

    @ExcelProperty("配送号")
    private String sendNumber;

    @ExcelProperty("备注信息")
    private String remarks;

    @ExcelProperty("价格")
    private BigDecimal price;

    @ExcelProperty("来源")
    private String source;

    @ExcelProperty("赠品编号")
    private String giftNumber;

    @ExcelProperty("是否为赠品（0-否，1-是）")
    private String giftStatus;

    @ExcelProperty("已退金额")
    private BigDecimal refundPrice;

    @ExcelProperty("付款状态 0 未申请退款  1 已申请全额退 2 已申请部分退款")
    private String refundStatus;

    @ExcelProperty("选中状态 1默认选中（0-否，1-是）")
    private String selectedStatus;

    @ExcelProperty("经营主体id")
    private String subjectId;

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

    @ExcelProperty("单价")
    private BigDecimal unitPrice;

    @ExcelProperty("处理规格")
    private String processTagName;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

}
