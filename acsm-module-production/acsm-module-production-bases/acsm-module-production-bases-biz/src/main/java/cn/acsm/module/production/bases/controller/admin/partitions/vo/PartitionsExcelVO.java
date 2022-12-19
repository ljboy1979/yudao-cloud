package cn.acsm.module.production.bases.controller.admin.partitions.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 分区信息 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PartitionsExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("基地")
    private String baseId;

    @ExcelProperty("名称")
    private String name;

    @ExcelProperty("面积")
    private Float muNumber;

    @ExcelProperty("展示颜色")
    private String viewColor;

    @ExcelProperty("边框颜色")
    private String borderColor;

    @ExcelProperty("透明度")
    private Integer opacity;

    @ExcelProperty("经度")
    private BigDecimal longitude;

    @ExcelProperty("纬度")
    private BigDecimal latitude;

    @ExcelProperty("边界范围")
    private String coordinateGroup;

    @ExcelProperty("百度维度")
    private Double bdLatitude;

    @ExcelProperty("百度经度")
    private Double bdLongitude;

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

    @ExcelProperty("租户代码")
    private String corpCode;

    @ExcelProperty("租户名称")
    private String corpName;

    @ExcelProperty("同步状态1已同步")
    private String syncStatus;

    @ExcelProperty("1.0id")
    private Integer oldId;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
