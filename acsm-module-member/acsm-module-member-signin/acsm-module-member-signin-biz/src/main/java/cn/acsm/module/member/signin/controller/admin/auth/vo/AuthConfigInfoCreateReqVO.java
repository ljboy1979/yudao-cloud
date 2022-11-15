package cn.acsm.module.member.signin.controller.admin.auth.vo;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 会员登录授权配置信息创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AuthConfigInfoCreateReqVO extends AuthConfigInfoBaseVO {

}
