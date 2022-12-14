package cn.acsm.module.purchase.dal.dataobject.quotation;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 采购询价电子 DO
 *
 * @author 芋道源码
 */
@TableName("purchase_quotation")
@KeySequence("purchase_quotation_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseQuotationDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 报价单编号
     */
    private String quotationNo;
    /**
     * 报价单名称
     */
    private String quotationName;
    /**
     * 采购商id
     */
    private Long purchaserId;
    /**
     * 询价单id
     */
    private Long inquiryId;
    /**
     * 询价单编号
     */
    private String inquiryNo;
    /**
     * 报价有效期
     */
    private Date quotationValidTime;
    /**
     * 是否提交 0：未提交 1：已提交
     */
    private Boolean isSubmit;
    /**
     * 经营主体
     */
    private String subjectId;

}
