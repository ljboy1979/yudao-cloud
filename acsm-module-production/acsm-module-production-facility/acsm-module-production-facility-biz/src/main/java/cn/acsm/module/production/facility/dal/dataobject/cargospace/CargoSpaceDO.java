package cn.acsm.module.production.facility.dal.dataobject.cargospace;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 设施货位 DO
 *
 * @author 芋道源码
 */
@TableName("facility_cargo_space")
@KeySequence("facility_cargo_space_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CargoSpaceDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 货位号
     */
    private String spaceCode;
    /**
     * 行数
     */
    private Integer spaceRowNumber;
    /**
     * 列数
     */
    private Integer spaceColumnNumber;
    /**
     * 层数
     */
    private Integer spaceLayerNumber;
    /**
     * 设施
     */
    private Integer facilityId;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
