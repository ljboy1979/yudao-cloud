package cn.acsm.module.transaction.order.dal.dataobject.reserveinfo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 预定订单 DO
 *
 * @author 芋道源码
 */
@TableName("order_reserve_info")
@KeySequence("order_reserve_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReserveInfoDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 预定id
     */
    private String planReserveId;
    /**
     * 预定的用户
     */
    private String userId;
    /**
     * 订金金额
     */
    private BigDecimal price;
    /**
     * 预订单总金额
     */
    private BigDecimal actualPrice;
    /**
     * 实付金额
     */
    private BigDecimal practicalPrice;
    /**
     * 支付方式 0 账单 1 微信  
     */
    private String payType;
    /**
     * 地址
     */
    private String address;
    /**
     * 预定备注
     */
    private String orderRemarks;
    /**
     * 经营主体id
     */
    private String subjectId;
    /**
     * 预定状态 0已预定 1已下单 2已过期 3已取消 4未付款 5已完成
     */
    private String payStatus;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 捕捞id 关联harvest_batch
     */
    private String harvestBatchId;
    /**
     * 来源
     */
    private String source;
    /**
     * 配送方式 0包邮 1不包邮
     */
    private String sendType;
    /**
     * 物流费用
     */
    private BigDecimal logisticsPrice;
    /**
     * 状态
     */
    private Integer status;

}
