package cn.acsm.module.member.user.controller.admin.integral.vo.record;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 会员积分记录 Excel 导出 Request VO", description = "参数和 IntegralRecordPageReqVO 是一致的")
@Data
public class IntegralRecordExportReqVO {

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "会员账号")
    private String memberAccount;

    @ApiModelProperty(value = "会员名称")
    private String memberName;

    @ApiModelProperty(value = "评分项目")
    private Long ratingItems;

    @ApiModelProperty(value = "本次积分变动")
    private String integralChange;

    @ApiModelProperty(value = "当前剩余积分")
    private String integralRemaining;

    @ApiModelProperty(value = "积分使用明细")
    private String integralUseDetails;

    @ApiModelProperty(value = "积分变动时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] integralChangeTime;

    @ApiModelProperty(value = "图片")
    private String picture;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "评分分数")
    private String ratingScore;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
