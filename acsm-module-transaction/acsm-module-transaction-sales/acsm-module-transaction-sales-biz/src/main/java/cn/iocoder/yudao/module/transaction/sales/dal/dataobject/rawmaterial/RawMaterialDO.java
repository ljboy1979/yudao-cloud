package cn.iocoder.yudao.module.transaction.sales.dal.dataobject.rawmaterial;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 原料 DO
 *
 * @author 芋道源码
 */
@TableName("sales_raw_material")
@KeySequence("sales_raw_material_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterialDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 原料编号
     */
    private String ingredientNumber;
    /**
     * 分类id
     */
    private String classify;
    /**
     * 原料名称
     */
    private String name;
    /**
     * 产地(字典值)
     */
    private String origin;
    /**
     * 原料图片
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
