package cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood;

import lombok.*;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;

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

    @ExcelProperty("医院")
    private String hospital;

    @ExcelProperty("科室")
    private String department;

    @ExcelProperty("营养师名称")
    private String doctor;

    @ExcelProperty("使用时间")
    private Date specialMedicalDate;

    @ExcelProperty("特医食品类别")
    private String specialMedicalCategory;

    @ExcelProperty("特医食品内容")
    private String specialMedicalContent;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
