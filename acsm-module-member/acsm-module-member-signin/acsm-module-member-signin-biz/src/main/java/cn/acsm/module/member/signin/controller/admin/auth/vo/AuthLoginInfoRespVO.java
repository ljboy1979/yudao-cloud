package cn.acsm.module.member.signin.controller.admin.auth.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 会员授权登录信息记录 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AuthLoginInfoRespVO extends AuthLoginInfoBaseVO {

    @ApiModelProperty(value = "用基本信息表ID", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
