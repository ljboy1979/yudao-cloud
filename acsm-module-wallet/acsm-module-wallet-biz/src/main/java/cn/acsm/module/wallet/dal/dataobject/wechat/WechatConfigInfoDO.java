package cn.acsm.module.wallet.dal.dataobject.wechat;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 微信支付配置信息 DO
 *
 * @author lihongyan
 */
@TableName("wallet_wechat_config_info")
@KeySequence("wallet_wechat_config_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WechatConfigInfoDO extends TenantBaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 公众号appId
     */
    private String appId;
    /**
     * 公众号appSecret
     */
    private String appSecret;
    /**
     * 商户号
     */
    private String mchId;
    /**
     * 商户密钥key
     */
    private String mchKey;
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
