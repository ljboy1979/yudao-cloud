package cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo;

import lombok.*;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 产能计划 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ProductionCapacityPlansExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("基地标识")
    private String basesId;

    @ExcelProperty("产能计划名称")
    private String planName;

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
