package cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 特医食品使用记录表 Excel 导出 Request VO", description = "参数和 SpecialMedicalFoodRecordsPageReqVO 是一致的")
@Data
public class SpecialMedicalFoodRecordsExportReqVO {

    @ApiModelProperty(value = "健康档案id")
    private Long patientHealthId;

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "医院")
    private String hospital;

    @ApiModelProperty(value = "科室")
    private String department;

    @ApiModelProperty(value = "营养师名称")
    private String doctor;

    @ApiModelProperty(value = "使用时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] specialMedicalDate;

    @ApiModelProperty(value = "特医食品类别")
    private String specialMedicalCategory;

    @ApiModelProperty(value = "特医食品内容")
    private String specialMedicalContent;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
