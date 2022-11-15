package cn.acsm.module.member.signin.controller.admin.auth.vo;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 会员授权登录信息记录更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AuthLoginInfoUpdateReqVO extends AuthLoginInfoBaseVO {

    @ApiModelProperty(value = "用基本信息表ID", required = true)
    @NotNull(message = "用基本信息表ID不能为空")
    private Long id;

}
