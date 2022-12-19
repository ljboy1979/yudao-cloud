package cn.acsm.module.production.bases.dal.dataobject.phenologicalenv;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 基地物候环境 DO
 *
 * @author 芋道源码
 */
@TableName("bases_phenological_env")
@KeySequence("bases_phenological_env_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhenologicalEnvDO extends BaseDO {

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
     * 设备
     */
    private String devicesId;
    /**
     * 测试者
     */
    private String tester;
    /**
     * 测试时间
     */
    private Date testTime;
    /**
     * 时间
     */
    private Date insertTime;
    /**
     * 光照强度
     */
    private Double lightIntensity;
    /**
     * 地貌类型
     */
    private String geomorphicType;
    /**
     * 地形部位
     */
    private String landform;
    /**
     * 地面坡度
     */
    private Double groundSlope;
    /**
     * 坡向
     */
    private String slopeDirection;
    /**
     * 常年有效积温
     */
    private Double effectiveTemperature;
    /**
     * 常年无霜期
     */
    private Double frostFreePeriod;
    /**
     * 30年最低温度天数
     */
    private Integer minTemperatureDays;
    /**
     * 30年最高温度天数
     */
    private Integer maxTemperatureDays;
    /**
     * 典型种植制度
     */
    private String typicalCropSystem;
    /**
     * 熟制
     */
    private String maturationSystem;
    /**
     * 常年产量水平
     */
    private Double annualYieldLevel;
    /**
     * 农田基础设施
     */
    private String farmlandInfrastructure;
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
     * 海拔
     */
    private Double altitude;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
