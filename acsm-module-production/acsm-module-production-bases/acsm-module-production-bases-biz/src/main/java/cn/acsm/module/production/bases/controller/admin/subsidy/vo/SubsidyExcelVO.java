package cn.acsm.module.production.bases.controller.admin.subsidy.vo;

import lombok.*;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 基地补贴信息 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class SubsidyExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("基地")
    private String basesId;

    @ExcelProperty("金融服务")
    private String financialId;

    @ExcelProperty("时间")
    private Date insertTime;

    @ExcelProperty("金额")
    private Double money;

    @ExcelProperty("面积")
    private Double muNumber;

    @ExcelProperty("补贴类型")
    private String subsidyType;

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

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
