package cn.acsm.module.transaction.pricetag.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {

    // ========== 价格牌 TODO 220000000 ==========
    ErrorCode MARKET_INFO_NOT_EXISTS = new ErrorCode(220000000, "市场信息不存在");
    ErrorCode MARKET_COMMODITY_NOT_EXISTS = new ErrorCode(220000001, "市场商品不存在");
    ErrorCode MARKET_CLASSIFY_NOT_EXISTS = new ErrorCode(220000002, "市场分类不存在");
    ErrorCode MARKET_PRICE_DETAILS_NOT_EXISTS = new ErrorCode(220000003, "市场价格明细不存在");
    ErrorCode MARKET_PRICE_NOT_EXISTS = new ErrorCode(220000004, "市场价格不存在");
    ErrorCode SCHEDULED_PRICE_NOT_EXISTS = new ErrorCode(220000005, "预定价格不存在");
    ErrorCode CONFIG_NUMBER_EXISTS = new ErrorCode(220000015, "生成编码失败，异常信息");
    ErrorCode NUMBER_GET_LOCK_EXISTS= new ErrorCode(220000016, "编码获取锁失败，异常信息");


}
