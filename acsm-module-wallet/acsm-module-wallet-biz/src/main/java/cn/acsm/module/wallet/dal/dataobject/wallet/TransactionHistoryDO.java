package cn.acsm.module.wallet.dal.dataobject.wallet;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 钱包交易记录子 DO
 *
 * @author lihongyan
 */
@TableName("wallet_transaction_history")
@KeySequence("wallet_transaction_history_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionHistoryDO extends TenantBaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 会员id
     */
    private Long memberId;
    /**
     * 钱包id
     */
    private Long walletId;
    /**
     * 交易编号
     */
    private String transactionNumber;
    /**
     * 交易类型
     */
    private String transactionType;
    /**
     * 支付方式
     */
    private String payType;
    /**
     * 关联单据
     */
    private String associatedDocuments;
    /**
     * 交易内容
     */
    private String transactionContent;
    /**
     * 交易金额
     */
    private BigDecimal amount;
    /**
     * 交易时间
     */
    private Date transactionTime;
    /**
     * 付款方
     */
    private String payer;
    /**
     * 收款方
     */
    private String recipient;
    /**
     * 付款账号
     */
    private String paymentAccountNumber;
    /**
     * 收款账号
     */
    private String payoutAccount;
    /**
     * 交易状态
     */
    private String transactionStatus;
    /**
     * 备注信息
     */
    private String remark;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
