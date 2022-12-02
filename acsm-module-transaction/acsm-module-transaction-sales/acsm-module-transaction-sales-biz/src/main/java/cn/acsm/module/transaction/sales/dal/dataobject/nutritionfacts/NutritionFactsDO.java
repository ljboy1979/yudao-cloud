package cn.acsm.module.transaction.sales.dal.dataobject.nutritionfacts;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 营养成分 DO
 *
 * @author 芋道源码
 */
@TableName("sales_nutrition_facts")
@KeySequence("sales_nutrition_facts_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NutritionFactsDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 类型（0菜品、1套餐、2特医食品）
     */
    private String type;
    /**
     * 来源id（菜品、套餐、特医食品）
     */
    private String sourceId;
    /**
     * 编号
     */
    private String number;
    /**
     * 营养成分(字典id)
     */
    private String nutritionFacts;
    /**
     * 营养成分名称
     */
    private String nutritionFactsName;
    /**
     * 含量
     */
    private String content;
    /**
     * 单位(字典id)
     */
    private String unit;
    /**
     * 单位名称
     */
    private String unitName;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 经营主体id
     */
    private String subjectId;
    /**
     * source
     */
    private String source;

}
