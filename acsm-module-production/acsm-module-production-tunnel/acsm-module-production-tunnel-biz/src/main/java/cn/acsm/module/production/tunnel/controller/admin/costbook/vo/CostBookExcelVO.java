package cn.acsm.module.production.tunnel.controller.admin.costbook.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 地块账本 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class CostBookExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("编号")
    private String costCode;

    @ExcelProperty("来源")
    private String costSource;

    @ExcelProperty("主体")
    private String entityId;

    @ExcelProperty("类型(0支出,1收入)")
    private String costType;

    @ExcelProperty("单据名称")
    private String accountName;

    @ExcelProperty("账目内容")
    private String accountInfo;

    @ExcelProperty("账目金额")
    private BigDecimal accountAmount;

    @ExcelProperty("时间")
    private Date accountTime;

    @ExcelProperty("地点")
    private String accountLocation;

    @ExcelProperty("记账时间")
    private Date accountingTime;

    @ExcelProperty("详情")
    private String remarks;

    @ExcelProperty("计数器")
    private Integer counter;

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
