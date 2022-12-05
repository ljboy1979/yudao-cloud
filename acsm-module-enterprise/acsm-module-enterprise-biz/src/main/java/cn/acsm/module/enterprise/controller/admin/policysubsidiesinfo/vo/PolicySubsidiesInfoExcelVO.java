package cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;
import java.math.BigDecimal;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * 企业政策补贴信息 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PolicySubsidiesInfoExcelVO {

//    @ExcelProperty("编号")
//    private Long id;
//
//    @ExcelProperty("经营主体ID")
//    private Long enterpriseId;

    @ExcelProperty(value = "补贴种类", converter = DictConvert.class)
    @DictFormat("subsidies_category") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String subsidiesCategory;

    @ExcelProperty("补贴名称")
    private String subsidiesName;

    @ExcelProperty("补贴金额")
    private BigDecimal subsidiesAmount;

    @ExcelProperty(value = "补贴方式", converter = DictConvert.class)
    @DictFormat("subsidies_type") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String subsidiesType;

    @ExcelProperty(value = "补贴状态", converter = DictConvert.class)
    @DictFormat("subsidies_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Integer subsidiesStatus;

    @ExcelProperty("申请人")
    private String applyPerson;

    @ExcelProperty("申请时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date applyTime;

//    @ExcelProperty("租户编号")
//    private Long tenantId;
//
//    @ExcelProperty("租户集合")
//    private Long source;
//
//    @ExcelProperty("经营主体ID")
//    private Long subjectId;

//    @ExcelProperty("创建者")
//    private String creator;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
//
//    @ExcelProperty("更新者")
//    private String updater;

    @ExcelProperty("更新时间")
    private LocalDateTime updateTime;

}
