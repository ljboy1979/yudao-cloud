package cn.acsm.module.production.tunnel.controller.admin.info.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 地块信息 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class InfoExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("基地")
    private String baseId;

    @ExcelProperty("分区")
    private String partitionId;

    @ExcelProperty("当前种植的json")
    private String realPlantJson;

    @ExcelProperty("原主键id 暂未使用")
    private Integer tunnelInfoId;

    @ExcelProperty("地块名称")
    private String tunnelName;

    @ExcelProperty("经度")
    private BigDecimal longitude;

    @ExcelProperty("维度")
    private BigDecimal latitude;

    @ExcelProperty("实际可用面积")
    private BigDecimal areaNumber;

    @ExcelProperty("地图画出的面积")
    private BigDecimal muNumber;

    @ExcelProperty("行政区划：乡镇、村、区域")
    private String areaId;

    @ExcelProperty("百度经度")
    private BigDecimal bdLongitude;

    @ExcelProperty("百度纬度")
    private BigDecimal bdLatitude;

    @ExcelProperty("边界经纬度")
    private String coordinateGroup;

    @ExcelProperty("类型")
    private String plantEnvTypeId;

    @ExcelProperty("google 抓取的静态图")
    private String staticPicture;

    @ExcelProperty("地块颜色")
    private String viewColor;

    @ExcelProperty("边框颜色")
    private String borderColor;

    @ExcelProperty("透明度 0-100")
    private Integer opacity;

    @ExcelProperty("星级")
    private Integer littleStar;

    @ExcelProperty("小类别(灌溉水田,天然草地等)")
    private Integer littleType;

    @ExcelProperty("乡镇ID")
    private String villagesId;

    @ExcelProperty("乡镇CODE")
    private String villagesCode;

    @ExcelProperty("村id")
    private String ruralId;

    @ExcelProperty("村code")
    private String ruralCode;

    @ExcelProperty("地块编号")
    private String tunnelCode;

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

    @ExcelProperty("归档状态0,正在使用1,已归档")
    private String archiveStatus;

    @ExcelProperty("归档时间")
    private Date archiveTime;

    @ExcelProperty("租户代码")
    private String corpCode;

    @ExcelProperty("租户名称")
    private String corpName;

    @ExcelProperty("同步状态 1已同步")
    private String syncStatus;

    @ExcelProperty("农户")
    private String farmers;

    @ExcelProperty("技术指导员")
    private String instructors;

    @ExcelProperty("农户")
    private String farmersName;

    @ExcelProperty("技术指导员")
    private String instructorsName;

    @ExcelProperty("义田帮手1.0主键")
    private Integer oldId;

    @ExcelProperty("市名称")
    private String areaName;

    @ExcelProperty("区名称")
    private String ruralName;

    @ExcelProperty("省名称")
    private String villagesName;

    @ExcelProperty("执行人Id")
    private String performId;

    @ExcelProperty("部门Id")
    private String departmentId;

    @ExcelProperty("农户id")
    private String makersId;

    @ExcelProperty("农户部门id")
    private String makersDepartmentId;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("面积单位")
    private String areaNumUnit;

    @ExcelProperty("地块位置")
    private String areaLocation;

    @ExcelProperty("多个标签id 逗号隔开")
    private String lableIds;

    @ExcelProperty("地块使用状态 0=休耕,1=种植中")
    private String plantStatus;

    @ExcelProperty("图片，多张图片用逗号隔开")
    private String tunnelinfoImage;

    @ExcelProperty("可播种作物数量")
    private Integer plantAmount;

    @ExcelProperty("0认养，1不可认养")
    private String adoption;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

}
