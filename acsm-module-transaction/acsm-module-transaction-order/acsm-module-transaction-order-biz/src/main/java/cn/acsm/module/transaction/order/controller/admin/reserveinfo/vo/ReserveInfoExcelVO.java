package cn.acsm.module.transaction.order.controller.admin.reserveinfo.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 预定订单 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ReserveInfoExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("预定id")
    private String planReserveId;

    @ExcelProperty("预定的用户")
    private String userId;

    @ExcelProperty("订金金额")
    private BigDecimal price;

    @ExcelProperty("预订单总金额")
    private BigDecimal actualPrice;

    @ExcelProperty("实付金额")
    private BigDecimal practicalPrice;

    @ExcelProperty("支付方式 0 账单 1 微信  ")
    private String payType;

    @ExcelProperty("地址")
    private String address;

    @ExcelProperty("预定备注")
    private String orderRemarks;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("预定状态 0已预定 1已下单 2已过期 3已取消 4未付款 5已完成")
    private String payStatus;

    @ExcelProperty("备注信息")
    private String remarks;

    @ExcelProperty("捕捞id 关联harvest_batch")
    private String harvestBatchId;

    @ExcelProperty("来源")
    private String source;

    @ExcelProperty("配送方式 0包邮 1不包邮")
    private String sendType;

    @ExcelProperty("物流费用")
    private BigDecimal logisticsPrice;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

}
