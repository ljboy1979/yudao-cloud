package cn.acsm.module.transaction.shelves.dal.dataobject.shelves;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 货架 DO
 *
 * @author 芋道源码
 */
@TableName("shelves")
@KeySequence("shelves_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShelvesDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 分类id
     */
    private String classifyId;
    /**
     * 来源id
     */
    private String sourceId;
    /**
     * 货架编号
     */
    private String number;
    /**
     * 售品类型 0原料、1投入品、2商品、3菜品、4套餐 5特医食品
     */
    private Integer type;
    /**
     * 上架数量
     */
    private BigDecimal addNum;
    /**
     * 可销售量
     */
    private BigDecimal availableNum;
    /**
     * 销量
     */
    private BigDecimal salesNum;
    /**
     * 计量单位
     */
    private String measurementUnit;
    /**
     * 计量单位名称
     */
    private String measurementUnitName;
    /**
     * 是否上架 0下架 1上架 2禁售
     */
    private String saleState;
    /**
     * 供应日期
     */
    private Date supplyDate;
    /**
     * 餐次 0早/1中/2晚
     */
    private Integer meals;
    /**
     * 售品图片
     */
    private String imgUrl;
    /**
     * 售品视频
     */
    private String videoUrl;
    /**
     * 售品说明
     */
    private String explain;
    /**
     * 标签
     */
    private String label;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 供应商
     */
    private String vendor;
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
