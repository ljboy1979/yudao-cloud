package cn.acsm.module.member.user.dal.dataobject.integral;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 会员积分规则 DO
 *
 * @author lihongyan
 */
@TableName("member_integral_rules")
@KeySequence("member_integral_rules_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IntegralRulesDO extends TenantBaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 企业id
     */
    private Long enterpriseId;
    /**
     * 企业名称
     */
    private String enterpriseName;
    /**
     * 上级项目
     */
    private Long parentLevelProject;
    /**
     * 评分项目
     */
    private Long ratingItems;
    /**
     * 数值范围
     */
    private String rangeValues;
    /**
     * 积分值
     */
    private String integralValue;
    /**
     * 备注
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
