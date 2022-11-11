package cn.acsm.module.member.user.controller.admin.wechat.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 微信登录信息记录 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WeixinLoginInfoRespVO extends WeixinLoginInfoBaseVO {

    @ApiModelProperty(value = "用基本信息表ID", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
