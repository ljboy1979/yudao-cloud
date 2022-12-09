package cn.acsm.module.service.dal.dataobject.activitysession;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 时间排期 DO
 *
 * @author smile
 */
@TableName("service_activity_session")
@KeySequence("service_activity_session_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivitySessionDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 最多参与人数
     */
    private String maxAttendPeople;
    /**
     * 实际参与人数
     */
    private String attendPeople;
    /**
     * 活动报名费用
     */
    private String registrationFee;
    /**
     * 活动id
     */
    private String activityId;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 服务id
     */
    private String serviceId;
    /**
     * 开始日期
     */
    private String startDate;
    /**
     * 结束日期
     */
    private Date endDate;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 基地id
     */
    private String basesId;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 项目来源
     */
    private String source;

}
