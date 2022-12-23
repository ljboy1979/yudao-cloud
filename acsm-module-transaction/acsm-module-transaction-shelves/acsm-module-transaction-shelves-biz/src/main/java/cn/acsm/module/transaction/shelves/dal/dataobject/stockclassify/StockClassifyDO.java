package cn.acsm.module.transaction.shelves.dal.dataobject.stockclassify;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 库存分类 DO
 *
 * @author 芋道源码
 */
@TableName("shelves_stock_classify")
@KeySequence("shelves_stock_classify_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockClassifyDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 分类名称
     */
    private String classifyName;
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
    private String sort;
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

    /**
     * 备注
     */
    private String remarks;
}
