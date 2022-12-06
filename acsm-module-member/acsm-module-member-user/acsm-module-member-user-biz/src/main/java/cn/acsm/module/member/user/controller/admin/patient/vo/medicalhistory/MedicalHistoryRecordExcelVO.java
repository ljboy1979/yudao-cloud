package cn.acsm.module.member.user.controller.admin.patient.vo.medicalhistory;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.TIME_ZONE_DEFAULT;

/**
 * 病史记录 Excel VO
 *
 * @author lihongyan
 */
@Data
public class MedicalHistoryRecordExcelVO {

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

    @ExcelProperty("医生")
    private String doctor;

    @ExcelProperty("治疗时间")
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = TIME_ZONE_DEFAULT)
    private Date treatmentDate;

    @ExcelProperty("检查分类")
    private String checkCategory;

    @ExcelProperty("检查内容")
    private String checkContent;

    @ExcelProperty("治疗方案")
    private String treatmentOptions;

    @ExcelProperty("治疗结果")
    private String treatmentOutcome;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
