package cn.acsm.module.production.devices.dal.dataobject.time;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 设备运行时间 DO
 *
 * @author 芋道源码
 */
@TableName("devices_time")
@KeySequence("devices_time_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Integer id;
    /**
     * 设备id
     */
    private String deviceSn;
    /**
     * 是否在线(0-否1-是)
     */
    private String online;
    /**
     * 在线/离线时间
     */
    private Date devicesDate;
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
