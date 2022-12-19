package cn.acsm.module.production.bases.dal.dataobject.subsidy;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 基地补贴信息 DO
 *
 * @author 芋道源码
 */
@TableName("bases_subsidy")
@KeySequence("bases_subsidy_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubsidyDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 基地
     */
    private String basesId;
    /**
     * 金融服务
     */
    private String financialId;
    /**
     * 时间
     */
    private Date insertTime;
    /**
     * 金额
     */
    private Double money;
    /**
     * 面积
     */
    private Double muNumber;
    /**
     * 补贴类型
     */
    private String subsidyType;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 机构编码
     */
    private String officeCode;
    /**
     * 机构名称
     */
    private String officeName;
    /**
     * 公司编码
     */
    private String companyCode;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 审核状态
     */
    private String reviewStatus;
    /**
     * 审核人
     */
    private String reviewer;
    /**
     * 审核时间
     */
    private Date reviewDate;
    /**
     * 审核内容
     */
    private String reviewContent;
    /**
     * 租户代码
     */
    private String corpCode;
    /**
     * 租户名称
     */
    private String corpName;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
