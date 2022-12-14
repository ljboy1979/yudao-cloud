package cn.acsm.module.purchase.dal.dataobject.quotationelectronic;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

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
    private String quotationNo;
    /**
     * 询价单明细id
     */
    private Long inquiryId;
    /**
     * 商品id
     */
    private Long commodityId;
    /**
     * 分类id
     */
    private Long classifyId;
    /**
     * 规格id
     */
    private Long specificationsId;
    /**
     * 起批数量
     */
    private Integer initialBatchCount;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
    /**
     * 采购数量
     */
    private Integer purchaseCount;
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

}
