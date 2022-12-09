package cn.acsm.module.service.dal.dataobject.ticketdetail;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 套票详情 DO
 *
 * @author smile
 */
@TableName("service_ticket_detail")
@KeySequence("service_ticket_detail_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketDetailDO extends BaseDO {

    /**
     * 套票编号
     */
    @TableId
    private Long id;
    /**
     * 套票id
     */
    private String ticketId;
    /**
     * 商品id
     */
    private String skuId;
    /**
     * 每次兑换数量
     */
    private Integer useNumber;
    /**
     * 兑换频次 0 年 1月 
     */
    private Integer useRate;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 项目来源
     */
    private String source;

}
