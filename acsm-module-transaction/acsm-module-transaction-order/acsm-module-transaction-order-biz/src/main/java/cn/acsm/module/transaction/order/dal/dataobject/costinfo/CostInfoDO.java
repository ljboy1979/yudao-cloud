package cn.acsm.module.transaction.order.dal.dataobject.costinfo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 费用 DO
 *
 * @author 芋道源码
 */
@TableName("order_cost_info")
@KeySequence("order_cost_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CostInfoDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 费用编号
     */
    private String costNumber;
    /**
     * 费用类型（0-团长返利、1-误差退款、2-其他费用）
     */
    private String costType;
    /**
     * 费用金额
     */
    private BigDecimal costAmount;
    /**
     * 订单id
     */
    private String skuPackageOrderId;
    /**
     * 备注
     */
    private String remark;
    /**
     * 支付状态（0-待支付，1-已支付）
     */
    private String payStatus;
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
