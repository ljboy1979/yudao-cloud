package cn.acsm.module.resource.dal.dataobject.expertevaluation;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 健康状况 DO
 *
 * @author smile
 */
@TableName("resource_expert_evaluation")
@KeySequence("resource_expert_evaluation_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpertEvaluationDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 评估人
     */
    private String evaluationPerson;
    /**
     * 异常项
     */
    private String exceptionItem;
    /**
     * 评估时间
     */
    private Date evaluationTime;
    /**
     * 评估结果
     */
    private String evaluationResult;
    /**
     * 关联认养物/租凭物
     */
    private String adoptContentId;
    /**
     * 行为
     */
    private String behavior;
    /**
     * 被毛
     */
    private String coat;
    /**
     * 食欲
     */
    private String appetite;
    /**
     * 牙齿
     */
    private String teeth;
    /**
     * 眼睛
     */
    private String eyes;
    /**
     * 鼻部
     */
    private String nose;
    /**
     * 躯干
     */
    private String trunk;
    /**
     * 排便
     */
    private String defecation;
    /**
     * 体温
     */
    private String temperature;
    /**
     * 心跳
     */
    private String heartbeat;
    /**
     * 呼吸
     */
    private String breathing;
    /**
     * 体重
     */
    private String weight;
    /**
     * 行为异常介绍
     */
    private String behaviorContent;
    /**
     * 被毛异常介绍
     */
    private String coatContent;
    /**
     * 食欲异常介绍
     */
    private String appetiteContent;
    /**
     * 牙齿异常介绍
     */
    private String teethContent;
    /**
     * 眼睛异常介绍
     */
    private String eyesContent;
    /**
     * 鼻部异常介绍
     */
    private String noseContent;
    /**
     * 躯干异常介绍
     */
    private String trunkContent;
    /**
     * 排便异常介绍
     */
    private String defecationContent;
    /**
     * 体温异常介绍
     */
    private String temperatureContent;
    /**
     * 心跳异常介绍
     */
    private String heartbeatContent;
    /**
     * 呼吸异常介绍
     */
    private String breathingContent;
    /**
     * 体重异常介绍
     */
    private String weightContent;
    /**
     * 类型 type=1体检记录；type=0专家评估
     */
    private String type;
    /**
     * 排尿
     */
    private String micturition;
    /**
     * 排尿异常介绍
     */
    private String micturitionContent;
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
