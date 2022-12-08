package cn.acsm.module.transaction.order.dal.dataobject.reservedetails;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 订单预定详情 DO
 *
 * @author 芋道源码
 */
@TableName("order_reserve_details")
@KeySequence("order_reserve_details_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReserveDetailsDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 预定id
     */
    private String reserveId;
    /**
     * 商品名称
     */
    private String commodityName;
    /**
     * 规格名称
     */
    private String specificationName;
    /**
     * 购买数量
     */
    private String num;
    /**
     * 市场价格
     */
    private String marketPrice;
    /**
     * 经营主体id
     */
    private String subjectId;
    /**
     * 套餐状态（默认 0未付款 1已取消 2已锁定）
     */
    private String planStatus;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 来源
     */
    private String source;
    /**
     * 捕捞商品id
     */
    private String osCommodityFishingId;
    /**
     * 捕捞规格id
     */
    private String productSpecificationsFishingId;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 配送方式 0包邮 1不包邮
     */
    private String sendType;
    /**
     * 状态
     */
    private Integer status;

}
