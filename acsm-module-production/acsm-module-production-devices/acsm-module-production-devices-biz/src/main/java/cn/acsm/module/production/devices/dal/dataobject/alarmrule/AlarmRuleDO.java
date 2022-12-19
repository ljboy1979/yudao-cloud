package cn.acsm.module.production.devices.dal.dataobject.alarmrule;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 告警规则 DO
 *
 * @author 芋道源码
 */
@TableName("devices_alarm_rule")
@KeySequence("devices_alarm_rule_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlarmRuleDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 设备id
     */
    private String deviceId;
    /**
     * 告警参数id
     */
    private String paramId;
    /**
     * 告警类型
     */
    private String alarmType;
    /**
     * 告警上限
     */
    private BigDecimal alarmUp;
    /**
     * 告警下限
     */
    private BigDecimal alarmDown;
    /**
     * 告警内容
     */
    private String alarmContent;
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
     * 告警参数名称
     */
    private String paramName;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
