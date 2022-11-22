package cn.acsm.module.member.signin.enums;


import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * signin 错误码枚举类
 *
 * signin，使用 1-011-000-000 段
 */
public interface ErrorCodeConstants {
    ErrorCode AUTH_CONFIG_INFO_NOT_EXISTS = new ErrorCode(1011000000, "会员登录授权配置信息不存在");
    ErrorCode AUTH_LOGIN_INFO_NOT_EXISTS = new ErrorCode(1011000001, "会员授权登录信息记录不存在");
    ErrorCode SOURCE_NOT_EXISTS = new ErrorCode(1011000002, "租户集合source参数缺失");
    ErrorCode WECHAT_CONFIGURATION_NOT_EXISTS = new ErrorCode(1011000003, "该租户下未配置微信公众号信息");
}
