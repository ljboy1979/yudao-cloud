package cn.acsm.module.member.user.controller.admin.patient.vo.nutritionexamination;

import lombok.*;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 营养检查记录 Excel VO
 *
 * @author lihongyan
 */
@Data
public class NutritionExaminationRecordExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("健康档案id")
    private Long patientHealthId;

    @ExcelProperty("医院")
    private String hospital;

    @ExcelProperty("科室")
    private String department;

    @ExcelProperty("检查医生")
    private String doctor;

    @ExcelProperty("检查日期")
    private Date checkDate;

    @ExcelProperty("检查类别")
    private String checkCategory;

    @ExcelProperty("检查内容")
    private String checkContent;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
