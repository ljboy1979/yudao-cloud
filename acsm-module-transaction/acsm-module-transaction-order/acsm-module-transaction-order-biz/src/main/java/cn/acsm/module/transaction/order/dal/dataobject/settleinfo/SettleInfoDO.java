package cn.acsm.module.transaction.order.dal.dataobject.settleinfo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 订单结账 DO
 *
 * @author 芋道源码
 */
@TableName("order_settle_info")
@KeySequence("order_settle_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SettleInfoDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 结账金额
     */
    private BigDecimal settlePrice;
    /**
     * 实付金额
     */
    private BigDecimal actualPrice;
    /**
     * 支付方式 0 对公转账  
     */
    private String payType;
    /**
     * 支付凭证
     */
    private String img;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 结账时间
     */
    private Date settleTime;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 经营主体id
     */
    private String subjectId;
    /**
     * source
     */
    private String source;

}
