package cn.iocoder.yudao.module.demo.dal.dataobject.category;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeEntity;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 商品分类 DO
 *
 * @author liuj
 */
@TableName("product_category")
@KeySequence("product_category_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
//@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDO extends TreeEntity {

    /**
     * 分类id
     */
    @TableId
    private Long id;
    /**
     * 上级分类的编号：0表示一级分类
     */
    private Long parentId;
    /**
     * 名称
     */
    private String name;
    /**
     * 分类级别：0->1级；1->2级
     */
    private Boolean level;
    /**
     * 显示状态：0->不显示；1->显示
     */
    private Boolean showStatus;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 图标
     */
    private String icon;
    /**
     * 描述
     */
    private String description;

}
