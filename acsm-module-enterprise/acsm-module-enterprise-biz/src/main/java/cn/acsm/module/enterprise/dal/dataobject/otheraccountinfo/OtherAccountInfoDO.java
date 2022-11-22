package cn.acsm.module.enterprise.dal.dataobject.otheraccountinfo;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 经营主体其他账户 DO
 *
 * @author 芋道源码
 */
@TableName("enterprise_other_account_info")
@KeySequence("enterprise_other_account_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OtherAccountInfoDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 经营主体ID
     */
    private Long enterpriseId;
    /**
     * 账户名
     */
    private String accountName;
    /**
     * 账户银行卡号
     */
    private String accountNo;
    /**
     * 账户身份证号
     */
    private String accountIdCard;
    /**
     * 账户开户行
     */
    private String accountBank;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
