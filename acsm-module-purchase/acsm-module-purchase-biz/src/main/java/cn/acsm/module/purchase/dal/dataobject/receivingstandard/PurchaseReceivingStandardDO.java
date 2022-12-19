package cn.acsm.module.purchase.dal.dataobject.receivingstandard;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 收货标准 DO
 *
 * @author 芋道源码
 */
@TableName("purchase_receiving_standard")
@KeySequence("purchase_receiving_standard_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseReceivingStandardDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 标准名称
     */
    private String name;
    /**
     * 范围上限
     */
    private BigDecimal upperLimit;
    /**
     * 范围下限
     */
    private BigDecimal lowerLimit;
    /**
     * 单位(字典id)
     */
    private String unit;
    /**
     * 经营主体
     */
    private String subjectId;

}
