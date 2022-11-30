package cn.acsm.module.member.user.dal.dataobject.member;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 会员信息 DO
 *
 * @author lihongyan
 */
@TableName("member_user_detail")
@KeySequence("member_user_detail_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberUserDetailDO extends BaseDO {

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
     * 企业id
     */
    private Long enterpriseId;
    /**
     * 企业名称
     */
    private String enterpriseName;
    /**
     * 会员类型
     */
    private Integer memberType;
    /**
     * 会员角色
     */
    private Integer memberRole;
    /**
     * 会员等级id
     */
    private Long integralLevelId;
    /**
     * 当前积分
     */
    private String integralRemaining;
    /**
     * 审核状态
     */
    private Integer auditStatus;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
