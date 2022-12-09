package cn.acsm.module.service.dal.dataobject.confignumber;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 当天最新编号 DO
 *
 * @author 芋道源码
 */
@TableName("service_config_number")
@KeySequence("service_config_number_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigNumberDO extends BaseDO {

    /**
     * 对应表名
     */
    private String tableName;
    /**
     * 日期
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyyMMdd")
    private Date time;
    /**
     * 每天最新计数
     */
    private Integer number;

}
