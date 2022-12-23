package cn.acsm.module.transaction.pricetag.dal.dataobject.marketcommodity;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 市场商品 DO
 *
 * @author 芋道源码
 */
@TableName("pricetag_market_commodity")
@KeySequence("pricetag_market_commodity_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketCommodityDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 货架id
     */
    private String shelvesId;
    /**
     * 规格id
     */
    private String specificationId;
    /**
     * 分类id
     */
    private String classifyId;
    /**
     * 商品编号
     */
    private String commodityCode;
    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 市场id
     */
    private String marketId;

    /**
     * 市场名称
     */
    private String marketName;
    /**
     * 规格名称
     */
    private String specificationsName;
    /**
     * 包装类型(0定装1散装)
     */
    private String packagingType;
    /**
     * 包装类型名称
     */
    private String packagingTypeName;
    /**
     * 规格数量
     */
    private String number;
    /**
     * 单位
     */
    private String unit;
    /**
     * 单位名称
     */
    private String unitName;
    /**
     * 包装单位
     */
    private String packaging;
    /**
     * 包装单位名称
     */
    private String packagingName;
    /**
     * 计量单位
     */
    private String measurementUnit;
    /**
     * 计量单位名称
     */
    private String measurementUnitName;
    /**
     * 产地
     */
    private String productionAddress;
    /**
     * 来源
     */
    private String source;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 经营主体id
     */
    private String subjectId;

}
