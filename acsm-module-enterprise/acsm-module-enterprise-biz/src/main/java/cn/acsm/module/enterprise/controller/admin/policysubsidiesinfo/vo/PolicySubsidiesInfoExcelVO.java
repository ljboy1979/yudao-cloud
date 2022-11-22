package cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 企业政策补贴信息 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PolicySubsidiesInfoExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("经营主体ID")
    private Long enterpriseId;

    @ExcelProperty("补贴种类")
    private String subsidiesCategory;

    @ExcelProperty("补贴名称")
    private String subsidiesName;

    @ExcelProperty("补贴金额")
    private BigDecimal subsidiesAmount;

    @ExcelProperty("补贴方式")
    private String subsidiesType;

    @ExcelProperty("补贴状态")
    private Integer subsidiesStatus;

    @ExcelProperty("申请人")
    private String applyPerson;

    @ExcelProperty("申请时间")
    private Date applyTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

    @ExcelProperty("创建时间")
    private Date createTime;

}
