package cn.acsm.module.purchase.dal.dataobject.inquiry;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 采购询价电子 DO
 *
 * @author 芋道源码
 */
@TableName("purchase_inquiry")
@KeySequence("purchase_inquiry_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseInquiryDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 商品id
     */
    private Long commodityId;
    /**
     * 分类id
     */
    private Long commodityCategoryId;
    /**
     * 规格id
     */
    private Long productSpecificationsId;
    /**
     * 计划数量最低
     */
    private String plannedQuantityMin;
    /**
     * 计划数量最高
     */
    private String plannedQuantityMax;
    /**
     * 经营主体
     */
    private String subjectId;

}
