package cn.acsm.module.wallet.dal.dataobject.wallet;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 关联银行卡子 DO
 *
 * @author lihongyan
 */
@TableName("wallet_bank_cards_info")
@KeySequence("wallet_bank_cards_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankCardsInfoDO extends TenantBaseDO {

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
     * 银行卡类型
     */
    private String bankCardType;
    /**
     * 持卡人
     */
    private String cardholder;
    /**
     * 卡号
     */
    private String cardNumber;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 备注信息
     */
    private String remark;
    /**
     * 状态（0正常 1停用）
     */
    private Integer status;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
