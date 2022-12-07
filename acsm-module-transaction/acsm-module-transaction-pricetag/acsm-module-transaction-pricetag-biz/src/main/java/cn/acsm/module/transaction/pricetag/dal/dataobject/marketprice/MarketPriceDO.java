package cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 市场价格 DO
 *
 * @author 芋道源码
 */
@TableName("pricetag_market_price")
@KeySequence("pricetag_market_price_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketPriceDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 编码
     */
    private String code;
    /**
     * 市场商品id
     */
    private String marketCommodityId;
    /**
     * 市场id
     */
    private String marketId;
    /**
     * 最高价
     */
    private Float maxPrice;
    /**
     * 最低价
     */
    private Float minPrice;
    /**
     * 平均价
     */
    private Float middlePrice;
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
