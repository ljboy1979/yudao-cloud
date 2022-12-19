package cn.acsm.module.production.bases.controller.admin.soilenv.vo;

import lombok.*;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 基地土壤环境 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class SoilEnvExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("地块id")
    private String basesId;

    @ExcelProperty("设备")
    private String equipId;

    @ExcelProperty("测试者")
    private String tester;

    @ExcelProperty("测试时间")
    private Date testTime;

    @ExcelProperty("时间")
    private Date insertTime;

    @ExcelProperty("平均土壤含水量")
    private String avgSoilWater;

    @ExcelProperty("土类")
    private String soilType;

    @ExcelProperty("亚类")
    private String subType;

    @ExcelProperty("土属")
    private String soilGenus;

    @ExcelProperty("土种")
    private String soilSpecies;

    @ExcelProperty("俗名")
    private String commonName;

    @ExcelProperty("成土母质")
    private String soilParentMaterial;

    @ExcelProperty("剖面构型")
    private String profilePattern;

    @ExcelProperty("质地")
    private String texture;

    @ExcelProperty("土壤结构")
    private String soilStructure;

    @ExcelProperty("障碍因素")
    private String obstacleFactors;

    @ExcelProperty("侵蚀程度")
    private String erosionDegree;

    @ExcelProperty("耕层厚度")
    private String topsoilDepth;

    @ExcelProperty("采样深度")
    private String samplingDepth;

    @ExcelProperty("取样层次1")
    private String samplingLevelFirst;

    @ExcelProperty("质地1")
    private String textureFirst;

    @ExcelProperty("pH1")
    private String phFirst;

    @ExcelProperty("有机质1")
    private String organicMatterFirst;

    @ExcelProperty("碱解氮1")
    private String availableNitrogenFirst;

    @ExcelProperty("有效磷1")
    private String effectivePhosphorusFirst;

    @ExcelProperty("全钾1")
    private String totalPotassiumFirst;

    @ExcelProperty("缓效钾1")
    private String slowEffectPotassiumFirst;

    @ExcelProperty("速效钾1")
    private String availablePotassiumFirst;

    @ExcelProperty("全氮")
    private String totalNitrogen;

    @ExcelProperty("项目标识")
    private String source;

    @ExcelProperty("备注信息")
    private String remarks;

    @ExcelProperty("机构编码")
    private String officeCode;

    @ExcelProperty("机构名称")
    private String officeName;

    @ExcelProperty("公司编码")
    private String companyCode;

    @ExcelProperty("公司名称")
    private String companyName;

    @ExcelProperty("审核状态")
    private String reviewStatus;

    @ExcelProperty("审核人")
    private String reviewer;

    @ExcelProperty("审核时间")
    private Date reviewDate;

    @ExcelProperty("审核内容")
    private String reviewContent;

    @ExcelProperty("租户代码")
    private String corpCode;

    @ExcelProperty("租户名称")
    private String corpName;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
