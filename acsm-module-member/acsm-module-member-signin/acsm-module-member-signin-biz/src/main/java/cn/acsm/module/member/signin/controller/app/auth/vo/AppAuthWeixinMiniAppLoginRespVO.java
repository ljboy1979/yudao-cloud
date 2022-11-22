package cn.acsm.module.member.signin.controller.app.auth.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * wechat Response VO
 *
 * @author lihongyan
 */
@ApiModel("用户 APP - 微信小程序手机登录 Response VO")
@Data
public class AppAuthWeixinMiniAppLoginRespVO {

    /**
     * 公众号appId
     */
    private String appid;
    /**
     * 公众号appSecret
     */
    private String appsecret;
    /**
     * openId
     */
    private String openId;
    /**
     * 手机号码
     */
    private String phone;

}
