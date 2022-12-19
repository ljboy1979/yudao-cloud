package cn.acsm.module.production.bases.controller.admin.partitions.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;

import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 分区信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PartitionsBaseVO {

    @ApiModelProperty(value = "基地")
    private String baseId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "面积")
    private Float muNumber;

    @ApiModelProperty(value = "展示颜色")
    private String viewColor;

    @ApiModelProperty(value = "边框颜色")
    private String borderColor;

    @ApiModelProperty(value = "透明度")
    private Integer opacity;

    @ApiModelProperty(value = "经度")
    private BigDecimal longitude;

    @ApiModelProperty(value = "纬度")
    private BigDecimal latitude;

    @ApiModelProperty(value = "边界范围")
    private String coordinateGroup;

    @ApiModelProperty(value = "百度维度")
    private Double bdLatitude;

    @ApiModelProperty(value = "百度经度")
    private Double bdLongitude;

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

    @ApiModelProperty(value = "租户代码", required = true)
    @NotNull(message = "租户代码不能为空")
    private String corpCode;

    @ApiModelProperty(value = "租户名称", required = true)
    @NotNull(message = "租户名称不能为空")
    private String corpName;

    @ApiModelProperty(value = "同步状态1已同步", required = true)
    @NotNull(message = "同步状态1已同步不能为空")
    private String syncStatus;

    @ApiModelProperty(value = "1.0id")
    private Integer oldId;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
