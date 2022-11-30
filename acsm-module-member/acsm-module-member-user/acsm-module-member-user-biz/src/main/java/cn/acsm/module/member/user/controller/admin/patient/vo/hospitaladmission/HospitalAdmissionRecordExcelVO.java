package cn.acsm.module.member.user.controller.admin.patient.vo.hospitaladmission;

import lombok.*;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 住院记录 Excel VO
 *
 * @author lihongyan
 */
@Data
public class HospitalAdmissionRecordExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("健康档案id")
    private Long patientHealthId;

    @ExcelProperty("医院")
    private String hospital;

    @ExcelProperty("科室")
    private String department;

    @ExcelProperty("主治医生")
    private String doctor;

    @ExcelProperty("住院日期")
    private Date hospitalizationDate;

    @ExcelProperty("出院日期")
    private Date dischargeDate;

    @ExcelProperty("住院类别")
    private String hospitalizationCategories;

    @ExcelProperty("治疗内容")
    private String treatmentContent;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
