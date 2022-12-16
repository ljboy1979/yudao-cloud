package cn.acsm.module.production.devices.controller.admin.paramscfg.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 设备参数配置 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ParamsCfgExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("参数对应字段名")
    private String paramColumn;

    @ExcelProperty("参数名称")
    private String paramName;

    @ExcelProperty("参数单位")
    private String paramUnit;

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

    @ExcelProperty("备注信息")
    private String remarks;

    @ExcelProperty("参数配置id")
    private String cfgId;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
