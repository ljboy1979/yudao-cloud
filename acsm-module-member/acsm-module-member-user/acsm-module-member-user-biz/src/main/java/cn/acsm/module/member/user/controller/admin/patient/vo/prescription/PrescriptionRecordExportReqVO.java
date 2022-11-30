package cn.acsm.module.member.user.controller.admin.patient.vo.prescription;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 处方记录表 Excel 导出 Request VO", description = "参数和 PrescriptionRecordPageReqVO 是一致的")
@Data
public class PrescriptionRecordExportReqVO {

    @ApiModelProperty(value = "健康档案id")
    private Long patientHealthId;

    @ApiModelProperty(value = "医院")
    private String hospital;

    @ApiModelProperty(value = "科室")
    private String department;

    @ApiModelProperty(value = "处方医生")
    private String doctor;

    @ApiModelProperty(value = "下处方日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] prescriptionDate;

    @ApiModelProperty(value = "处方类别")
    private String prescriptionCategory;

    @ApiModelProperty(value = "处方内容")
    private String prescriptionContent;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
