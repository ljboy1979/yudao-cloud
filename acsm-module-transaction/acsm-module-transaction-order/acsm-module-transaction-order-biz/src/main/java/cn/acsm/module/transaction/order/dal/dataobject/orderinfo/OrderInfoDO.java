package cn.acsm.module.transaction.order.dal.dataobject.orderinfo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 订单 DO
 *
 * @author 芋道源码
 */
@TableName("order_info")
@KeySequence("order_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfoDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 编码
     */
    private String code;
    /**
     * 货架id
     */
    private String shelvesId;
    /**
     * 计划id
     */
    private String planId;
    /**
     * 预定的用户
     */
    private String userId;
    /**
     * 餐次（1早 2中 3晚）
     */
    private String mealsTime;
    /**
     * 订单价格
     */
    private BigDecimal price;
    /**
     * 付款状态 0未付款 1进行中/付款 2已取消/退款 3已完成
     */
    private String payStatus;
    /**
     * 配送状态 默认状态0待配送 1已配送
     */
    private String sendStatus;
    /**
     * 配送号
     */
    private String sendNumber;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 实收金额
     */
    private BigDecimal actualPrice;
    /**
     * 支付方式 0 账单 1 微信  
     */
    private String payType;
    /**
     * 地址
     */
    private String address;
    /**
     * 订单备注 
     */
    private String orderRemarks;
    /**
     * 发票申请状态（0-待申请，1-申请中，2-已申请）
     */
    private String invoiceStatus;
    /**
     * 结账状态（0-未结账  1-已结账）
     */
    private String settleStatus;
    /**
     * 经营主体id
     */
    private String subjectId;
    /**
     * 调价说明
     */
    private String priceExplain;
    /**
     * 物流状态(0待确认，1备货中，2运输中，3已送达，4服务期结束，5已取消)
     */
    private String logisticsStatus;
    /**
     * 预计发货时间
     */
    private Date estimatedDeliveryTime;
    /**
     * 物流单号
     */
    private String ogisticsTicketNumber;
    /**
     * 物流公司
     */
    private String logisticsCompanies;
    /**
     * 取消订单原因
     */
    private String cause;
    /**
     * 订单类型 0普通订单 1预订订单 2批量采购订单
     */
    private String orderType;
    /**
     * 预订单id
     */
    private String skuPackageOrderReserveId;
    /**
     * 分配状态 0未分配 1已分配
     */
    private String allotStatus;
    /**
     * 采购方式 0单地址 1多地址
     */
    private String purchaseType;
    /**
     * 物流费用
     */
    private BigDecimal logisticsPrice;
    /**
     * 服务费用
     */
    private Double servicePrice;
    /**
     * 优惠金额
     */
    private BigDecimal preferentialPrice;
    /**
     * 退补差价
     */
    private BigDecimal spreadPrice;
    /**
     * 佣金
     */
    private BigDecimal commission;
    /**
     * 成交金额
     */
    private BigDecimal dealPrice;
    /**
     * 状态
     */
    private Integer status;
    /**
     * source
     */
    private String source;

}
