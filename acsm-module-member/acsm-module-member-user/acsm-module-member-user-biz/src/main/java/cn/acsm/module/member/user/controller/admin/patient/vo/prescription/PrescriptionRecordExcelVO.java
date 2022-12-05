package cn.acsm.module.member.user.controller.admin.patient.vo.prescription;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.TIME_ZONE_DEFAULT;

/**
 * 处方记录表 Excel VO
 *
 * @author lihongyan
 */
@Data
public class PrescriptionRecordExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("健康档案id")
    private Long patientHealthId;

    @ExcelProperty("医院")
    private String hospital;

    @ExcelProperty("科室")
    private String department;

    @ExcelProperty("处方医生")
    private String doctor;

    @ExcelProperty("下处方日期")
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = TIME_ZONE_DEFAULT)
    private Date prescriptionDate;

    @ExcelProperty("处方类别")
    private String prescriptionCategory;

    @ExcelProperty("处方内容")
    private String prescriptionContent;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
