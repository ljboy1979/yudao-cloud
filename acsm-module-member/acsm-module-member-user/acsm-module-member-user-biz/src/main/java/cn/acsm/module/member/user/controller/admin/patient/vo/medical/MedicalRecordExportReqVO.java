package cn.acsm.module.member.user.controller.admin.patient.vo.medical;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 医嘱记录 Excel 导出 Request VO", description = "参数和 MedicalRecordPageReqVO 是一致的")
@Data
public class MedicalRecordExportReqVO {

    @ApiModelProperty(value = "健康档案id")
    private Long patientHealthId;

    @ApiModelProperty(value = "医院")
    private String hospital;

    @ApiModelProperty(value = "科室")
    private String department;

    @ApiModelProperty(value = "医生名称")
    private String doctor;

    @ApiModelProperty(value = "下医嘱日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] medicalDate;

    @ApiModelProperty(value = "医嘱类别")
    private String medicalCategory;

    @ApiModelProperty(value = "医嘱内容")
    private String medicalContent;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
