package cn.acsm.module.member.user.controller.admin.professional.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 专业资质 Excel 导出 Request VO", description = "参数和 ProfessionalQualificationPageReqVO 是一致的")
@Data
public class ProfessionalQualificationExportReqVO {

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "备案类型")
    private String recordType;

    @ApiModelProperty(value = "备案名称")
    private String recordName;

    @ApiModelProperty(value = "许可证号码")
    private String permitNo;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "备案日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private String[] recordDate;

    @ApiModelProperty(value = "证照")
    private String idPhoto;

    @ApiModelProperty(value = "审核状态")
    private Integer auditStatus;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
