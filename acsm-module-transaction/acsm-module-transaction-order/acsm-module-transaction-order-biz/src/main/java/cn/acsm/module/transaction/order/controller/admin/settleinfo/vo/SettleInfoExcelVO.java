package cn.acsm.module.transaction.order.controller.admin.settleinfo.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 订单结账 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class SettleInfoExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("订单id")
    private String orderId;

    @ExcelProperty("结账金额")
    private BigDecimal settlePrice;

    @ExcelProperty("实付金额")
    private BigDecimal actualPrice;

    @ExcelProperty("支付方式 0 对公转账  ")
    private String payType;

    @ExcelProperty("支付凭证")
    private String img;

    @ExcelProperty("备注信息")
    private String remarks;

    @ExcelProperty("结账时间")
    private Date settleTime;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("source")
    private String source;

}
