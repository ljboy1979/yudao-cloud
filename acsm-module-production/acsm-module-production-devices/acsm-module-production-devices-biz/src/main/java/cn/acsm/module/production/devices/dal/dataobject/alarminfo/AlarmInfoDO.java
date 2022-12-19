package cn.acsm.module.production.devices.dal.dataobject.alarminfo;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 告警信息 DO
 *
 * @author 芋道源码
 */
@TableName("devices_alarm_info")
@KeySequence("devices_alarm_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlarmInfoDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 编号
     */
    private Integer number;
    /**
     * 告警类型
     */
    private String alarmType;
    /**
     * 告警来源
     */
    private String alarmSource;
    /**
     * 告警内容
     */
    private String alarmContent;
    /**
     * 发生时间
     */
    private Date happenDate;
    /**
     * 发生地点
     */
    private String happenPlace;
    /**
     * 通知人(多个逗号隔开)
     */
    private String notifiers;
    /**
     * 处理状态(0-待处理 1-已处理)
     */
    private String handleStatus;
    /**
     * 处理描述
     */
    private String handleContent;
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
     * 设备id
     */
    private String devicesId;
    /**
     * 设备名称
     */
    private String deviceName;
    /**
     * 设备编号
     */
    private String deviceSn;
    /**
     * 养殖户名称
     */
    private String subjectName;
    /**
     * 静默小时
     */
    private Integer silenceHour;
    /**
     * 静默截止期
     */
    private Date silenceExpiry;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
