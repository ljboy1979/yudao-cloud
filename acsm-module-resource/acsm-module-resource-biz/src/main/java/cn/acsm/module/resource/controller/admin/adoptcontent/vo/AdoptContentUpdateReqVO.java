package cn.acsm.module.resource.controller.admin.adoptcontent.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 认养物/租凭物更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AdoptContentUpdateReqVO extends AdoptContentBaseVO {

    @ApiModelProperty(value = "主键ID", required = true)
    @NotNull(message = "主键ID不能为空")
    private Long id;

    @ApiModelProperty(value = "关联服务")
    private String serviceInfoId;

    @ApiModelProperty(value = "省市区")
    private String country;

    @ApiModelProperty(value = "详细地址")
    private String addRess;

    @ApiModelProperty(value = "经度")
    private BigDecimal longitude;

    @ApiModelProperty(value = "维度")
    private BigDecimal latitude;

    @ApiModelProperty(value = "认养方式")
    private String adoptWay;

    @ApiModelProperty(value = "关联设备")
    private String deviceId;

    @ApiModelProperty(value = "1 是植株/个体 空是认养")
    private String plantType;

    @ApiModelProperty(value = "种植时间")
    private Date plantTime;

    @ApiModelProperty(value = "种植的行号")
    private String plantX;

    @ApiModelProperty(value = "种植的列号")
    private String plantY;

    @ApiModelProperty(value = "介绍")
    private String introduce;

    @ApiModelProperty(value = "年龄")
    private String age;

    @ApiModelProperty(value = "习性")
    private String habit;

    @ApiModelProperty(value = "体重")
    private String weight;

    @ApiModelProperty(value = "身高")
    private String height;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "血统")
    private String ancestry;

    @ApiModelProperty(value = "特长")
    private String strongPoint;

    @ApiModelProperty(value = "品种")
    private String plantCropId;

    @ApiModelProperty(value = "关联代理商")
    private String agents;

    @ApiModelProperty(value = "认养名额总数")
    private Integer adoptSum;

    @ApiModelProperty(value = "认养数")
    private Integer adoptNumber;

    @ApiModelProperty(value = "区域id")
    private String partitionsId;

    @ApiModelProperty(value = "资源类型字段（1-认养物；2-租赁物）")
    private String resourceType;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "项目来源")
    private String source;

}
