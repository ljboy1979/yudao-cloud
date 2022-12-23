package cn.acsm.module.stock.dal.dataobject.inventory;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 库存清单 DO
 *
 * @author 芋道源码
 */
@TableName("stock_inventory")
@KeySequence("stock_inventory_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockInventoryDO extends BaseDO {

    /**
     * 库存清单id
     */
    @TableId(type = IdType.INPUT)
    private String id;
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
     * 仓库类型
     */
    private Integer warehouseType;
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
     * 包装规格id
     */
    private String packagingSpecificationId;
    /**
     * 包装规格
     */
    private String packingSpecification;
    /**
     * 库存数量
     */
    private Integer inventoryQuantity;
    /**
     * 计量单位
     */
    private String measureUnit;
    /**
     * 预警数量上线
     */
    private Integer upperWarningLimit;
    /**
     * 预警数量下线
     */
    private Integer lowerWarningLimit;
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
