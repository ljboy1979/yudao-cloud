package cn.acsm.module.resource.dal.dataobject.adoptcontenthealth;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 服务资源-认养物/租凭物就医记录 DO
 *
 * @author smile
 */
@TableName("resource_adopt_content_health")
@KeySequence("resource_adopt_content_health_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdoptContentHealthDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 关联认养物/租凭物
     */
    private String adoptContentId;
    /**
     * 类型
     */
    private String type;
    /**
     * 评估时间
     */
    private Date assessment;
    /**
     * 评估人
     */
    private String assessmenter;
    /**
     * 评估结果
     */
    private String assessmentResult;
    /**
     * 简要概述
     */
    private String description;
    /**
     * 公司名称
     */
    private String companyName;
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
