package cn.acsm.module.production.bases.controller.admin.info.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
* 基地信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class InfoBaseVO {

    @ApiModelProperty(value = "行政区域")
    private String areaId;

    @ApiModelProperty(value = "行政区域")
    private String areaName;

    @ApiModelProperty(value = "乡镇id")
    private String villagesAreaId;

    @ApiModelProperty(value = "乡镇id")
    private String villagesAreaName;

    @ApiModelProperty(value = "村镇id")
    private String ruralId;

    @ApiModelProperty(value = "村镇id")
    private String ruralName;

    @ApiModelProperty(value = "基地名称")
    private String baseName;

    @ApiModelProperty(value = "联系人")
    private String contactName;

    @ApiModelProperty(value = "联系电话")
    private String contactPhone;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "联系邮箱")
    private String email;

    @ApiModelProperty(value = "经度")
    private BigDecimal longitude;

    @ApiModelProperty(value = "纬度")
    private BigDecimal latitude;

    @ApiModelProperty(value = "百度坐标系经度")
    private BigDecimal bdLongitude;

    @ApiModelProperty(value = "百度坐标系纬度")
    private BigDecimal bdLatitude;

    @ApiModelProperty(value = "边界范围")
    private String coordinateGroup;

    @ApiModelProperty(value = "实际可使用的面积")
    private String areaNumber;

    @ApiModelProperty(value = "geometry计算测出的面积")
    private String muNumber;

    @ApiModelProperty(value = "颜色")
    private String viewColor;

    @ApiModelProperty(value = "google 抓取的图片")
    private String staticPicture;

    @ApiModelProperty(value = "海拔")
    private String altitude;

    @ApiModelProperty(value = "常年供应")
    private String persistSupply;

    @ApiModelProperty(value = "基地编号")
    private String baseCode;

    @ApiModelProperty(value = "使用水源")
    private String waterSource;

    @ApiModelProperty(value = "地形")
    private String terrain;

    @ApiModelProperty(value = "土壤类型")
    private String soilType;

    @ApiModelProperty(value = "土壤酸碱度")
    private String soilPh;

    @ApiModelProperty(value = "气候类型")
    private String climateType;

    @ApiModelProperty(value = "年降雨量")
    private String annualRainfall;

    @ApiModelProperty(value = "年平均温度")
    private String averageTemperature;

    @ApiModelProperty(value = "基地介绍")
    private String basesContent;

    @ApiModelProperty(value = "机构编码")
    private String officeCode;

    @ApiModelProperty(value = "机构名称")
    private String officeName;

    @ApiModelProperty(value = "公司编码")
    private String companyCode;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "审核状态")
    private String reviewStatus;

    @ApiModelProperty(value = "审核人")
    private String reviewer;

    @ApiModelProperty(value = "审核时间")
    private Date reviewDate;

    @ApiModelProperty(value = "审核内容")
    private String reviewContent;

    @ApiModelProperty(value = "gap主键Id")
    private String gapId;

    @ApiModelProperty(value = "所属企业")
    private String affiliatedEnterprises;

    @ApiModelProperty(value = "分类")
    private String classify;

    @ApiModelProperty(value = "租户代码", required = true)
    @NotNull(message = "租户代码不能为空")
    private String corpCode;

    @ApiModelProperty(value = "租户名称", required = true)
    @NotNull(message = "租户名称不能为空")
    private String corpName;

    @ApiModelProperty(value = "颜色")
    private String borderColor;

    @ApiModelProperty(value = "分类")
    private String panoramaUrl;

    @ApiModelProperty(value = "建设时间")
    private Date buildDate;

    @ApiModelProperty(value = "同步状态 1已同步")
    private String syncStatus;

    @ApiModelProperty(value = "宣传视频")
    private String propagandaVideo;

    @ApiModelProperty(value = "宣传视频")
    private String opacity;

    @ApiModelProperty(value = "1.0Id")
    private Integer oldId;

    @ApiModelProperty(value = "图片，多张图片用逗号隔开")
    private String basesImage;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
