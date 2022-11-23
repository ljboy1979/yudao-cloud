package cn.acsm.module.member.signin.controller.admin.config.vo;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 会员登录授权配置信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AuthConfigInfoUpdateReqVO extends AuthConfigInfoBaseVO {

    @ApiModelProperty(value = "主键ID", required = true)
    @NotNull(message = "主键ID不能为空")
    private Long id;

}
