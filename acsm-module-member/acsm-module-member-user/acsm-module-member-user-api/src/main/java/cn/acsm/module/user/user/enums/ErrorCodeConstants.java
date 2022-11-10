package cn.acsm.module.user.user.enums;


import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * User 错误码枚举类
 *
 * User，使用 1-010-000-000 段
 */
public interface ErrorCodeConstants {
    ErrorCode USER_INFO_NOT_EXISTS = new ErrorCode(1010000000, "用户基本信息不存在");
    ErrorCode WEIXIN_DEPLOY_INFO_NOT_EXISTS = new ErrorCode(1010000001, "微信公众号配置信息不存在");
    ErrorCode WEIXIN_LOGIN_INFO_NOT_EXISTS = new ErrorCode(1010000002, "微信登录信息记录不存在");
    ErrorCode MEMBER_USER_NOT_EXISTS = new ErrorCode(1010000003, "用户不存在");
    ErrorCode TENANTID_NOT_EXISTS = new ErrorCode(1010000004, "租户编号参数缺失");
    ErrorCode WECHAT_CONFIGURATION_NOT_EXISTS = new ErrorCode(1010000005, "该租户下未配置微信公众号信息");
}
