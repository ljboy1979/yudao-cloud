package cn.acsm.module.member.user.controller.admin.patient.vo.medical;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 医嘱记录 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class MedicalRecordBaseVO {

    @ApiModelProperty(value = "健康档案id", required = true)
    @NotNull(message = "健康档案id不能为空")
    private Long patientHealthId;

    @ApiModelProperty(value = "医院")
    private String hospital;

    @ApiModelProperty(value = "科室")
    private String department;

    @ApiModelProperty(value = "医生名称")
    private String doctor;

    @ApiModelProperty(value = "下医嘱日期")
    private Date medicalDate;

    @ApiModelProperty(value = "医嘱类别")
    private String medicalCategory;

    @ApiModelProperty(value = "医嘱内容")
    private String medicalContent;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
