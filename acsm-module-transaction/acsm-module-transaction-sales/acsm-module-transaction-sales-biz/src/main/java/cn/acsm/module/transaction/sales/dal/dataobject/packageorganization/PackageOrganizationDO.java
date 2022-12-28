package cn.acsm.module.transaction.sales.dal.dataobject.packageorganization;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 套餐组成 DO
 *
 * @author 芋道源码
 */
@TableName("sales_package_organization")
@KeySequence("sales_package_organization_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PackageOrganizationDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 套餐id
     */
    private String packageId;
    /**
     * 2商品 3菜品
     */
    private String type;
    /**
     * 来源id(商品id/菜品id)
     */
    private String sourceId;
    /**
     * 规格id
     */
    private String specificationId;

    /**
     * 规格名称
     */
    private String specificationName;
    /**
     * 分类
     */
    private String classify;

    /**
     * 分类名称
     */
    private String classifyName;
    /**
     * 组成编号
     */
    private String organizationNumber;
    /**
     * 组成名称
     */
    private String organizationName;
    /**
     * 数量
     */
    private Integer num;
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
     * 售出价
     */
    private BigDecimal sellingPrice;
    /**
     * 菜系
     */
    private String cuisine;
    /**
     * 烹饪方式
     */
    private Boolean cookingStyle;
    /**
     * 套餐组成图片
     */
    private String imgUrl;
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

