package cn.acsm.module.enterprise.enums;


import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * signin 错误码枚举类
 *
 * signin，使用 1-011-000-000 段
 */
public interface ErrorCodeConstants {

    ErrorCode BASE_INFO_NOT_EXISTS = new ErrorCode(1012000001, "经营主体不存在");
    ErrorCode OTHER_ACCOUNT_INFO_NOT_EXISTS = new ErrorCode(1012000002, "经营主体其他账户不存在");
    ErrorCode OTHER_CERTIFICATE_INFO_NOT_EXISTS = new ErrorCode(1012000003, "经营主体其他证件不存在");
    ErrorCode POLICY_SUBSIDIES_INFO_NOT_EXISTS = new ErrorCode(1012000004, "企业政策补贴信息不存在");


}
