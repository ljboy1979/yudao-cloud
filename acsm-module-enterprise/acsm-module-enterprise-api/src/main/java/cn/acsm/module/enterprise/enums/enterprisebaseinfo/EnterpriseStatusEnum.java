package cn.acsm.module.enterprise.enums.enterprisebaseinfo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 短信的模板类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum EnterpriseStatusEnum {

    NORMA("1"), // 正常
    UNUSED("2"), // 停用
    ;

    /**
     * 类型
     */
    private final String status;

}
