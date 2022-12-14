package cn.acsm.module.purchase.dal.dataobject.details;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;

/**
 * 采购单明细 DO
 *
 * @author 芋道源码
 */
@TableName("purchase_details")
@KeySequence("purchase_details_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDetailsDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 采购单id
     */
    private Long orderId;
    /**
     * 采购单号
     */
    private String purchaseOrderNumber;
    /**
     * 货品id
     */
    private Long goodsId;
    /**
     * 货品名称
     */
    private String goodsName;
    /**
     * 包装规格id
     */
    private Long packagingSpecificationId;
    /**
     * 包装规格
     */
    private String packagingSpecification;
    /**
     * 计量单位
     */
    private String unitOfMeasurement;
    /**
     * 包装类型
     */
    private String packagingType;
    /**
     * 采购数量/重量
     */
    private BigDecimal purchaseQuantity;
    /**
     * 期望到货频次
     */
    private String expectedArrivalFrequency;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;
    /**
     * 采购金额
     */
    private BigDecimal purchaseAmount;
    /**
     * 货品id
     */
    private Long chargingStandard;
    /**
     * 经营主体
     */
    private String subjectId;

}
