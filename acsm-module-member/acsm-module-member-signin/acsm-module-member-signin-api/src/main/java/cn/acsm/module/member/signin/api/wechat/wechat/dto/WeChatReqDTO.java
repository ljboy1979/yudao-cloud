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
     * 微信code
     */
    @ApiModelProperty(value = "微信code")
    private String code;

    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    private Long tenantId;

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

    /**
     * 租户集合
     */
    @ApiModelProperty(value = "租户集合")
    private Long source;
    /**
     * 经营主体ID
     */
    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
