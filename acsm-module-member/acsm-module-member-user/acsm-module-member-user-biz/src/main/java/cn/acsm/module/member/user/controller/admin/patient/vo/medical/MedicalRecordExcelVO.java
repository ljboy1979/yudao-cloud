package cn.acsm.module.member.user.controller.admin.patient.vo.medical;

import lombok.*;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 医嘱记录 Excel VO
 *
 * @author lihongyan
 */
@Data
public class MedicalRecordExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("健康档案id")
    private Long patientHealthId;

    @ExcelProperty("医院")
    private String hospital;

    @ExcelProperty("科室")
    private String department;

    @ExcelProperty("医生名称")
    private String doctor;

    @ExcelProperty("下医嘱日期")
    private Date medicalDate;

    @ExcelProperty("医嘱类别")
    private String medicalCategory;

    @ExcelProperty("医嘱内容")
    private String medicalContent;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
