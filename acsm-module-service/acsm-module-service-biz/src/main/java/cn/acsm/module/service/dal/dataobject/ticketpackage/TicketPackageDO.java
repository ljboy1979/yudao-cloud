package cn.acsm.module.service.dal.dataobject.ticketpackage;

import cn.iocoder.yudao.module.system.api.dict.dto.DictDataRespDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 套票 DO
 *
 * @author smile
 */
@TableName("service_ticket_package")
@KeySequence("service_ticket_package_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketPackageDO extends BaseDO {

    /**
     * 套票编号
     */
    @TableId
    private Long id;
    /**
     * 套票名称
     */
    private String packageName;
    /**
     * 套票种类
     */
    private String packageType;
    /**
     * 购买人
     */
    private String purchaser;
    /**
     * 服务id
     */
    private String carrierId;
    /**
     * 使用次数
     */
    private Integer number;
    /**
     * 套票金额
     */
    private String packageMoney;
    /**
     * 使用期限
     */
    private Date serviceLife;
    /**
     * 授权人
     */
    private String certigier;
    /**
     * 套票状态(未开通/正常使用/过期/使用完毕)
     */
    private String packageStatus;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 封面
     */
    private String cover;
    /**
     * 内容
     */
    private String content;
    /**
     * 使用规则
     */
    private String regulation;
    /**
     *  使用期限说明
     */
    private String serviceLifeType;
    /**
     * 套票内容
     */
    private String packageContent;
    /**
     * 套票规则
     */
    private String packageRule;
    /**
     * 开始日期
     */
    private Date startDate;
    /**
     * 结束日期
     */
    private Date endDate;
    /**
     * 是否上架 0:已上架，1:未上架
     */
    private String ticketStatus;
    /**
     * 使用年限周期
     */
    private String timeNum;
    /**
     * 使用年限类型 0固定1不固定
     */
    private String timeType;
    /**
     * 使用年限频次 0年1月
     */
    private String timeLimitMode;
    /**
     * 套票场景0活动1商品
     */
    private String ticketType;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 项目来源
     */
    private String source;


}
