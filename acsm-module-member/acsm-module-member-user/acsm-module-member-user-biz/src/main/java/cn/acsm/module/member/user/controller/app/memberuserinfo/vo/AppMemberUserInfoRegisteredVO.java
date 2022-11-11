package cn.acsm.module.member.user.controller.app.memberuserinfo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@ApiModel("用户 APP - 用户基本信息 用户注册参数 VO")
@Data
public class AppMemberUserInfoRegisteredVO {

    @ApiModelProperty(value = "微信code")
    private String code;

    @ApiModelProperty(value = "租户编号")
    private String tenantId;

    @ApiModelProperty(value = "加密数据")
    private String encryptedData;

    @ApiModelProperty(value = "加密算法的初始向量")
    private String iv;

    @ApiModelProperty(value = "标识")
    private String appletFlag;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "微信openId")
    private String openId;


}
