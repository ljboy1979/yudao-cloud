package cn.acsm.module.stock.enums;


import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * signin 错误码枚举类
 *
 * signin，使用 1-011-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== 库存清单 1011000110 ==========
    ErrorCode INVENTORY_NOT_EXISTS = new ErrorCode(1011000110, "库存清单不存在");

    // ========== 库存记录 1011000120 ==========
    ErrorCode RECORD_NOT_EXISTS = new ErrorCode(1011000120, "库存记录不存在");

    // ========== 库存记录字表-明细 1011000130 ==========
    ErrorCode RECORD_DETAIL_NOT_EXISTS = new ErrorCode(1011000130, "库存记录字表-明细不存在");
    ErrorCode RECORD_DETAIL_EXISTS = new ErrorCode(1011000131, "已有出库记录，不可删除");

    // ========== 盘点记录 1011000140 ==========
    ErrorCode INVENTORY_RECORD_NOT_EXISTS = new ErrorCode(1011000140, "盘点记录不存在");

    // ========== 盘点记录表子表-明细 1011000140 ==========
    ErrorCode INVENTORY_RECORD_DETAIL_NOT_EXISTS = new ErrorCode(1011000140, "盘点记录表子表-明细不存在");

}
