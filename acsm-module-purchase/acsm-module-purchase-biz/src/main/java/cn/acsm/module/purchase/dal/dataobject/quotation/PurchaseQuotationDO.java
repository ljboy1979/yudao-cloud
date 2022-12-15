package cn.acsm.module.purchase.dal.dataobject.quotation;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

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
    private Long quoteId;
    /**
     * 报价单名称
     */
    private String quoteName;
    /**
     * 采购商id
     */
    private Long purchaserId;
    /**
     * 询价单编号
     */
    private Long enquiryId;
    /**
     * 报价有效期
     */
    private Date indateDate;
    /**
     * 是否提交 0：未提交 1：已提交
     */
    private Boolean submitStatus;
    /**
     * 经营主体
     */
    private String subjectId;

}
