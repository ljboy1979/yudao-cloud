package cn.acsm.module.resource.dal.dataobject.maintenancerecord;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 服务资源-养护记录 DO
 *
 * @author smile
 */
@TableName("resource_maintenance_record")
@KeySequence("resource_maintenance_record_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceRecordDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 关联认养物/租凭物
     */
    private String serviceAdoptContentId;
    /**
     * 养护人
     */
    private String maintenanceName;
    /**
     * 内容
     */
    private String content;
    /**
     * 开始时间
     */
    private Date beginTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 项目来源
     */
    private String source;
    /**
     * 经营主体id
     */
    private String subjectId;

}
