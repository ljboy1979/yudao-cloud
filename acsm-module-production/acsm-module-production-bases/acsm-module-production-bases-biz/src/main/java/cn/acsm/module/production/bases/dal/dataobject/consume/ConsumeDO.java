package cn.acsm.module.production.bases.dal.dataobject.consume;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 基地能耗信息 DO
 *
 * @author 芋道源码
 */
@TableName("bases_consume")
@KeySequence("bases_consume_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsumeDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 基地id
     */
    private String basesId;
    /**
     * 消耗量
     */
    private Double consumeNum;
    /**
     * 单位
     */
    private String unit;
    /**
     * 创建日期
     */
    private Date insertTime;
    /**
     * 消耗类型1电2水3气
     */
    private String consumeType;
    /**
     * 项目来源
     */
    private String source;
    /**
     * 状态（0正常 1删除 2停用）
     */
    private String status;
    /**
     * 备注信息
     */
    private String remarks;
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
     * 参数名称
     */
    private String paramName;
    /**
     * 参数单位
     */
    private String paramUnit;
    /**
     * 参数值
     */
    private BigDecimal num;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
