package cn.acsm.module.user.user.controller.admin.wechat.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 微信登录信息记录 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class WeixinLoginInfoBaseVO {

    @ApiModelProperty(value = "openid")
    private String openid;

    @ApiModelProperty(value = "用户手机号")
    private String phone;

    @ApiModelProperty(value = "系统的user_id")
    private String systemUserId;

    @ApiModelProperty(value = "用户头像地址")
    private String avatar;

    @ApiModelProperty(value = "省份名称")
    private String province;

    @ApiModelProperty(value = "市名称")
    private String city;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "性别(0女，1男)")
    private String sex;

    @ApiModelProperty(value = "类型 1-微信")
    private String type;

    @ApiModelProperty(value = "状态（0正常 1停用）", required = true)
    @NotNull(message = "状态（0正常 1停用）不能为空")
    private Integer status;

}
