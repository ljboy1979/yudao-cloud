package cn.acsm.module.member.user.controller.admin.member.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 会员信息 Excel 导出 Request VO", description = "参数和 MemberUserDetailPageReqVO 是一致的")
@Data
public class MemberUserDetailExportReqVO {

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "企业id")
    private Long enterpriseId;

    @ApiModelProperty(value = "企业名称")
    private String enterpriseName;

    @ApiModelProperty(value = "会员类型")
    private Integer memberType;

    @ApiModelProperty(value = "会员角色")
    private Integer memberRole;

    @ApiModelProperty(value = "会员等级id")
    private Long integralLevelId;

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
