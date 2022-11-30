package cn.acsm.module.member.user.controller.admin.patient.vo.prescription;

import lombok.*;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;

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
    private Date prescriptionDate;

    @ExcelProperty("处方类别")
    private String prescriptionCategory;

    @ExcelProperty("处方内容")
    private String prescriptionContent;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
