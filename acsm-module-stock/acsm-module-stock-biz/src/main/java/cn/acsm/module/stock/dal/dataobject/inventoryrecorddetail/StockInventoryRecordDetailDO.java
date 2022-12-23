package cn.acsm.module.stock.dal.dataobject.inventoryrecorddetail;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 盘点记录表子表-明细 DO
 *
 * @author 芋道源码
 */
@TableName("stock_inventory_record_detail")
@KeySequence("stock_inventory_record_detail_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockInventoryRecordDetailDO extends BaseDO {

    /**
     * 盘点记录明细id
     */
    @TableId
    private Long id;
    /**
     * 盘点记录id
     */
    private Long inventoryRecordId;
    /**
     * 盘点批次号
     */
    private String inventoryCode;
    /**
     * 库存记录明细id
     */
    private Long stockRecordDetailId;
    /**
     * 库存类型(1.原料 2.投入品 3.成品 4.办公用品)
     */
    private Integer type;
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
     * 包装规格id
     */
    private Long packagingSpecificationId;
    /**
     * 包装规格
     */
    private String packagingSpecification;
    /**
     * 包装规格名称
     */
    private String packagingSpecificationName;
    /**
     * 包装类型
     */
    private String packagingType;
    /**
     * 盘点前数量
     */
    private Integer inventoryFrontQuantity;
    /**
     * 盘点后数量
     */
    private Integer inventoryAfterQuantity;
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

}
