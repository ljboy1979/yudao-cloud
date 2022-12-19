package cn.acsm.module.production.devices.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {

    // ========== 基地信息 TODO 260000000 ==========

    ErrorCode INFO_NOT_EXISTS = new ErrorCode(260000001, "设备不存在");
    ErrorCode TIME_NOT_EXISTS = new ErrorCode(260000002, "设备运行时间不存在");
    ErrorCode PARAMS_CFG_NOT_EXISTS = new ErrorCode(260000003, "设备参数配置不存在");
    ErrorCode PARAMETER_NOT_EXISTS = new ErrorCode(260000004, "设备表参数不存在");

    ErrorCode MODEL_NOT_EXISTS = new ErrorCode(260000005, "设备型号不存在");
    ErrorCode MANUFACTURER_NOT_EXISTS = new ErrorCode(260000006, "设备厂家不存在");

    ErrorCode ALARM_RULE_NOT_EXISTS = new ErrorCode(260000007, "告警规则不存在");

    ErrorCode ALARM_NOTIFIER_NOT_EXISTS = new ErrorCode(260000008, "告警通知规则不存在");

    ErrorCode ALARM_INFO_NOT_EXISTS = new ErrorCode(260000009, "告警信息不存在");

    ErrorCode ACCESS_NOT_EXISTS = new ErrorCode(260000010, "设备允许访问名单信息不存在");

}

