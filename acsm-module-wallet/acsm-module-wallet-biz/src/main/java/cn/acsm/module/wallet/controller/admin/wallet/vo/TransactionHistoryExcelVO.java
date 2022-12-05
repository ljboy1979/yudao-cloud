package cn.acsm.module.wallet.controller.admin.wallet.vo;

import cn.acsm.module.wallet.enums.DictTypeConstants;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.TIME_ZONE_DEFAULT;

/**
 * 钱包交易记录子 Excel VO
 *
 * @author lihongyan
 */
@Data
public class TransactionHistoryExcelVO {

//    private Long id;
//
//    private Long memberId;
//
//    private Long walletId;

    @ExcelProperty("交易编号")
    private String transactionNumber;

    @ExcelProperty(value = "交易类型", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.WALLET_TRANSACTION_TYPE)
    private String transactionType;

    @ExcelProperty(value = "交易方式", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.WALLET_PAY_TYPE)
    private String payType;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("售品名称")
    private String transactionContent;

    @ExcelProperty("交易金额")
    private BigDecimal amount;

//    @ExcelProperty(value = "交易时间")
//    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = TIME_ZONE_DEFAULT)
//    private Date transactionTime;

//    @ExcelProperty("付款方")
//    private String payer;

    @ExcelProperty("支付账户")
    private String paymentAccountNumber;

    @ExcelProperty("收款账户")
    private String payoutAccount;

    @ExcelProperty("交易对象名称")
    private String recipient;

    @ExcelProperty(value ="交易状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.WALLET_TRANSACTION_STATUS)
    private String transactionStatus;

}
