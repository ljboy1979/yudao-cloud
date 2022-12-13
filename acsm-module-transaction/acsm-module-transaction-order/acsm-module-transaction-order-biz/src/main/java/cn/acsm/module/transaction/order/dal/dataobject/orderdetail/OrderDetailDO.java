package cn.acsm.module.transaction.order.dal.dataobject.orderdetail;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 订单详情 DO
 *
 * @author 芋道源码
 */
@TableName("order_detail")
@KeySequence("order_detail_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDO extends BaseDO {

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
     * 订单id
     */
    private String orderId;
    /**
     * 计划id
     */
    private String planId;
    /**
     * 货架id
     */
    private String shelvesId;
    /**
     * 货架名称
     */
    private String shelvesName;
    /**
     * 规格id
     */
    private String specificationId;
    /**
     * 规格名称
     */
    private String specificationName;
    /**
     * 计量单位
     */
    private String measureUnit;
    /**
     * 预定的用户
     */
    private String userId;
    /**
     *  餐次（1早 2中 3晚）
     */
    private String mealsTime;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
    /**
     * 购买量
     */
    private BigDecimal num;
    /**
     * 总价
     */
    private BigDecimal totalPrice;
    /**
     * 收货单价
     */
    private BigDecimal takeUnitPrice;
    /**
     * 收货数量
     */
    private String takeNum;
    /**
     * 收货金额
     */
    private BigDecimal takePrice;
    /**
     * 退补说明
     */
    private String priceSpreadExplain;
    /**
     * 退补差价
     */
    private BigDecimal priceSpread;
    /**
     * 付款状态 0 未付款  1 已付款  2退款
     */
    private String payStatus;
    /**
     * 配送状态 默认状态0待配送 1已配送
     */
    private String sendStatus;
    /**
     * 配送时间
     */
    private Date deliveryTime;
    /**
     * 处理规格
     */
    private String processTagName;
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
