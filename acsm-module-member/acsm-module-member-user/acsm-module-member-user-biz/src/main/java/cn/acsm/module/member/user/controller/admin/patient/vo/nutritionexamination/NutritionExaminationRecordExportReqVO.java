package cn.acsm.module.member.user.controller.admin.patient.vo.nutritionexamination;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 营养检查记录 Excel 导出 Request VO", description = "参数和 NutritionExaminationRecordPageReqVO 是一致的")
@Data
public class NutritionExaminationRecordExportReqVO {

    @ApiModelProperty(value = "健康档案id")
    private Long patientHealthId;

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "医院")
    private String hospital;

    @ApiModelProperty(value = "科室")
    private String department;

    @ApiModelProperty(value = "检查医生")
    private String doctor;

    @ApiModelProperty(value = "检查日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] checkDate;

    @ApiModelProperty(value = "检查类别")
    private String checkCategory;

    @ApiModelProperty(value = "检查内容")
    private String checkContent;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
