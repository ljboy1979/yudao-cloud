package cn.acsm.module.transaction.order.dal.dataobject.sartinfo;

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
 * 购物车 DO
 *
 * @author 芋道源码
 */
@TableName("order_sart_info")
@KeySequence("order_sart_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SartInfoDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 货架id
     */
    private String shelvesId;
    /**
     * 货架名称
     */
    private String shelvesName;
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
     * 餐次（1早 2中 3晚）
     */
    private String mealsTime;
    /**
     * 购买数量
     */
    private String num;
    /**
     * 订购日期(例：2021-12-13)
     */
    private String reserveDate;
    /**
     * 付款状态 0 未付款  1 已付款 2 已退款
     */
    private String payStatus;
    /**
     * 套餐状态（默认 0未付款 1已取消 2已锁定 3已完成）
     */
    private String planStatus;
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
     * 价格
     */
    private BigDecimal price;
    /**
     * 来源
     */
    private String source;
    /**
     * 赠品编号
     */
    private String giftNumber;
    /**
     * 是否为赠品（0-否，1-是）
     */
    private String giftStatus;
    /**
     * 已退金额
     */
    private BigDecimal refundPrice;
    /**
     * 付款状态 0 未申请退款  1 已申请全额退 2 已申请部分退款
     */
    private String refundStatus;
    /**
     * 选中状态 1默认选中（0-否，1-是）
     */
    private String selectedStatus;
    /**
     * 经营主体id
     */
    private String subjectId;
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
     * 单价
     */
    private BigDecimal unitPrice;
    /**
     * 处理规格
     */
    private String processTagName;
    /**
     * 状态
     */
    private Integer status;

}
