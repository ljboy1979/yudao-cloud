package cn.acsm.module.resource.dal.dataobject.productionscores;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 服务资源-生产品种 DO
 *
 * @author smile
 */
@TableName("resource_production_scores")
@KeySequence("resource_production_scores_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductionScoresDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 关联认养物/租凭物
     */
    private String serviceAdoptContentId;
    /**
     * 关联生产品种
     */
    private String productionScoresId;
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
