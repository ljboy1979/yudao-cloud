package cn.acsm.module.transaction.shelves.dal.dataobject.specifications;

import lombok.*;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 货架规格 DO
 *
 * @author 芋道源码
 */
@TableName("shelves_specifications")
@KeySequence("shelves_specifications_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecificationsDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 货架id
     */
    private String shelvesId;
    /**
     * 来源id
     */
    private String sourceId;
    /**
     * 规格名称
     */
    private String specificationsName;
    /**
     * 包装类型(0定装1散装)
     */
    private String packagingType;
    /**
     * 包装类型名称
     */
    private String packagingTypeName;
    /**
     * 规格数量
     */
    private String number;
    /**
     * 单位
     */
    private String unit;
    /**
     * 单位名称
     */
    private String unitName;
    /**
     * 包装单位
     */
    private String packaging;
    /**
     * 包装单位名称
     */
    private String packagingName;
    /**
     * 计量单位
     */
    private String measurementUnit;
    /**
     * 计量单位名称
     */
    private String measurementUnitName;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
    /**
     * 图片
     */
    private String imgUrl;
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
     * 备注
     */
    private String remark;
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
