package cn.acsm.module.resource.controller.admin.adoptright.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 认养/租凭权益 Excel VO
 *
 * @author smile
 */
@Data
public class AdoptRightExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("权益类型")
    private String rightType;

    @ExcelProperty("权益描述")
    private String rightDescription;

    @ExcelProperty("认养时间")
    private Date adoptTime;

    @ExcelProperty("认养物编号")
    private String adoptContentNum;

    @ExcelProperty("收入项：收入金额：收入比例")
    private String incomeItemAmountScale;

    @ExcelProperty("收入有效日期")
    private Date incomeEffectiveDate;

    @ExcelProperty("租用人标签")
    private String leasePersonFlag;

    @ExcelProperty("权益价格的id")
    private String adoptRightId;

    @ExcelProperty("金额")
    private String price;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("项目来源")
    private String source;

    @ExcelProperty("经营主体id")
    private String subjectId;

}
