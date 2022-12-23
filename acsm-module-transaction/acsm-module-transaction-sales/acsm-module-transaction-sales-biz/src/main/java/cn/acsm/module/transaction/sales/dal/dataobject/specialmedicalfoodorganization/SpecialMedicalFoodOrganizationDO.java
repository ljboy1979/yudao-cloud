package cn.acsm.module.transaction.sales.dal.dataobject.specialmedicalfoodorganization;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 特医食品组成 DO
 *
 * @author 芋道源码
 */
@TableName("sales_special_medical_food_organization")
@KeySequence("sales_special_medical_food_organization_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecialMedicalFoodOrganizationDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 特医食品id
     */
    private String foodId;
    /**
     * 组成编号
     */
    private String organizationNumber;
    /**
     * 组成名称
     */
    private String organizationName;
    /**
     * 产地
     */
    private String origin;
    /**
     * 采购价
     */
    private BigDecimal purchasePrice;
    /**
     * 图片路径
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
