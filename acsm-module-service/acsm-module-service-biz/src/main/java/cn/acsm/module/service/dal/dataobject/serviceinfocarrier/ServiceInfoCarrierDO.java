package cn.acsm.module.service.dal.dataobject.serviceinfocarrier;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 服务-认养物/租凭物 DO
 *
 * @author smile
 */
@TableName("service_service_info_carrier")
@KeySequence("service_service_info_carrier_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceInfoCarrierDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 认养物/租凭物的id
     */
    private String adoptContentAdoptId;
    /**
     * 服务的id
     */
    private String serviceInfoId;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 项目来源
     */
    private String source;

}
