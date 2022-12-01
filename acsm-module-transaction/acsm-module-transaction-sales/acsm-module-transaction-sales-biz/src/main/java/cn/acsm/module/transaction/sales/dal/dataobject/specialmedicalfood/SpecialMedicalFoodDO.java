package cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfood;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 特医食品 DO
 *
 * @author 芋道源码
 */
@TableName("sales_special_medical_food")
@KeySequence("sales_special_medical_food_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecialMedicalFoodDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 特医食品编号
     */
    private String number;
    /**
     * 特医食品名称
     */
    private String name;
    /**
     * 特医食品分类id
     */
    private String classify;
    /**
     * 特医食品图片
     */
    private String imgUrl;
    /**
     * 备注
     */
    private String remark;
    /**
     * 专家建议
     */
    private String expertAdvice;
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
