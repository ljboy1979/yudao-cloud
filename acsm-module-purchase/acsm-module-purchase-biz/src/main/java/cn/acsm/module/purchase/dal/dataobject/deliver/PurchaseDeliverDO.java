package cn.acsm.module.purchase.dal.dataobject.deliver;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购交付 DO
 *
 * @author 芋道源码
 */
@TableName("purchase_deliver")
@KeySequence("purchase_deliver_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDeliverDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;

    /**
     * 采购单编号
     */
    private Long purchaseId;

    /**
     * 采购单号
     */
    private String purchaseNumber;

    /**
     * 采购单明细id
     */
    private Long purchaseDetailsId;

    /**
     * 交付批次号(系统自动生成)
     */
    private String batchCode;

    /**
     * 期望交付时间
     */
    private Date expectedDeliveryTime;

    /**
     * 实际交付时间
     */
    private Date actualDelivery;

    /**
     * 期望交付数量
     */
    private Double expectedDeliveryCount;

    /**
     * 实际交付数量
     */
    private Double actualDeliveryCount;

    /**
     * 单位(字典id)
     */
    private Long companyId;

    /**
     * 结算时间
     */
    private Date settlementTime;

    /**
     * 结算金额
     */
    private BigDecimal settlementAmount;

    /**
     * 1.未交付 2.已交付
     */
    private String deliveryStatus;

    /**
     * 发货单号
     */
    private String shipmentNo;

    /**
     * 经营主体
     */
    private String subjectId;

    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 租户集合
     */
    private Long sourceId;

}
