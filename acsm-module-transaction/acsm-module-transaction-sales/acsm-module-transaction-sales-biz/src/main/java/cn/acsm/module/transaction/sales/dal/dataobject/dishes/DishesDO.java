package cn.acsm.module.transaction.sales.dal.dataobject.dishes;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 菜品 DO
 *
 * @author 芋道源码
 */
@TableName("sales_dishes")
@KeySequence("sales_dishes_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DishesDO extends BaseDO {

    /**
     * 菜品id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 菜品编号
     */
    private String ingredientNumber;
    /**
     * 菜品名称
     */
    private String dishesName;
    /**
     * 菜品分类
     */
    private String menuClassification;
    /**
     * 菜系
     */
    private String cuisine;
    /**
     * 烹饪方式
     */
    private String cookingStyle;
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
