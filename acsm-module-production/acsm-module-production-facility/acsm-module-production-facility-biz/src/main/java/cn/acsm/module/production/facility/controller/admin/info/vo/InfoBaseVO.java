package cn.acsm.module.production.facility.controller.admin.info.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 设施 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class InfoBaseVO {

    @ApiModelProperty(value = "基地")
    private String baseId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "设施编号")
    private String facilityCode;

    @ApiModelProperty(value = "分类(生产类,加工类,服务类,管理类)")
    private Integer classify;

    @ApiModelProperty(value = "加工车间,饭店等等")
    private Integer facilityType;

    @ApiModelProperty(value = "实际可用面积")
    private Double areaNumber;

    @ApiModelProperty(value = "地图画出的面积")
    private Double muNumber;

    @ApiModelProperty(value = "经度")
    private Double longitude;

    @ApiModelProperty(value = "纬度")
    private Double latitude;

    @ApiModelProperty(value = "百度坐标系经度")
    private BigDecimal bdLongitude;

    @ApiModelProperty(value = "百度坐标系纬度")
    private BigDecimal bdLatitude;

    @ApiModelProperty(value = "边界坐标集")
    private String coordinateGroup;

    @ApiModelProperty(value = "透明度")
    private Integer opacity;

    @ApiModelProperty(value = "边界颜色")
    private String viewColor;

    @ApiModelProperty(value = "边框颜色")
    private String borderColor;

    @ApiModelProperty(value = "品类id")
    private String plantId;

    @ApiModelProperty(value = "商品规格")
    private String commoditySpec;

    @ApiModelProperty(value = "商品数量")
    private String commodityNum;

    @ApiModelProperty(value = "品类名称")
    private String plantName;

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

    @ApiModelProperty(value = "产业标签")
    private String industryLabel;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "类型")
    private Integer secondFacilityType;

    @ApiModelProperty(value = "储藏条件")
    private String storageConditions;

    @ApiModelProperty(value = "租户代码", required = true)
    @NotNull(message = "租户代码不能为空")
    private String corpCode;

    @ApiModelProperty(value = "租户名称", required = true)
    @NotNull(message = "租户名称不能为空")
    private String corpName;

    @ApiModelProperty(value = "同步状态1已同步", required = true)
    @NotNull(message = "同步状态1已同步不能为空")
    private String syncStatus;

    @ApiModelProperty(value = "地块id")
    private String tunnelInfoId;

    @ApiModelProperty(value = "市id")
    private String areaId;

    @ApiModelProperty(value = "区id")
    private String ruralId;

    @ApiModelProperty(value = "省id")
    private String villagesAreaId;

    @ApiModelProperty(value = "市名称")
    private String areaName;

    @ApiModelProperty(value = "区名称")
    private String ruralName;

    @ApiModelProperty(value = "省名称")
    private String villagesAreaName;

    @ApiModelProperty(value = "所属区域")
    private String regionalManagementId;

    @ApiModelProperty(value = "设施状态(已出租0未出租1停用2)")
    private String induFacilityInfoState;

    @ApiModelProperty(value = "到期时间")
    private Date expirationTime;

    @ApiModelProperty(value = "图片，多个图片用逗号隔开")
    private String indufacilityinfoImage;

    @ApiModelProperty(value = "实际可用面积单位 关联字典")
    private String areaNumberUnit;

    @ApiModelProperty(value = "楼栋/单元")
    private String building;

    @ApiModelProperty(value = "楼层 关联字典")
    private String floor;

    @ApiModelProperty(value = "门牌号")
    private String houseNumber;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
