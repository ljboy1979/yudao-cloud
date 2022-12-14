package cn.acsm.module.purchase.dal.dataobject.inquiry;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

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
     * 询价单编号
     */
    private String inquiryNo;
    /**
     * 商品id
     */
    private Long productId;
    /**
     * 分类id
     */
    private Long classifyId;
    /**
     * 规格id
     */
    private Long specificationsId;
    /**
     * 计划数量最低
     */
    private Integer lowestPlannedQuantity;
    /**
     * 计划数量最高
     */
    private Integer highestPlannedQuantity;
    /**
     * 经营主体
     */
    private String subjectId;

}
