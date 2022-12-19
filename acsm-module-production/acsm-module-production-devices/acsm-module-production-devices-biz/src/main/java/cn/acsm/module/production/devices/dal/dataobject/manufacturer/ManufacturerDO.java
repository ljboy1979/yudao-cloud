package cn.acsm.module.production.devices.dal.dataobject.manufacturer;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 设备厂家 DO
 *
 * @author 芋道源码
 */
@TableName("devices_manufacturer")
@KeySequence("devices_manufacturer_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 厂家
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
