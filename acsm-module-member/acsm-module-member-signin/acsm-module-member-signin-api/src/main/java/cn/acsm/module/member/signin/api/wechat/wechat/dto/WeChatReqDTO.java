package cn.acsm.module.member.signin.api.wechat.wechat.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * wechat Request DTO
 *
 * @author lihongyan
 */
@ApiModel("微信请求DTO")
@Data
public class WeChatReqDTO {

    /**
     *  ID
     */
    private Long id;
    /**
     * 公众号appId
     */
    @ApiModelProperty(value = "公众号appId")
    private String appid;
    /**
     * 公众号appSecret
     */
    @ApiModelProperty(value = "公众号appSecret")
    private String appsecret;
    /**
     * 商户号
     */
    @ApiModelProperty(value = "商户号")
    private String mchId;
    /**
     * 商户密钥key
     */
    @ApiModelProperty(value = "商户密钥key")
    private String mchKey;
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
