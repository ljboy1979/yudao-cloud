package cn.acsm.module.production.tunnel.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {

    // ========== 信息 TODO 280000000 ==========

    ErrorCode INFO_NOT_EXISTS = new ErrorCode(280000001, "地块信息不存在");
    ErrorCode INFO_SOIL_ENV_NOT_EXISTS = new ErrorCode(280000002, "地块土壤环境不存在");

    ErrorCode COST_BOOK_NOT_EXISTS = new ErrorCode(280000003, "地块账本不存在");
}
