package cn.acsm.module.transaction.pricetag.dal.dataobject.scheduledprice;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 预定价格 DO
 *
 * @author 芋道源码
 */
@TableName("pricetag_scheduled_price")
@KeySequence("pricetag_scheduled_price_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduledPriceDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
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
     * 不包邮预定价
     */
    private BigDecimal freeShippingPrice;
    /**
     * 包邮预定价
     */
    private BigDecimal shippingPrice;
    /**
     * 有效期
     */
    private Date expirationDate;
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
