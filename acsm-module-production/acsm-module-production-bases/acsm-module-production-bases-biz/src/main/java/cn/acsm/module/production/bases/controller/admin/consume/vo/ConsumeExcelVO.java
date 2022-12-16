package cn.acsm.module.production.bases.controller.admin.consume.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 基地能耗信息 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ConsumeExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("基地id")
    private String basesId;

    @ExcelProperty("消耗量")
    private Double consumeNum;

    @ExcelProperty("单位")
    private String unit;

    @ExcelProperty("创建日期")
    private Date insertTime;

    @ExcelProperty("消耗类型1电2水3气")
    private String consumeType;

    @ExcelProperty("项目来源")
    private String source;

    @ExcelProperty("状态（0正常 1删除 2停用）")
    private String status;

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

    @ExcelProperty("参数名称")
    private String paramName;

    @ExcelProperty("参数单位")
    private String paramUnit;

    @ExcelProperty("参数值")
    private BigDecimal num;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
