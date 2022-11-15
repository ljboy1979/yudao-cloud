package cn.acsm.module.member.signin.dal.dataobject.auth;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 会员授权登录信息记录 DO
 *
 * @author lihongyan
 */
@TableName("member_auth_login_info")
@KeySequence("member_auth_login_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthLoginInfoDO extends TenantBaseDO {

    /**
     * 用基本信息表ID
     */
    @TableId
    private Long id;
    /**
     * openid
     */
    private String openId;
    /**
     * 用户手机号
     */
    private String phone;
    /**
     * 会员id
     */
    private String memberId;
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
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
