package cn.acsm.module.service.dal.dataobject.serviceorder;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 服务交易单 DO
 *
 * @author smile
 */
@TableName("service_service_order")
@KeySequence("service_service_order_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceOrderDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 交易单号
     */
    private String transactionNumber;
    /**
     * 服务用户id
     */
    private String serviceUserId;
    /**
     * 手机号
     */
    private String cellphoneNumber;
    /**
     * 下单时间
     */
    private Date orderTime;
    /**
     * 交易总额
     */
    private String totalAmount;
    /**
     * 服务id
     */
    private String serviceId;
    /**
     * 服务权益id
     */
    private String serviceEquitiesId;
    /**
     * 参与人数
     */
    private String participation;
    /**
     * 服务费
     */
    private String serviceCharge;
    /**
     * 交易单状态:  0，待付款,1、待使用,2、已完成,3、已失效,4、已取消,5、退款中,6、已退款,7、已核销
     */
    private String orderStatus;
    /**
     * 服务权益id
     */
    private String servicePriceId;
    /**
     * 下单人
     */
    private String systemUserId;
    /**
     * 认养物的id
     */
    private String carrierId;
    /**
     * 订阅地区
     */
    private String areaCode;
    /**
     * 订单类型(0 农事订单,1 认购订单)
     */
    private String orderType;
    /**
     * 套票id
     */
    private String ticketPackageId;
    /**
     * 支付方式(0.现金 1.套票)
     */
    private String payType;
    /**
     * 活动场次id
     */
    private String activitySessionId;
    /**
     * 家庭成员id
     */
    private String farmFamilyId;
    /**
     * 微信支付系统订单号
     */
    private String weixinOrderId;
    /**
     * 兑换码
     */
    private String exchangeCode;
    /**
     * 核销操作人
     */
    private String scanOperator;
    /**
     * 核销时间
     */
    private Date scanDate;
    /**
     * 有效期
     */
    private Date expiryDate;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 项目来源
     */
    private String source;

}
