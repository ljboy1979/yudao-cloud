package cn.acsm.module.production.devices.dal.dataobject.model;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 设备型号 DO
 *
 * @author 芋道源码
 */
@TableName("devices_model")
@KeySequence("devices_model_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 厂家
     */
    private String manufacturerId;
    /**
     * 型号
     */
    private String name;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
