package cn.acsm.module.wallet.controller.admin.wallet.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 钱包交易记录子 Excel 导出 Request VO", description = "参数和 TransactionHistoryPageReqVO 是一致的")
@Data
public class TransactionHistoryExportReqVO {

    @ApiModelProperty(value = "会员id")
    private String memberId;

    @ApiModelProperty(value = "钱包id")
    private String walletId;

    @ApiModelProperty(value = "交易编号")
    private String transactionNumber;

    @ApiModelProperty(value = "交易类型")
    private String transactionType;

    @ApiModelProperty(value = "支付方式")
    private String payType;

    @ApiModelProperty(value = "关联单据")
    private String associatedDocuments;

    @ApiModelProperty(value = "交易内容")
    private String transactionContent;

    @ApiModelProperty(value = "交易金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "交易时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] transactionTime;

    @ApiModelProperty(value = "付款方")
    private String payer;

    @ApiModelProperty(value = "收款方")
    private String recipient;

    @ApiModelProperty(value = "付款账号")
    private String paymentAccountNumber;

    @ApiModelProperty(value = "收款账号")
    private String payoutAccount;

    @ApiModelProperty(value = "交易状态")
    private String transactionStatus;

    @ApiModelProperty(value = "备注信息")
    private String remark;

    @ApiModelProperty(value = "状态（0正常 1停用）")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
