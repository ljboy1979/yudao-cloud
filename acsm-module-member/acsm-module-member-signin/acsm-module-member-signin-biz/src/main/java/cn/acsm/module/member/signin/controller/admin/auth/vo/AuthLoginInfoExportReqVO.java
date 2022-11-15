package cn.acsm.module.member.signin.controller.admin.auth.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 会员授权登录信息记录 Excel 导出 Request VO", description = "参数和 AuthLoginInfoPageReqVO 是一致的")
@Data
public class AuthLoginInfoExportReqVO {

    @ApiModelProperty(value = "openid")
    private String openId;

    @ApiModelProperty(value = "用户手机号")
    private String phone;

    @ApiModelProperty(value = "会员id")
    private String memberId;

    @ApiModelProperty(value = "性别(0女，1男)")
    private String sex;

    @ApiModelProperty(value = "类型 1-微信")
    private String type;

    @ApiModelProperty(value = "状态（0正常 1停用）")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
