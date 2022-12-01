package cn.acsm.module.member.user.dal.dataobject.integral;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 会员积分记录 DO
 *
 * @author lihongyan
 */
@TableName("member_integral_record")
@KeySequence("member_integral_record_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IntegralRecordDO extends TenantBaseDO {

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
     * 会员账号
     */
    private String memberAccount;
    /**
     * 会员名称
     */
    private String memberName;
    /**
     * 评分项目
     */
    private Long ratingItems;
    /**
     * 本次积分变动
     */
    private String integralChange;
    /**
     * 当前剩余积分
     */
    private String integralRemaining;
    /**
     * 积分使用明细
     */
    private String integralUseDetails;
    /**
     * 积分变动时间
     */
    private Date integralChangeTime;
    /**
     * 图片
     */
    private String picture;
    /**
     * 备注
     */
    private String remark;
    /**
     * 评分分数
     */
    private  String ratingScore;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
