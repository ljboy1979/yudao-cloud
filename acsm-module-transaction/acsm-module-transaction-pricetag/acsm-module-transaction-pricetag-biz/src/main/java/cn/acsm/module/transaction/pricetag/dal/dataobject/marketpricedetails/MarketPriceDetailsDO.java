package cn.acsm.module.transaction.pricetag.dal.dataobject.marketpricedetails;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 市场价格明细 DO
 *
 * @author 芋道源码
 */
@TableName("pricetag_market_price_details")
@KeySequence("pricetag_market_price_details_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketPriceDetailsDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 市场价格id
     */
    private String marketPriceId;
    /**
     * 价格编号
     */
    private String priceCode;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 支付人
     */
    private String payer;
    /**
     * 0货架/1订单/2人工导入
     */
    private String priceSource;
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
