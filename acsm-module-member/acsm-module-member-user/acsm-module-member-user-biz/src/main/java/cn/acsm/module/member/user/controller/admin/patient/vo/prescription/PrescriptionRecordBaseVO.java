package cn.acsm.module.member.user.controller.admin.patient.vo.prescription;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 处方记录表 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PrescriptionRecordBaseVO {

    @ApiModelProperty(value = "健康档案id", required = true)
    @NotNull(message = "健康档案id不能为空")
    private Long patientHealthId;

    @ApiModelProperty(value = "医院")
    private String hospital;

    @ApiModelProperty(value = "科室")
    private String department;

    @ApiModelProperty(value = "处方医生")
    private String doctor;

    @ApiModelProperty(value = "下处方日期")
    private Date prescriptionDate;

    @ApiModelProperty(value = "处方类别")
    private String prescriptionCategory;

    @ApiModelProperty(value = "处方内容")
    private String prescriptionContent;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
