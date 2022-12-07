package cn.acsm.module.transaction.shelves.enums;


import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {

    // ========== 货架 TODO 2100000000 ==========
    ErrorCode SHELVES_NOT_EXISTS = new ErrorCode(2100000000, "货架不存在");
    ErrorCode SPECIFICATIONS_NOT_EXISTS = new ErrorCode(2100000001, "货架规格不存在");
    ErrorCode STOCK_RECORD_NOT_EXISTS = new ErrorCode(2100000002, "货架库存记录不存在");
    ErrorCode STOCK_CLASSIFY_NOT_EXISTS = new ErrorCode(2100000003, "库存分类不存在");
    ErrorCode CONFIG_NUMBER_EXISTS = new ErrorCode(2000000015, "生成编码失败，异常信息");
    ErrorCode NUMBER_GET_LOCK_EXISTS= new ErrorCode(2000000016, "编码获取锁失败，异常信息");


}
