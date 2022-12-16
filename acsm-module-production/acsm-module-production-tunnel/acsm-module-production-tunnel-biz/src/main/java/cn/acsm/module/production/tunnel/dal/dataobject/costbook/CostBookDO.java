package cn.acsm.module.production.tunnel.dal.dataobject.costbook;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 地块账本 DO
 *
 * @author 芋道源码
 */
@TableName("tunnel_cost_book")
@KeySequence("tunnel_cost_book_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CostBookDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 编号
     */
    private String costCode;
    /**
     * 来源
     */
    private String costSource;
    /**
     * 主体
     */
    private String entityId;
    /**
     * 类型(0支出,1收入)
     */
    private String costType;
    /**
     * 单据名称
     */
    private String accountName;
    /**
     * 账目内容
     */
    private String accountInfo;
    /**
     * 账目金额
     */
    private BigDecimal accountAmount;
    /**
     * 时间
     */
    private Date accountTime;
    /**
     * 地点
     */
    private String accountLocation;
    /**
     * 记账时间
     */
    private Date accountingTime;
    /**
     * 详情
     */
    private String remarks;
    /**
     * 计数器
     */
    private Integer counter;
    /**
     * 机构编码
     */
    private String officeCode;
    /**
     * 机构名称
     */
    private String officeName;
    /**
     * 公司编码
     */
    private String companyCode;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 审核状态
     */
    private String reviewStatus;
    /**
     * 审核人
     */
    private String reviewer;
    /**
     * 审核时间
     */
    private Date reviewDate;
    /**
     * 审核内容
     */
    private String reviewContent;
    /**
     * 租户代码
     */
    private String corpCode;
    /**
     * 租户名称
     */
    private String corpName;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
