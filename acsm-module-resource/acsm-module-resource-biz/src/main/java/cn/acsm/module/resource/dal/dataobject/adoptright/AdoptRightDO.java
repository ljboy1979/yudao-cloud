package cn.acsm.module.resource.dal.dataobject.adoptright;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 认养/租凭权益 DO
 *
 * @author smile
 */
@TableName("resource_adopt_right")
@KeySequence("resource_adopt_right_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdoptRightDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 权益类型
     */
    private String rightType;
    /**
     * 权益描述
     */
    private String rightDescription;
    /**
     * 认养时间
     */
    private Date adoptTime;
    /**
     * 认养物编号
     */
    private String adoptContentNum;
    /**
     * 收入项：收入金额：收入比例
     */
    private String incomeItemAmountScale;
    /**
     * 收入有效日期
     */
    private Date incomeEffectiveDate;
    /**
     * 租用人标签
     */
    private String leasePersonFlag;
    /**
     * 权益价格的id
     */
    private String adoptRightId;
    /**
     * 金额
     */
    private String price;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 项目来源
     */
    private String source;
    /**
     * 经营主体id
     */
    private String subjectId;

}
