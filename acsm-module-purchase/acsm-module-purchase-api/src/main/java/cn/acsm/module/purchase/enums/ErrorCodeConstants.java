package cn.acsm.module.purchase.enums;


import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * signin 错误码枚举类
 *
 * signin，使用 1-011-000-000 段
 */
public interface ErrorCodeConstants {


    // ========== 采购单 TODO 1011000010 ==========
    ErrorCode ORDER_NOT_EXISTS = new ErrorCode(1011000100, "采购单不存在");
    ErrorCode ORDER_CREATE_ERROR = new ErrorCode(1011000101, "采购单创建失败");
    ErrorCode ORDER_STATUS_ONE_NOT_EXISTS = new ErrorCode(1011000102, "当前采购单状态为未开始的不存在");
    ErrorCode ORDER_STATUS_TWO_NOT_EXISTS = new ErrorCode(1011000102, "当前采购单状态为执行中的不存在");
    ErrorCode ORDER_STATUS_2 = new ErrorCode(1011000102, "当前采购单状态为有效的不存在");

    // ========== 采购单明细 TODO 1011000011 ==========
    ErrorCode DETAILS_NOT_EXISTS = new ErrorCode(1011000200, "采购单明细不存在");

    // ========== 采购交付表 TODO 1011000012 ==========
    ErrorCode DELIVER_NOT_EXISTS = new ErrorCode(1011000300, "采购交付不存在");
    ErrorCode DELIVER_TRANSBOUNDARY = new ErrorCode(1011000301, "货品名称- 包装规格，累计交付数量已超出采购数量，请调整交付数量");

    // ========== 收货标准表 TODO 1011000013 ==========
    ErrorCode RECEIVING_STANDARD_NOT_EXISTS = new ErrorCode(1011000400, "收货标准不存在");

    // ========== 采购询价单表 TODO 1011000014 ==========
    ErrorCode INQUIRY_NOT_EXISTS = new ErrorCode(1011000500, "采购询价单不存在");
    ErrorCode INQUIRY_STATUS_0 = new ErrorCode(1011000501, "当前采购询价单状态非未发布");
    ErrorCode INQUIRY_DELETE_WHERE = new ErrorCode(1011000502, "当前发布状态为已发布,不可删除");

    // ========== 采购询价单电子表 TODO 1011000014 ==========
    ErrorCode INQUIRY_DETAIL_NOT_EXISTS = new ErrorCode(1011000600, "采购询价电子表不存在");
    ErrorCode INQUIRY_DETAIL_STATUS_0 = new ErrorCode(1011000601, "当前采购询价单明细状态为以发布,不可修改");

    // ========== 采购报价单表 TODO 1011000015 ==========
    ErrorCode QUOTATION_NOT_EXISTS = new ErrorCode(1011000700, "采购报价单表不存在");
    ErrorCode QUOTATION_SUBMIT_STATUS_0 = new ErrorCode(1011000701, "当前采购报价单已提交,不可修改");

    // ========== 采购报价单电子表 TODO 1011000016 ==========
    ErrorCode QUOTATION_ELECTRONIC_NOT_EXISTS = new ErrorCode(1011000800, "采购报价单电子不存在");

    // ========== 损耗表 TODO 1011000017 ==========
    ErrorCode LOSS_NOT_EXISTS = new ErrorCode(1011000900, "损耗不存在");
}
