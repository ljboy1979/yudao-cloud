package cn.acsm.module.production.facility.dal.dataobject.maintenance;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 设施维护记录 DO
 *
 * @author 芋道源码
 */
@TableName("facility_maintenance")
@KeySequence("facility_maintenance_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 设施id
     */
    private String facilitysId;
    /**
     * 维护操作人
     */
    private String operateName;
    /**
     * 维护时间
     */
    private Date operateTime;
    /**
     * 耗时
     */
    private String timeConsuming;
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
     * 备注信息
     */
    private String remarks;
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
