package cn.acsm.module.wallet.enums;


import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * wallet 错误码枚举类
 *
 * wallet，使用 1-012-000-000 段
 */
public interface ErrorCodeConstants {
    ErrorCode INFO_NOT_EXISTS = new ErrorCode(1012000000, "钱包信息不存在");
    ErrorCode BANK_CARDS_INFO_NOT_EXISTS = new ErrorCode(1012000001, "关联银行卡子不存在");
    ErrorCode TRANSACTION_HISTORY_NOT_EXISTS = new ErrorCode(1012000002, "钱包交易记录子不存在");

    // ========== 微信支付相关 1012001000 ==========
    ErrorCode WECHAT_CONFIG_INFO_NOT_EXISTS = new ErrorCode(1012001000, "微信支付配置信息不存在");

}
