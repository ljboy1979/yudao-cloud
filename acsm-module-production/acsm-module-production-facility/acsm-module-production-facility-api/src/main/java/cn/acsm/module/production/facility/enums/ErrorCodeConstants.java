package cn.acsm.module.production.facility.enums;


import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {

    // ========== 基地信息 TODO 270000000 ==========

    ErrorCode CONTRACT_NOT_EXISTS = new ErrorCode(270000001, "租赁合同不存在");
    ErrorCode INFO_NOT_EXISTS = new ErrorCode(270000002, "设施不存在");

    ErrorCode CARGO_SPACE_NOT_EXISTS = new ErrorCode(270000003, "设施货位不存在");

    ErrorCode MAINTENANCE_NOT_EXISTS = new ErrorCode(270000004, "设施维护记录不存在");

}

