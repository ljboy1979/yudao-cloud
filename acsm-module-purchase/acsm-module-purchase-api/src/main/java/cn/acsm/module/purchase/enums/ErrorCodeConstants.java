package cn.acsm.module.purchase.enums;


import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * signin 错误码枚举类
 *
 * signin，使用 1-011-000-000 段
 */
public interface ErrorCodeConstants {


    // ========== 采购单 TODO 1011000010 ==========
    ErrorCode PURCHASE_NOT_EXISTS = new ErrorCode(1011000010, "采购单不存在");

    // ========== 采购单明细 TODO 1011000011 ==========
    ErrorCode DETAILS_NOT_EXISTS = new ErrorCode(1011000011, "采购单明细不存在");

    // ========== 采购交付表 TODO 1011000012 ==========
    ErrorCode DELIVER_NOT_EXISTS = new ErrorCode(1011000012, "采购交付不存在");

    // ========== 采购交付表 TODO 1011000013 ==========
    ErrorCode RECEIVING_STANDARD_NOT_EXISTS = new ErrorCode(1011000013, "收货标准不存在");
}
