package cn.acsm.module.transaction.shelves.dal.dataobject.confignumber;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 货架表当天最新编号 DO
 *
 * @author 芋道源码
 */
@TableName("shelves_config_number")
@KeySequence("shelves_config_number_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
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
    @TableId(type = IdType.INPUT)
    private String tableName;
    /**
     * 日期
     */
    private Date time;
    /**
     * 每天最新计数
     */
    private Integer number;

}
