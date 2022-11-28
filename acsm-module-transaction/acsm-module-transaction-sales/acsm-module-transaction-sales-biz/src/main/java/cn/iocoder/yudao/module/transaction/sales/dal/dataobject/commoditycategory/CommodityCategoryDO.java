package cn.iocoder.yudao.module.transaction.sales.dal.dataobject.commoditycategory;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 商品分类 DO
 *
 * @author 芋道源码
 */
@TableName("sales_commodity_category")
@KeySequence("sales_commodity_category_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommodityCategoryDO extends BaseDO {

    /**
     * 商品分类id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 商品分类名称
     */
    private String commodityCategoryName;
    /**
     * 父级编号
     */
    private String parentCode;
    /**
     * 所有父级编号
     */
    private String parentCodes;
    /**
     * 本级排序号（升序）
     */
    private BigDecimal treeSort;
    /**
     * 所有级别排序号
     */
    private String treeSorts;
    /**
     * 是否最末级
     */
    private String treeLeaf;
    /**
     * 层次级别
     */
    private BigDecimal treeLevel;
    /**
     * 全节点名
     */
    private String treeNames;
    /**
     * 0 渠道商商品 1农资商城商品 多个使用逗号隔开
     */
    private String type;
    /**
     * 0单条新增1批量新增
     */
    private String state;
    /**
     * 图片路径
     */
    private String imgUrl;
    /**
     * 排序序号
     */
    private String order;
    /**
     * 商品类型，1为农资商场
     */
    private String commodityType;
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
