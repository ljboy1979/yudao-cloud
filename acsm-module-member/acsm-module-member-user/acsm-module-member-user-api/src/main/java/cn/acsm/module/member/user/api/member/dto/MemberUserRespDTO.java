package cn.acsm.module.member.user.api.member.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * MemberUser Response DTO
 *
 * @author lihongyan
 */
@ApiModel("会员响应DTO")
@Data
public class MemberUserRespDTO {
    /**
     * 编号
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 密码
     */
    private String password;
    /**
     * 注册 IP
     */
    private String registerIp;
    /**
     * 最后登录IP
     */
    private String loginIp;
    /**
     * openid
     */
    private String openId;
    /**
     * 最后登录时间
     */
    private LocalDateTime loginDate;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

    /**
     * 多租户编号
     */
    private Long tenantId;

}
