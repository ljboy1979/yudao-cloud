package cn.acsm.module.purchase.dal.dataobject.quotationelectronic;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购报价单电子 DO
 *
 * @author 芋道源码
 */
@TableName("purchase_quotation_electronic")
@KeySequence("purchase_quotation_electronic_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseQuotationElectronicDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 报价单id
     */
    private Long quotationId;
    /**
     * 报价单编号
     */
    private String quoteId;
    /**
     * 询价单明细编号
     */
    private Long inquiryDetailId;
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
    private String specificationsId;
    /**
     * 起批数量
     */
    private String batchNumber;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 采购数量
     */
    private String orderSize;
    /**
     * 总价
     */
    private BigDecimal totalPrice;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 经营主体
     */
    private String subjectId;

    /**
     * 租户
     */
    private String tenantId;
    /**
     * userId
     */
    private String userId;

    /**
     * 租户集合
     */
    private String sourceId;

}
