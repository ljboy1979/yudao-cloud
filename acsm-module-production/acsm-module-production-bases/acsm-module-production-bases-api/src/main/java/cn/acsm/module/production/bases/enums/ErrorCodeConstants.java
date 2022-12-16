package cn.acsm.module.production.bases.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {

    // ========== 基地信息 TODO 250000000 ==========
    ErrorCode INFO_NOT_EXISTS = new ErrorCode(250000001, "基地信息不存在");
    ErrorCode CONSUME_NOT_EXISTS = new ErrorCode(250000002, "基地能耗信息不存在");

    ErrorCode PARTITIONS_NOT_EXISTS = new ErrorCode(250000003, "分区信息不存在");

    ErrorCode PHENOLOGICAL_ENV_NOT_EXISTS = new ErrorCode(250000004, "基地物候环境不存在");

    ErrorCode PRODUCTION_CAPACITY_PLANS_NOT_EXISTS = new ErrorCode(250000005, "产能计划不存在");

    ErrorCode SOIL_ENV_NOT_EXISTS = new ErrorCode(250000006, "基地土壤环境不存在");

    ErrorCode SUBSIDY_NOT_EXISTS = new ErrorCode(250000007, "基地补贴信息不存在");

}
