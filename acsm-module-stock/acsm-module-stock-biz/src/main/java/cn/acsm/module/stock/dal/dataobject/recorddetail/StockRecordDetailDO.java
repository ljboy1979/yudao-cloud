package cn.acsm.module.stock.dal.dataobject.recorddetail;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 库存记录字表-明细 DO
 *
 * @author 芋道源码
 */
@TableName("stock_record_detail")
@KeySequence("stock_record_detail_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockRecordDetailDO extends BaseDO {

    /**
     * 库存记录明细id
     */
    @TableId
    private Long id;
    /**
     * 库存记录id
     */
    private Long recordId;
    /**
     * 库存批次号
     */
    private String stockBatchNo;
    /**
     * 操作类型(0.入库 1.出库)
     */
    private Boolean operationType;
    /**
     * 二级分类(成品类：套餐/商品/特医食品)
     */
    private String secondaryClassification;
    /**
     * 货品id
     */
    private String goodsId;
    /**
     * 货品编号
     */
    private String goodsNumber;
    /**
     * 货品名称
     */
    private String goodsName;
    /**
     * 货品类型
     */
    private String goodsType;
    /**
     * 包装类型
     */
    private String packagingType;
    /**
     * 包装规格
     */
    private String packingSpecification;
    /**
     * 入库数量
     */
    private Integer receiptQuantity;
    /**
     * 现有库存量
     */
    private Integer existingInventory;
    /**
     * 出库数量
     */
    private Integer deliveryQuantity;
    /**
     * 库存记录明细id(只出库类型才有值-对应入库记录)
     */
    private Long recordDetailId;
    /**
     * 货位id
     */
    private Long goodsAllocationId;
    /**
     * 货位号
     */
    private String goodsAllocationNo;
    /**
     * 来源/去向说明
     */
    private String sourceTo;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
    /**
     * 优惠
     */
    private BigDecimal discountPrice;
    /**
     * 计量单位
     */
    private String unit;
    /**
     * 合计总价
     */
    private BigDecimal totalPrice;
    /**
     * 付款方式(0.微信 1.银联 2.支付宝 3.现金)
     */
    private String payMethod;
    /**
     * 生产批次号
     */
    private String productionBatchNo;
    /**
     * 基地
     */
    private String bases;
    /**
     * 地块
     */
    private String tunnel;
    /**
     * 入库来源
     */
    private String treasurySource;
    /**
     * 采收记录id
     */
    private String harvestBatchId;
    /**
     * 采购单id
     */
    private Long purchaseId;
    /**
     * 采购单号
     */
    private String purchaseNumber;
    /**
     * 加工单id
     */
    private Long processingOrderId;
    /**
     * 称重记录id
     */
    private Long weighingRecordId;
    /**
     * 包装单id
     */
    private Long packingListId;
    /**
     * 临时时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date temporaryTime;
    /**
     * 0.冷藏 1.冷冻 2.常温 3.保鲜 4.其他
     */
    private String environmentalRequirements;
    /**
     * 经营主体
     */
    private String subjectId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 租户集合
     */
    private Long sourceId;

    /**
     * 公司id
     */
    private String companyId;

    /**
     * 所属部门id
     */
    private String departmentId;

}
