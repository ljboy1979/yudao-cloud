package cn.acsm.module.user.user.dal.dataobject.wechat;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 微信公众号配置信息 DO
 *
 * @author lihongyan
 */
@TableName("weixin_deploy_info")
@KeySequence("weixin_deploy_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeixinDeployInfoDO extends TenantBaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 公众号appId
     */
    private String appid;
    /**
     * 公众号appSecret
     */
    private String appsecret;
    /**
     * 商户号
     */
    private String mchId;
    /**
     * 商户密钥key
     */
    private String mchKey;
    /**
     * 标识
     */
    private String appletFlag;
    /**
     * 备注信息
     */
    private String remark;
    /**
     * 状态（0正常 1停用）
     */
    private Integer status;

}
