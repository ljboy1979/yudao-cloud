package cn.acsm.module.production.facility.controller.admin.contract.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 租赁合同 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ContractExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("经营主体id")
    private String induSubjectId;

    @ExcelProperty("合同名称")
    private String contractName;

    @ExcelProperty("合同编号")
    private String contractNum;

    @ExcelProperty("合同简要内容")
    private String contractContent;

    @ExcelProperty("签订时间")
    private Date signTime;

    @ExcelProperty("签订方")
    private String signatory;

    @ExcelProperty("金额")
    private BigDecimal amount;

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
