package cn.iocoder.yudao.module.transaction.sales.dal.mysql.commodityspecification;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 商品规格 DO
 *
 * @author 芋道源码
 */
@TableName("sales_commodity_specification")
@KeySequence("sales_commodity_specification_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommoditySpecificationDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 商品id
     */
    private String commodityId;
    /**
     * 规格名称
     */
    private String specificationsName;
    /**
     * 包装类型(0定装1散装)
     */
    private String packagingType;
    /**
     * 规格数量
     */
    private String number;
    /**
     * 单位
     */
    private String unit;
    /**
     * 包装单位
     */
    private String packaging;
    /**
     * 计量单位
     */
    private String measurementUnit;
    /**
     * 采购价
     */
    private BigDecimal purchasePrice;
    /**
     * 售出价
     */
    private BigDecimal sellingPrice;
    /**
     * 备注
     */
    private String remark;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 经营主体id
     */
    private String subjectId;
    /**
     * source
     */
    private String source;

}
