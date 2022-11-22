package cn.acsm.module.wallet.controller.admin.wallet.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 钱包交易记录子 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class TransactionHistoryBaseVO {

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "钱包id")
    private Long walletId;

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
    private Date transactionTime;

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

    @ApiModelProperty(value = "状态（0正常 1停用）", required = true)
    @NotNull(message = "状态（0正常 1停用）不能为空")
    private Integer status;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
