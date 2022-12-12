package cn.iocoder.yudao.module.system.enums.enterprisebaseinfo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description:行政区划状态枚举
 * @Date: 2022/12/9
 * @author: lihongyan
 */
@Getter
@AllArgsConstructor
public enum AreaEnum {

    NORMAL("0"), // 正常
    UNUSED("1"), // 停用
    ;

    /**
     * 状态
     */
    private final String status;

}
