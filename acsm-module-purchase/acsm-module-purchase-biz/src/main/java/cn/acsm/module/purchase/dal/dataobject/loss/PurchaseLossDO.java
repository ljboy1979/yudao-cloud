package cn.acsm.module.purchase.dal.dataobject.loss;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

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
    private Long orderId;
    /**
     * 采购单号
     */
    private String orderNo;
    /**
     * 货单id
     */
    private Long goodsId;
    /**
     * 货单单号
     */
    private String goodsNo;
    /**
     * 货电子表-明细id
     */
    private Long electronicBillOfGoodsId;
    /**
     * 货架id
     */
    private Long goodsShelvesId;
    /**
     * 货架号
     */
    private String goodsShelvesNo;
    /**
     * 货品名称
     */
    private String goodsName;
    /**
     * 包装规格
     */
    private String packingSpecifications;
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
     * 报损人id
     */
    private Long lossReporterId;
    /**
     * 报损人姓名
     */
    private String lossReporterName;
    /**
     * 报损时间
     */
    private Date lossReporterTime;
    /**
     * 库存记录id
     */
    private Long inventoryRecordsId;
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

}
