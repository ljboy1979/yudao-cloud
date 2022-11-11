package cn.acsm.module.member.wallet.enums;


import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * wallet 错误码枚举类
 *
 * wallet，使用 1-011-000-000 段
 */
public interface ErrorCodeConstants {
    ErrorCode USER_WALLET_INFO_NOT_EXISTS = new ErrorCode(1011000000, "用户钱包信息不存在");
}
