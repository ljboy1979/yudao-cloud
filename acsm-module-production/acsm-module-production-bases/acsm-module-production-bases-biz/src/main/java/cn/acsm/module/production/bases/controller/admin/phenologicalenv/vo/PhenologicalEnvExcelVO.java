package cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo;

import lombok.*;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 基地物候环境 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PhenologicalEnvExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("基地id")
    private String basesId;

    @ExcelProperty("设备")
    private String devicesId;

    @ExcelProperty("测试者")
    private String tester;

    @ExcelProperty("测试时间")
    private Date testTime;

    @ExcelProperty("时间")
    private Date insertTime;

    @ExcelProperty("光照强度")
    private Double lightIntensity;

    @ExcelProperty("地貌类型")
    private String geomorphicType;

    @ExcelProperty("地形部位")
    private String landform;

    @ExcelProperty("地面坡度")
    private Double groundSlope;

    @ExcelProperty("坡向")
    private String slopeDirection;

    @ExcelProperty("常年有效积温")
    private Double effectiveTemperature;

    @ExcelProperty("常年无霜期")
    private Double frostFreePeriod;

    @ExcelProperty("30年最低温度天数")
    private Integer minTemperatureDays;

    @ExcelProperty("30年最高温度天数")
    private Integer maxTemperatureDays;

    @ExcelProperty("典型种植制度")
    private String typicalCropSystem;

    @ExcelProperty("熟制")
    private String maturationSystem;

    @ExcelProperty("常年产量水平")
    private Double annualYieldLevel;

    @ExcelProperty("农田基础设施")
    private String farmlandInfrastructure;

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

    @ExcelProperty("海拔")
    private Double altitude;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
