package cn.acsm.module.stock.dal.dataobject.inventoryrecord;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 盘点记录 DO
 *
 * @author 芋道源码
 */
@TableName("stock_inventory_record")
@KeySequence("stock_inventory_record_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockInventoryRecordDO extends BaseDO {

    /**
     * 盘点记录id
     */
    @TableId
    private Long id;
    /**
     * 库存类型(1.原料 2.投入品 3.成品 4.办公用品)
     */
    private Integer type;
    /**
     * 仓库id
     */
    private String warehouseId;
    /**
     * 仓库编号
     */
    private String warehouseCode;
    /**
     * 仓库名称
     */
    private String warehouseName;
    /**
     * 盘点批次
     */
    private String inventoryCode;
    /**
     * 操作时间
     */
    private Date operationTime;
    /**
     * 负责人id
     */
    private Long headId;
    /**
     * 负责人名称
     */
    private String headName;
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
