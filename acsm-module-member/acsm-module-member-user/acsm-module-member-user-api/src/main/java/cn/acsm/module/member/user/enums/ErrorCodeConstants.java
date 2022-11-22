package cn.acsm.module.member.user.enums;


import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * User 错误码枚举类
 *
 * User，使用 1-010-000-000 段
 */
public interface ErrorCodeConstants {
    ErrorCode USER_NOT_EXISTS = new ErrorCode(1010000000, "会员不存在");
    ErrorCode MEMBER_USER_NOT_EXISTS = new ErrorCode(1010000001, "会员不存在");
    ErrorCode TENANTID_NOT_EXISTS = new ErrorCode(1010000002, "租户编号参数缺失");
    ErrorCode WECHAT_CONFIGURATION_NOT_EXISTS = new ErrorCode(1010000003, "该租户下未配置微信公众号信息");
    ErrorCode USER_PASSWORD_FAILED = new ErrorCode(1010001004, "密码校验失败");

    // ========== AUTH 模块 1010001000 ==========
    ErrorCode AUTH_LOGIN_BAD_CREDENTIALS = new ErrorCode(1010001000, "登录失败，账号密码不正确");
    ErrorCode AUTH_LOGIN_USER_DISABLED = new ErrorCode(1010001001, "登录失败，账号被禁用");
    ErrorCode AUTH_TOKEN_EXPIRED = new ErrorCode(1010001004, "Token 已经过期");
    ErrorCode AUTH_THIRD_LOGIN_NOT_BIND = new ErrorCode(1010001005, "未绑定账号，需要进行绑定");
    ErrorCode AUTH_WEIXIN_MINI_APP_PHONE_CODE_ERROR = new ErrorCode(1010001006, "获得手机号失败");

    // ========== 用户收件地址 1010002000 ==========
    ErrorCode ADDRESS_NOT_EXISTS = new ErrorCode(1010002000, "用户收件地址不存在");

}
