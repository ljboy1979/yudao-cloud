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
    ErrorCode MEMBER_ID_NOT_EXISTS = new ErrorCode(1010001005, "会员ID参数缺失");

    // ========== AUTH 模块 1010001000 ==========
    ErrorCode AUTH_LOGIN_BAD_CREDENTIALS = new ErrorCode(1010001000, "登录失败，账号密码不正确");
    ErrorCode AUTH_LOGIN_USER_DISABLED = new ErrorCode(1010001001, "登录失败，账号被禁用");
    ErrorCode AUTH_TOKEN_EXPIRED = new ErrorCode(1010001004, "Token 已经过期");
    ErrorCode AUTH_THIRD_LOGIN_NOT_BIND = new ErrorCode(1010001005, "未绑定账号，需要进行绑定");
    ErrorCode AUTH_WEIXIN_MINI_APP_PHONE_CODE_ERROR = new ErrorCode(1010001006, "获得手机号失败");

    // ========== 用户收件地址 1010002000 ==========
    ErrorCode ADDRESS_NOT_EXISTS = new ErrorCode(1010002000, "用户收件地址不存在");

    // ========== 健康档案 1010003000 ============
    ErrorCode PATIENT_HEALTH_NOT_EXISTS = new ErrorCode(1010003000, "健康档案不存在");
    ErrorCode PATIENT_HEALTH_BOUND = new ErrorCode(1010003001, "您已绑定！请勿重复绑定！谢谢");
    ErrorCode HOSPITAL_HIS_NOT_REGISTERED = new ErrorCode(1010003002, "该患者信息尚未登记入医院系统，请核对输入信息，或联系客服，谢谢");
    ErrorCode HOSPITAL_ADMISSION_RECORD_NOT_EXISTS = new ErrorCode(1010003003, "住院记录不存在");
    ErrorCode MEDICAL_HISTORY_RECORD_NOT_EXISTS = new ErrorCode(1010003004, "病史记录不存在");
    ErrorCode MEDICAL_RECORD_NOT_EXISTS = new ErrorCode(1010003005, "医嘱记录不存在");
    ErrorCode NUTRITION_EXAMINATION_RECORD_NOT_EXISTS = new ErrorCode(1010003006, "营养检查记录不存在");
    ErrorCode PRESCRIPTION_RECORD_NOT_EXISTS = new ErrorCode(1010003007, "处方记录表不存在");
    ErrorCode SPECIAL_MEDICAL_FOOD_RECORDS_NOT_EXISTS = new ErrorCode(1010003008, "特医食品使用记录表不存在");

    // ========== 会员积分 1010004000 ============
    ErrorCode INTEGRAL_LEVEL_NOT_EXISTS = new ErrorCode(1010004000, "会员积分等级不存在");
    ErrorCode INTEGRAL_RECORD_NOT_EXISTS = new ErrorCode(1010004001, "会员积分记录不存在");
    ErrorCode INTEGRAL_RULES_NOT_EXISTS = new ErrorCode(1010004002, "会员积分规则不存在");

    // ========== 代理商管理 1010005000 ============
    ErrorCode AGENT_MANAGEMENT_NOT_EXISTS = new ErrorCode(1010005000, "代理商管理不存在");

    // ========== 专业资质 1010006000 ============
    ErrorCode PROFESSIONAL_QUALIFICATION_NOT_EXISTS = new ErrorCode(1010006000, "专业资质不存在");


    ErrorCode ENTERPRISE_ASSOCIATION_NOT_EXISTS = new ErrorCode(1010006000, "会员企业关联不存在");

}
