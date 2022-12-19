package cn.acsm.module.production.bases.dal.dataobject.partitions;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 分区信息 DO
 *
 * @author 芋道源码
 */
@TableName("bases_partitions")
@KeySequence("bases_partitions_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartitionsDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 基地
     */
    private String baseId;
    /**
     * 名称
     */
    private String name;
    /**
     * 面积
     */
    private Float muNumber;
    /**
     * 展示颜色
     */
    private String viewColor;
    /**
     * 边框颜色
     */
    private String borderColor;
    /**
     * 透明度
     */
    private Integer opacity;
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 纬度
     */
    private BigDecimal latitude;
    /**
     * 边界范围
     */
    private String coordinateGroup;
    /**
     * 百度维度
     */
    private Double bdLatitude;
    /**
     * 百度经度
     */
    private Double bdLongitude;
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
     * 备注信息
     */
    private String remarks;
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
     * 同步状态1已同步
     */
    private String syncStatus;
    /**
     * 1.0id
     */
    private Integer oldId;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
