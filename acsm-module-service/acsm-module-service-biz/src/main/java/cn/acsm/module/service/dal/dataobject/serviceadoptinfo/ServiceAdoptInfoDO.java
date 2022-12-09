package cn.acsm.module.service.dal.dataobject.serviceadoptinfo;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 认养信息 DO
 *
 * @author smile
 */
@TableName("service_service_adopt_info")
@KeySequence("service_service_adopt_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceAdoptInfoDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 服务id
     */
    private String serviceId;
    /**
     * 地块id
     */
    private String tunnelId;
    /**
     * 认养物id
     */
    private String adoptId;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 是否已认购 0未认购，1已认购
     */
    private String adoptStatus;
    /**
     * 家庭成员id
     */
    private String familyId;
    /**
     * 可种植作物
     */
    private String plantCropId;
    /**
     * 可种植作物数量
     */
    private String plantCropNum;
    /**
     * 基地id
     */
    private String basesId;
    /**
     * 区域id
     */
    private String partitionsId;
    /**
     * 载体id(关联认养物/租凭物)
     */
    private String carrierId;
    /**
     * 可认购数量
     */
    private String applyNum;
    /**
     * 已认购数量
     */
    private String applySubNum;
    /**
     * 认养类型 0,菜田 1 牧场
     */
    private String adoptType;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 项目来源
     */
    private String source;

}
