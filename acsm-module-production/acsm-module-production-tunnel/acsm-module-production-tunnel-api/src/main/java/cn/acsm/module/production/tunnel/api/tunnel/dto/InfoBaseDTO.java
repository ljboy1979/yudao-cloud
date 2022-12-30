package cn.acsm.module.production.tunnel.api.tunnel.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class InfoBaseDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "基地")
    private String baseId;

    @ApiModelProperty(value = "分区")
    private String partitionId;

    @ApiModelProperty(value = "当前种植的json")
    private String realPlantJson;

    @ApiModelProperty(value = "原主键id 暂未使用")
    private Integer tunnelInfoId;

    @ApiModelProperty(value = "地块名称")
    private String tunnelName;

    @ApiModelProperty(value = "经度")
    private BigDecimal longitude;

    @ApiModelProperty(value = "维度")
    private BigDecimal latitude;

    @ApiModelProperty(value = "实际可用面积")
    private BigDecimal areaNumber;

    @ApiModelProperty(value = "地图画出的面积")
    private BigDecimal muNumber;

    @ApiModelProperty(value = "行政区划：乡镇、村、区域")
    private String areaId;

    @ApiModelProperty(value = "百度经度")
    private BigDecimal bdLongitude;

    @ApiModelProperty(value = "百度纬度")
    private BigDecimal bdLatitude;

    @ApiModelProperty(value = "边界经纬度")
    private String coordinateGroup;

    @ApiModelProperty(value = "类型")
    private String plantEnvTypeId;

    @ApiModelProperty(value = "google 抓取的静态图")
    private String staticPicture;

    @ApiModelProperty(value = "地块颜色")
    private String viewColor;

    @ApiModelProperty(value = "边框颜色")
    private String borderColor;

    @ApiModelProperty(value = "透明度 0-100")
    private Integer opacity;

    @ApiModelProperty(value = "星级")
    private Integer littleStar;

    @ApiModelProperty(value = "小类别(灌溉水田,天然草地等)")
    private Integer littleType;

    @ApiModelProperty(value = "乡镇ID")
    private String villagesId;

    @ApiModelProperty(value = "乡镇CODE")
    private String villagesCode;

    @ApiModelProperty(value = "村id")
    private String ruralId;

    @ApiModelProperty(value = "村code")
    private String ruralCode;

    @ApiModelProperty(value = "地块编号")
    private String tunnelCode;

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

    @ApiModelProperty(value = "归档状态0,正在使用1,已归档")
    private String archiveStatus;

    @ApiModelProperty(value = "归档时间")
    private Date archiveTime;

    @ApiModelProperty(value = "租户代码", required = true)
    @NotNull(message = "租户代码不能为空")
    private String corpCode;

    @ApiModelProperty(value = "租户名称", required = true)
    @NotNull(message = "租户名称不能为空")
    private String corpName;

    @ApiModelProperty(value = "同步状态 1已同步", required = true)
    @NotNull(message = "同步状态 1已同步不能为空")
    private String syncStatus;

    @ApiModelProperty(value = "农户")
    private String farmers;

    @ApiModelProperty(value = "技术指导员")
    private String instructors;

    @ApiModelProperty(value = "农户")
    private String farmersName;

    @ApiModelProperty(value = "技术指导员")
    private String instructorsName;

    @ApiModelProperty(value = "义田帮手1.0主键")
    private Integer oldId;

    @ApiModelProperty(value = "市名称")
    private String areaName;

    @ApiModelProperty(value = "区名称")
    private String ruralName;

    @ApiModelProperty(value = "省名称")
    private String villagesName;

    @ApiModelProperty(value = "执行人Id")
    private String performId;

    @ApiModelProperty(value = "部门Id")
    private String departmentId;

    @ApiModelProperty(value = "农户id")
    private String makersId;

    @ApiModelProperty(value = "农户部门id")
    private String makersDepartmentId;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "面积单位")
    private String areaNumUnit;

    @ApiModelProperty(value = "地块位置")
    private String areaLocation;

    @ApiModelProperty(value = "多个标签id 逗号隔开")
    private String lableIds;

    @ApiModelProperty(value = "地块使用状态 0=休耕,1=种植中")
    private String plantStatus;

    @ApiModelProperty(value = "图片，多张图片用逗号隔开")
    private String tunnelinfoImage;

    @ApiModelProperty(value = "可播种作物数量")
    private Integer plantAmount;

    @ApiModelProperty(value = "0认养，1不可认养")
    private String adoption;

    @ApiModelProperty(value = "租户集合")
    private Long source;

}
