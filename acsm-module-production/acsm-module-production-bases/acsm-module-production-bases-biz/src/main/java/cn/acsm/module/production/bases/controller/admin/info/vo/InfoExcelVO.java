package cn.acsm.module.production.bases.controller.admin.info.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 基地信息 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class InfoExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("行政区域")
    private String areaId;

    @ExcelProperty("行政区域")
    private String areaName;

    @ExcelProperty("乡镇id")
    private String villagesAreaId;

    @ExcelProperty("乡镇id")
    private String villagesAreaName;

    @ExcelProperty("村镇id")
    private String ruralId;

    @ExcelProperty("村镇id")
    private String ruralName;

    @ExcelProperty("基地名称")
    private String baseName;

    @ExcelProperty("联系人")
    private String contactName;

    @ExcelProperty("联系电话")
    private String contactPhone;

    @ExcelProperty("地址")
    private String address;

    @ExcelProperty("联系邮箱")
    private String email;

    @ExcelProperty("经度")
    private BigDecimal longitude;

    @ExcelProperty("纬度")
    private BigDecimal latitude;

    @ExcelProperty("百度坐标系经度")
    private BigDecimal bdLongitude;

    @ExcelProperty("百度坐标系纬度")
    private BigDecimal bdLatitude;

    @ExcelProperty("边界范围")
    private String coordinateGroup;

    @ExcelProperty("实际可使用的面积")
    private String areaNumber;

    @ExcelProperty("geometry计算测出的面积")
    private String muNumber;

    @ExcelProperty("颜色")
    private String viewColor;

    @ExcelProperty("google 抓取的图片")
    private String staticPicture;

    @ExcelProperty("海拔")
    private String altitude;

    @ExcelProperty("常年供应")
    private String persistSupply;

    @ExcelProperty("基地编号")
    private String baseCode;

    @ExcelProperty("使用水源")
    private String waterSource;

    @ExcelProperty("地形")
    private String terrain;

    @ExcelProperty("土壤类型")
    private String soilType;

    @ExcelProperty("土壤酸碱度")
    private String soilPh;

    @ExcelProperty("气候类型")
    private String climateType;

    @ExcelProperty("年降雨量")
    private String annualRainfall;

    @ExcelProperty("年平均温度")
    private String averageTemperature;

    @ExcelProperty("基地介绍")
    private String basesContent;

    @ExcelProperty("机构编码")
    private String officeCode;

    @ExcelProperty("机构名称")
    private String officeName;

    @ExcelProperty("公司编码")
    private String companyCode;

    @ExcelProperty("公司名称")
    private String companyName;

    @ExcelProperty("备注信息")
    private String remarks;

    @ExcelProperty("审核状态")
    private String reviewStatus;

    @ExcelProperty("审核人")
    private String reviewer;

    @ExcelProperty("审核时间")
    private Date reviewDate;

    @ExcelProperty("审核内容")
    private String reviewContent;

    @ExcelProperty("gap主键Id")
    private String gapId;

    @ExcelProperty("所属企业")
    private String affiliatedEnterprises;

    @ExcelProperty("分类")
    private String classify;

    @ExcelProperty("租户代码")
    private String corpCode;

    @ExcelProperty("租户名称")
    private String corpName;

    @ExcelProperty("颜色")
    private String borderColor;

    @ExcelProperty("分类")
    private String panoramaUrl;

    @ExcelProperty("建设时间")
    private Date buildDate;

    @ExcelProperty("同步状态 1已同步")
    private String syncStatus;

    @ExcelProperty("宣传视频")
    private String propagandaVideo;

    @ExcelProperty("宣传视频")
    private String opacity;

    @ExcelProperty("1.0Id")
    private Integer oldId;

    @ExcelProperty("图片，多张图片用逗号隔开")
    private String basesImage;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
