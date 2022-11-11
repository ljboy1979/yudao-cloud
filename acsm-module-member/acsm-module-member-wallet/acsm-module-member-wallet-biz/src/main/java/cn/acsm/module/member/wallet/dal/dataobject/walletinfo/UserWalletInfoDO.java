package cn.acsm.module.member.wallet.dal.dataobject.walletinfo;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 用户钱包信息 DO
 *
 * @author lihongyan
 */
@TableName("user_wallet_info")
@KeySequence("user_wallet_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserWalletInfoDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 钱包编号
     */
    private String walletId;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户名
     */
    private String username;
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

}
