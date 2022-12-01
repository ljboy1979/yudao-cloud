package cn.acsm.module.member.user.enums;

/**
 * Infra 字典类型的枚举类
 *
 * @author 芋道源码
 */
public interface DictTypeConstants {

    String REDIS_TIMEOUT_TYPE = "member_redis_timeout_type"; // Redis 超时类型
    String JOB_STATUS = "member_job_status"; // 定时任务状态的枚举
    String JOB_LOG_STATUS = "member_job_log_status"; // 定时任务日志状态的枚举
    String API_ERROR_LOG_PROCESS_STATUS = "member_api_error_log_process_status"; // API 错误日志的处理状态的枚举
    String CONFIG_TYPE = "member_config_type"; // 参数配置类型
    String BOOLEAN_STRING = "member_boolean_string"; // Boolean 是否类型

    String AUDIT_STATUS = "audit_status"; // 审核状态
    String MEMBER_ROLE = "member_role"; // 会员角色
    String MEMBER_TYPE = "member_type"; // 会员类型
    String LEVEL_DISCOUNT = "level_discount"; // 等级优惠

}
