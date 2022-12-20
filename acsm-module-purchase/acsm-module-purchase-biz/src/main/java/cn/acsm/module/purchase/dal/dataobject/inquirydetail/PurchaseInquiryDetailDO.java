package cn.acsm.module.purchase.dal.dataobject.inquirydetail;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 采购询价电子表 DO
 *
 * @author 芋道源码
 */
@TableName("purchase_inquiry_detail")
@KeySequence("purchase_inquiry_detail_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseInquiryDetailDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 询价单编号
     */
    private String enquiryId;
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
    private Integer plannedQuantityMin;
    /**
     * 计划数量最高
     */
    private Integer plannedQuantityMax;
    /**
     * 租户
     */
    private Long tenantId;
    /**
     * 经营主体
     */
    private Long subjectId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 租户集合
     */
    private Long sourceId;

}
