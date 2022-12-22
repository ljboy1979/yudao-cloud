package cn.acsm.module.purchase.dal.dataobject.loss;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 损耗 DO
 *
 * @author 芋道源码
 */
@TableName("purchase_loss")
@KeySequence("purchase_loss_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseLossDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 采购单id
     */
    private Long purchaseId;
    /**
     * 采购单号
     */
    private String purchaseNumber;
    /**
     * 货品编号
     */
    private Long goodsId;
    /**
     * 货单电子表-明细id
     */
    private Long electronicBillOfGoodsId;
    /**
     * 货架编号
     */
    private Long goodSkuId;
    /**
     * 货品名称
     */
    private String goodsName;
    /**
     * 包装规格
     */
    private String packingSpecification;
    /**
     * 规格单位
     */
    private String specificationUnit;
    /**
     * 损耗数量
     */
    private Integer lossCount;
    /**
     * 损耗重量
     */
    private Integer lossWeight;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 报损人编号
     */
    private Long managerId;
    /**
     * 报损人姓名
     */
    private String manager;
    /**
     * 报损时间
     */
    private Date time;
    /**
     * 库存记录编号
     */
    private Long stockId;
    /**
     * 入库批次号
     */
    private String receiptBatchNo;
    /**
     * 库存记录明细id
     */
    private Long inventoryRecordDetailsId;
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
