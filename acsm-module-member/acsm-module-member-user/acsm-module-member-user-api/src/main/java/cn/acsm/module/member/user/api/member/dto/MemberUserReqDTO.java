package cn.acsm.module.member.user.api.member.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * MemberUser Request DTO
 *
 * @author lihongyan
 */
@ApiModel("会员请求DTO")
@Data
public class MemberUserReqDTO {
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private Long id;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String nickname;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String avatar;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Integer status;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * 注册 IP
     */
    @ApiModelProperty(value = "注册 IP")
    private String registerIp;
    /**
     * 最后登录IP
     */
    @ApiModelProperty(value = "最后登录IP")
    private String loginIp;
    /**
     * 最后登录时间
     */
    @ApiModelProperty(value = "最后登录时间")
    private LocalDateTime loginDate;
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

    /**
     * 多租户编号
     */
    @ApiModelProperty(value = "多租户编号")
    private Long tenantId;

}
