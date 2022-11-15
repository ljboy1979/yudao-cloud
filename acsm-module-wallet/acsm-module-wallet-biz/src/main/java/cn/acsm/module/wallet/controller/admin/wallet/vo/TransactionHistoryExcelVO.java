package cn.acsm.module.wallet.controller.admin.wallet.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 钱包交易记录子 Excel VO
 *
 * @author lihongyan
 */
@Data
public class TransactionHistoryExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("会员id")
    private String memberId;

    @ExcelProperty("钱包id")
    private String walletId;

    @ExcelProperty("交易编号")
    private String transactionNumber;

    @ExcelProperty("交易类型")
    private String transactionType;

    @ExcelProperty("支付方式")
    private String payType;

    @ExcelProperty("关联单据")
    private String associatedDocuments;

    @ExcelProperty("交易内容")
    private String transactionContent;

    @ExcelProperty("交易金额")
    private BigDecimal amount;

    @ExcelProperty("交易时间")
    private Date transactionTime;

    @ExcelProperty("付款方")
    private String payer;

    @ExcelProperty("收款方")
    private String recipient;

    @ExcelProperty("付款账号")
    private String paymentAccountNumber;

    @ExcelProperty("收款账号")
    private String payoutAccount;

    @ExcelProperty("交易状态")
    private String transactionStatus;

    @ExcelProperty("备注信息")
    private String remark;

    @ExcelProperty("状态（0正常 1停用）")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
