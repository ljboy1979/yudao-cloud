package cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 基地物候环境分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PhenologicalEnvPageReqVO extends PageParam {

    @ApiModelProperty(value = "基地id")
    private String basesId;

    @ApiModelProperty(value = "设备")
    private String devicesId;

    @ApiModelProperty(value = "测试者")
    private String tester;

    @ApiModelProperty(value = "测试时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] testTime;

    @ApiModelProperty(value = "时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] insertTime;

    @ApiModelProperty(value = "光照强度")
    private Double lightIntensity;

    @ApiModelProperty(value = "地貌类型")
    private String geomorphicType;

    @ApiModelProperty(value = "地形部位")
    private String landform;

    @ApiModelProperty(value = "地面坡度")
    private Double groundSlope;

    @ApiModelProperty(value = "坡向")
    private String slopeDirection;

    @ApiModelProperty(value = "常年有效积温")
    private Double effectiveTemperature;

    @ApiModelProperty(value = "常年无霜期")
    private Double frostFreePeriod;

    @ApiModelProperty(value = "30年最低温度天数")
    private Integer minTemperatureDays;

    @ApiModelProperty(value = "30年最高温度天数")
    private Integer maxTemperatureDays;

    @ApiModelProperty(value = "典型种植制度")
    private String typicalCropSystem;

    @ApiModelProperty(value = "熟制")
    private String maturationSystem;

    @ApiModelProperty(value = "常年产量水平")
    private Double annualYieldLevel;

    @ApiModelProperty(value = "农田基础设施")
    private String farmlandInfrastructure;

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
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] reviewDate;

    @ApiModelProperty(value = "审核内容")
    private String reviewContent;

    @ApiModelProperty(value = "租户代码")
    private String corpCode;

    @ApiModelProperty(value = "租户名称")
    private String corpName;

    @ApiModelProperty(value = "海拔")
    private Double altitude;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
