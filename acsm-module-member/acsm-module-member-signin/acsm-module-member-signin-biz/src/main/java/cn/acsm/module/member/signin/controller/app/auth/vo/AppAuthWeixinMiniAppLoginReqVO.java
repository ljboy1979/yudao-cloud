package cn.acsm.module.member.signin.controller.app.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@ApiModel("用户 APP - 微信小程序手机登录 Request VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppAuthWeixinMiniAppLoginReqVO {

    /**
     * openId
     */
    @ApiModelProperty(value = "openId")
    private String openId;
    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String phone;

    /**
     * 微信code
     */
    @ApiModelProperty(value = "微信code")
    private String code;

    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    private String tenantId;

    /**
     * 加密数据
     */
    @ApiModelProperty(value = "加密数据")
    private String encryptedData;

    /**
     * 加密算法的初始向量
     */
    @ApiModelProperty(value = "加密算法的初始向量")
    private String iv;

    /**
     * 标识
     */
    @ApiModelProperty(value = "标识")
    private String appletFlag;

}
