package cn.acsm.module.member.user.controller.admin.integral.vo.record;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.TIME_ZONE_DEFAULT;

/**
* 会员积分记录 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class IntegralRecordBaseVO {

    @ApiModelProperty(value = "会员id", required = true)
    @NotNull(message = "会员id不能为空")
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
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = TIME_ZONE_DEFAULT)
    private Date integralChangeTime;

    @ApiModelProperty(value = "图片")
    private String picture;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "评分分数")
    private String ratingScore;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
