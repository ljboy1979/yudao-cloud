package cn.acsm.module.production.tunnel.controller.admin.infosoilenv.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 地块土壤环境 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class InfoSoilEnvBaseVO {

    @ApiModelProperty(value = "地块id")
    private String tunnelId;

    @ApiModelProperty(value = "设备")
    private String equipId;

    @ApiModelProperty(value = "测试者")
    private String tester;

    @ApiModelProperty(value = "测试时间")
    private Date testTime;

    @ApiModelProperty(value = "时间")
    private Date insertTime;

    @ApiModelProperty(value = "平均土壤含水量")
    private String avgSoilWater;

    @ApiModelProperty(value = "土类")
    private String soilType;

    @ApiModelProperty(value = "亚类")
    private String subType;

    @ApiModelProperty(value = "土属")
    private String soilGenus;

    @ApiModelProperty(value = "土种")
    private String soilSpecies;

    @ApiModelProperty(value = "俗名")
    private String commonName;

    @ApiModelProperty(value = "成土母质")
    private String soilParentMaterial;

    @ApiModelProperty(value = "剖面构型")
    private String profilePattern;

    @ApiModelProperty(value = "质地")
    private String texture;

    @ApiModelProperty(value = "土壤结构")
    private String soilStructure;

    @ApiModelProperty(value = "障碍因素")
    private String obstacleFactors;

    @ApiModelProperty(value = "侵蚀程度")
    private String erosionDegree;

    @ApiModelProperty(value = "耕层厚度")
    private String topsoilDepth;

    @ApiModelProperty(value = "采样深度")
    private String samplingDepth;

    @ApiModelProperty(value = "取样层次1")
    private String samplingLevelFirst;

    @ApiModelProperty(value = "质地1")
    private String textureFirst;

    @ApiModelProperty(value = "pH1")
    private String phFirst;

    @ApiModelProperty(value = "有机质1")
    private String organicMatterFirst;

    @ApiModelProperty(value = "碱解氮1")
    private String availableNitrogenFirst;

    @ApiModelProperty(value = "有效磷1")
    private String effectivePhosphorusFirst;

    @ApiModelProperty(value = "全钾1")
    private String totalPotassiumFirst;

    @ApiModelProperty(value = "缓效钾1")
    private String slowEffectPotassiumFirst;

    @ApiModelProperty(value = "速效钾1")
    private String availablePotassiumFirst;

    @ApiModelProperty(value = "全氮")
    private String totalNitrogen;

    @ApiModelProperty(value = "项目标识")
    private String source;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "机构编码")
    private String officeCode;

    @ApiModelProperty(value = "机构名称")
    private String officeName;

    @ApiModelProperty(value = "公司编码")
    private String companyCode;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "审核状态")
    private String reviewStatus;

    @ApiModelProperty(value = "审核人")
    private String reviewer;

    @ApiModelProperty(value = "审核时间")
    private Date reviewDate;

    @ApiModelProperty(value = "审核内容")
    private String reviewContent;

    @ApiModelProperty(value = "租户代码", required = true)
    @NotNull(message = "租户代码不能为空")
    private String corpCode;

    @ApiModelProperty(value = "租户名称", required = true)
    @NotNull(message = "租户名称不能为空")
    private String corpName;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
