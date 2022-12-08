package cn.acsm.module.transaction.order.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {

    // ========== 价格牌 TODO 240000000 ==========
    ErrorCode INFO_NOT_EXISTS = new ErrorCode(240000000, "订单不存在");
    ErrorCode DELIVERY_INFO_NOT_EXISTS = new ErrorCode(240000001, "配送不存在");
    ErrorCode RESERVE_INFO_NOT_EXISTS = new ErrorCode(240000002, "预定订单不存在");
    ErrorCode SART_INFO_NOT_EXISTS = new ErrorCode(240000003, "购物车不存在");
    ErrorCode SETTLE_INFO_NOT_EXISTS = new ErrorCode(240000004, "订单结账不存在");
    ErrorCode DELIVERY_DETAILS_NOT_EXISTS = new ErrorCode(240000005, "配送详情不存在");
    ErrorCode GIFT_INFO_NOT_EXISTS = new ErrorCode(240000006, "赠品不存在");
    ErrorCode RESERVE_DETAILS_NOT_EXISTS = new ErrorCode(240000007, "订单预定详情不存在");
    ErrorCode COST_INFO_NOT_EXISTS = new ErrorCode(240000008, "费用不存在");
    ErrorCode CONFIG_NUMBER_EXISTS = new ErrorCode(240000015, "生成编码失败，异常信息");
    ErrorCode NUMBER_GET_LOCK_EXISTS= new ErrorCode(240000016, "编码获取锁失败，异常信息");

}
