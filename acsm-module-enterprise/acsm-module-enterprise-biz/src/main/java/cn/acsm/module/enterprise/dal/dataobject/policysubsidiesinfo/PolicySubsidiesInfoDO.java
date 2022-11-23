package cn.acsm.module.enterprise.dal.dataobject.policysubsidiesinfo;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 企业政策补贴信息 DO
 *
 * @author 芋道源码
 */
@TableName("enterprise_policy_subsidies_info")
@KeySequence("enterprise_policy_subsidies_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicySubsidiesInfoDO extends TenantBaseDO {

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
     * 补贴种类
     *
     * 枚举 {@link TODO subsidies_category 对应的类}
     */
    private String subsidiesCategory;
    /**
     * 补贴名称
     */
    private String subsidiesName;
    /**
     * 补贴金额
     */
    private BigDecimal subsidiesAmount;
    /**
     * 补贴方式
     *
     * 枚举 {@link TODO subsidies_type 对应的类}
     */
    private String subsidiesType;
    /**
     * 补贴状态
     *
     * 枚举 {@link TODO subsidies_status 对应的类}
     */
    private Integer subsidiesStatus;
    /**
     * 申请人
     */
    private String applyPerson;
    /**
     * 申请时间
     */
    private Date applyTime;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
