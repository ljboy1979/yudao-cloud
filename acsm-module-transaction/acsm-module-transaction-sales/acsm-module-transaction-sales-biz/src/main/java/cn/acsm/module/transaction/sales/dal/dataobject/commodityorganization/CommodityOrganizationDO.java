package cn.acsm.module.transaction.sales.dal.dataobject.commodityorganization;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 商品组成 DO
 *
 * @author 芋道源码
 */
@TableName("sales_commodity_organization")
@KeySequence("sales_commodity_organization_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommodityOrganizationDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 原料表id
     */
    private String rawMaterialId;
    /**
     * 商品id
     */
    private String commodityId;
    /**
     * 组成编号
     */
    private String organizationNumber;
    /**
     * 组成名称
     */
    private String organizationName;
    /**
     * 分类
     */
    private String classify;
    /**
     * 产地
     */
    private String origin;
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
