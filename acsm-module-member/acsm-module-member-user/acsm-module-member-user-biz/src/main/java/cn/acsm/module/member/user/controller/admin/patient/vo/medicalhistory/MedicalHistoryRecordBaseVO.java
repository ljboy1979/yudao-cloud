package cn.acsm.module.member.user.controller.admin.patient.vo.medicalhistory;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.TIME_ZONE_DEFAULT;

/**
* 病史记录 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class MedicalHistoryRecordBaseVO {

    @ApiModelProperty(value = "健康档案id", required = true)
    @NotNull(message = "健康档案id不能为空")
    private Long patientHealthId;

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "医院")
    private String hospital;

    @ApiModelProperty(value = "科室")
    private String department;

    @ApiModelProperty(value = "医生")
    private String doctor;

    @ApiModelProperty(value = "治疗时间")
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = TIME_ZONE_DEFAULT)
    private Date treatmentDate;

    @ApiModelProperty(value = "检查分类")
    private String checkCategory;

    @ApiModelProperty(value = "检查内容")
    private String checkContent;

    @ApiModelProperty(value = "治疗方案")
    private String treatmentOptions;

    @ApiModelProperty(value = "治疗结果")
    private String treatmentOutcome;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
