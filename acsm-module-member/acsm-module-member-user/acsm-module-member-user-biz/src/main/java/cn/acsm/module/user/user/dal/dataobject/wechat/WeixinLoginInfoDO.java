package cn.acsm.module.user.user.dal.dataobject.wechat;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 微信登录信息记录 DO
 *
 * @author lihongyan
 */
@TableName("weixin_login_info")
@KeySequence("weixin_login_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeixinLoginInfoDO extends TenantBaseDO {

    /**
     * 用基本信息表ID
     */
    @TableId
    private Long id;
    /**
     * openid
     */
    private String openid;
    /**
     * 用户手机号
     */
    private String phone;
    /**
     * 系统的user_id
     */
    private String systemUserId;
    /**
     * 用户头像地址
     */
    private String avatar;
    /**
     * 省份名称
     */
    private String province;
    /**
     * 市名称
     */
    private String city;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 性别(0女，1男)
     */
    private String sex;
    /**
     * 类型 1-微信
     */
    private String type;
    /**
     * 状态（0正常 1停用）
     */
    private Integer status;

}
