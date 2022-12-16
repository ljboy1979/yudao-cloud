package cn.acsm.module.production.tunnel.dal.dataobject.infosoilenv;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 地块土壤环境 DO
 *
 * @author 芋道源码
 */
@TableName("tunnel_info_soil_env")
@KeySequence("tunnel_info_soil_env_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfoSoilEnvDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 地块id
     */
    private String tunnelId;
    /**
     * 设备
     */
    private String equipId;
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
     * 平均土壤含水量
     */
    private String avgSoilWater;
    /**
     * 土类
     */
    private String soilType;
    /**
     * 亚类
     */
    private String subType;
    /**
     * 土属
     */
    private String soilGenus;
    /**
     * 土种
     */
    private String soilSpecies;
    /**
     * 俗名
     */
    private String commonName;
    /**
     * 成土母质
     */
    private String soilParentMaterial;
    /**
     * 剖面构型
     */
    private String profilePattern;
    /**
     * 质地
     */
    private String texture;
    /**
     * 土壤结构
     */
    private String soilStructure;
    /**
     * 障碍因素
     */
    private String obstacleFactors;
    /**
     * 侵蚀程度
     */
    private String erosionDegree;
    /**
     * 耕层厚度
     */
    private String topsoilDepth;
    /**
     * 采样深度
     */
    private String samplingDepth;
    /**
     * 取样层次1
     */
    private String samplingLevelFirst;
    /**
     * 质地1
     */
    private String textureFirst;
    /**
     * pH1
     */
    private String phFirst;
    /**
     * 有机质1
     */
    private String organicMatterFirst;
    /**
     * 碱解氮1
     */
    private String availableNitrogenFirst;
    /**
     * 有效磷1
     */
    private String effectivePhosphorusFirst;
    /**
     * 全钾1
     */
    private String totalPotassiumFirst;
    /**
     * 缓效钾1
     */
    private String slowEffectPotassiumFirst;
    /**
     * 速效钾1
     */
    private String availablePotassiumFirst;
    /**
     * 全氮
     */
    private String totalNitrogen;
    /**
     * 项目标识
     */
    private String source;
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
     * 经营主体ID
     */
    private Long subjectId;

}
