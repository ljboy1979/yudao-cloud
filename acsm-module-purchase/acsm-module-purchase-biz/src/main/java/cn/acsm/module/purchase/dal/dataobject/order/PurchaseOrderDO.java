package cn.acsm.module.purchase.dal.dataobject.order;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购单 DO
 *
 * @author 芋道源码
 */
@TableName("purchase_order")
@KeySequence("purchase_order_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 采购类型(0:原料 1:投入品 2:商品 3: 菜品 4:套餐 5:特医食品)
     */
    private String purchaseType;
    /**
     * 采购单号
     */
    private String purchaseNumber;
    /**
     * 供应商(用户id)
     */
    private Long providerId;
    /**
     * 供应商名称
     */
    private String providerName;
    /**
     * 供应商联系方式
     */
    private String providerPhone;
    /**
     * 采购时间
     */
    private Date purchaseTime;
    /**
     * 采购完成时间
     */
    private Date complateTime;
    /**
     * 采购总额（元）
     */
    private BigDecimal purchaseTotalAmount;
    /**
     * 结算方式1货到付款、2先款后货、3账期付款、4其他
     */
    private String settlementType;
    /**
     * 收款名称
     */
    private String beneficiaryName;
    /**
     * 开户行
     */
    private String bankDeposit;
    /**
     * 收款账号
     */
    private String collectionAccount;
    /**
     * 付款方式(0微信1银联2支付宝3现金)
     */
    private Integer payWay;
    /**
     * 采购人id
     */
    private String purchaserId;
    /**
     * 采购人姓名
     */
    private String purchaserName;
    /**
     * 采购部门id
     */
    private String purchaseOfficeId;
    /**
     * 采购部门名称
     */
    private String purchaseOfficeName;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String country;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 纬度
     */
    private BigDecimal latitude;
    /**
     * 基地id
     */
    private String basesId;
    /**
     * 地块id
     */
    private String tunnelId;
    /**
     * 采购状态(1.未开始 2.执行中 3.已完成 4.其他)
     */
    private Integer purchaseStatus;
    /**
     * 报价单id
     */
    private String quoteId;
    /**
     * 有效期
     */
    private String effectiveStage;
    /**
     * 采收批次号
     */
    private String batchCode;
    /**
     * 交易单号
     */
    private String transactionNumber;
    /**
     * 采购单来源(1:自主采购 2:主体采购 3:集单采购 4:报价单采购)
     */
    private String source;
    /**
     * 状态(1.待生效 2.有效 3.无效)
     */
    private String status;
    /**
     * 经营主体
     */
    private String subjectId;

    /**
     * 租户编号
     */
    private String tenantId;

    /**
     * 租户集合
     */
    private Long sourceId;

    /**
     * 用户id
     */
    private Long userId;

}
