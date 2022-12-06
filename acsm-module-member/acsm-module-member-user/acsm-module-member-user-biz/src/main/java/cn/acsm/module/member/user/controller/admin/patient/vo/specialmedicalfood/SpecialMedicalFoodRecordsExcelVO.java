package cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.TIME_ZONE_DEFAULT;

/**
 * 特医食品使用记录表 Excel VO
 *
 * @author lihongyan
 */
@Data
public class SpecialMedicalFoodRecordsExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("健康档案id")
    private Long patientHealthId;

    @ExcelProperty("会员id")
    private Long memberId;

    @ExcelProperty("医院")
    private String hospital;

    @ExcelProperty("科室")
    private String department;

    @ExcelProperty("营养师名称")
    private String doctor;

    @ExcelProperty("使用时间")
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = TIME_ZONE_DEFAULT)
    private Date specialMedicalDate;

    @ExcelProperty("特医食品类别")
    private String specialMedicalCategory;

    @ExcelProperty("特医食品内容")
    private String specialMedicalContent;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
