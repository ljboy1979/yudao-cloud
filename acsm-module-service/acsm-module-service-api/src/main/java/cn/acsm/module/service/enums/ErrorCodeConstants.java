package cn.acsm.module.service.enums;


import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * signin 错误码枚举类
 *
 * signin，使用 1-011-000-000 段
 */
public interface ErrorCodeConstants {

    ErrorCode CONFIG_NUMBER_EXISTS = new ErrorCode(1011001, "生成编码失败，异常信息");
    ErrorCode NUMBER_GET_LOCK_EXISTS= new ErrorCode(1011002, "编码获取锁失败，异常信息");

    // ========== 认养物/租凭物 TODO 1011000001 ==========
    ErrorCode ADOPT_CONTENT_NOT_EXISTS = new ErrorCode(1011000001, "认养物/租凭物不存在");
    // ========== 服务资源-生产品种 TODO 1011000002 ==========
    ErrorCode PRODUCTION_SCORES_NOT_EXISTS = new ErrorCode(1011000002, "服务资源-生产品种不存在");
    // ========== 服务资源-养护记录 TODO 1011000003 ==========
    ErrorCode MAINTENANCE_RECORD_NOT_EXISTS = new ErrorCode(1011000002, "服务资源-养护记录不存在");
    // ========== 服务资源-认养物/租凭物就医记录 TODO 1011000004 ==========
    ErrorCode ADOPT_CONTENT_HEALTH_NOT_EXISTS = new ErrorCode(1011000004, "服务资源-认养物/租凭物就医记录不存在");
    // ========== 健康状况 TODO 1011000005 ==========
    ErrorCode EXPERT_EVALUATION_NOT_EXISTS = new ErrorCode(1011000005, "健康状况不存在");
    // ========== 认养/租凭价格 TODO 1011000006 ==========
    ErrorCode ADOPT_CONTENT_ADOPT_PRICE_NOT_EXISTS = new ErrorCode(1011000006, "认养/租凭价格不存在");
    // ========== 认养/租凭权益 TODO 1011000007 ==========
    ErrorCode ADOPT_RIGHT_NOT_EXISTS = new ErrorCode(1011000007, "认养/租凭权益不存在");
    // ========== 服务-认养物/租凭物 TODO 1011000008 ==========
    ErrorCode INFO_CARRIER_NOT_EXISTS = new ErrorCode(1011000008, "服务-认养物/租凭物不存在");
    // ========== 服务 TODO 1011000009 ==========
    ErrorCode INFO_NOT_EXISTS = new ErrorCode(1011000009, "服务不存在");
    // ========== 认养信息 TODO 1011000010 ==========
    ErrorCode ADOPT_INFO_NOT_EXISTS = new ErrorCode(1011000010, "认养信息不存在");
    // ========== 时间排期 TODO 1011000011 ==========
    ErrorCode ACTIVITY_SESSION_NOT_EXISTS = new ErrorCode(1011000011, "时间排期不存在");
    // ========== 套票详情 TODO 1011000012 ==========
    ErrorCode TICKET_DETAIL_NOT_EXISTS = new ErrorCode(1011000012, "套票详情不存在");
    // ========== 套票 TODO 1011000013 ==========
    ErrorCode TICKET_PACKAGE_NOT_EXISTS = new ErrorCode(1011000013, "套票不存在");
    // ========== 服务交易单 TODO 1011000014 ==========
    ErrorCode ORDER_NOT_EXISTS = new ErrorCode(1011000014, "服务交易单不存在");
    // ========== 服务客户名单 TODO 1011000015 ==========
    ErrorCode CUSTOMER_LIST_NOT_EXISTS = new ErrorCode(1011000015, "服务客户名单不存在");





}
