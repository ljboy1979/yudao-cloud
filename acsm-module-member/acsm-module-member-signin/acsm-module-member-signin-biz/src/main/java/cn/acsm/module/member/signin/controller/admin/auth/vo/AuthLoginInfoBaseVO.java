package cn.acsm.module.member.signin.controller.admin.auth.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 会员授权登录信息记录 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AuthLoginInfoBaseVO {

    @ApiModelProperty(value = "openid")
    private String openId;

    @ApiModelProperty(value = "用户手机号")
    private String phone;

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "性别(0女，1男)")
    private Long sex;

    @ApiModelProperty(value = "类型 1-微信")
    private Long type;

    @ApiModelProperty(value = "状态（0正常 1停用）", required = true)
    @NotNull(message = "状态（0正常 1停用）不能为空")
    private Integer status;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
