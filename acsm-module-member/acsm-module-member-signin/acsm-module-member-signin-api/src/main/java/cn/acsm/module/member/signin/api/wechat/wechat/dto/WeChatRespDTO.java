package cn.acsm.module.member.signin.api.wechat.wechat.dto;

import lombok.Data;

/**
 * wechat Response DTO
 *
 * @author lihongyan
 */
@Data
public class WeChatRespDTO {

    /**
     *  ID
     */
    private Long id;
    /**
     * 公众号appId
     */
    private String appid;
    /**
     * 公众号appSecret
     */
    private String appsecret;
    /**
     * 商户号
     */
    private String mchId;
    /**
     * 商户密钥key
     */
    private String mchKey;
    /**
     * openId
     */
    private String openId;
    /**
     * 手机号码
     */
    private String phone;

}
