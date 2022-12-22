package cn.acsm.module.purchase.controller.admin.order.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * 对象功能: QueryPurchaseOrderPageInfoVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/20
 * <pre>
 */
@Data
public class QueryPurchaseOrderPageInfoVO implements Serializable {

    /**
     * 编号
     */
    @TableId
    private Long id;

    /**
     * 采购单号
     */
    private String purchaseNumber;

    /**
     * 采购类型(1:原料 2:投入品 3:成品 4:办公用品)
     */
    private Integer purchaseType;

    /**
     * 供应商(用户id)
     */
    private Long providerId;

    /**
     * 供应商名称
     */
    private String providerName;

    /**
     * 供应商联系方式
     */
    private String providerPhone;

    /**
     * 采购时间【开始时间】
     */
    private Date purchaseStartTime;

    /**
     * 采购时间【结束时间】
     */
    private Date purchaseEndTime;

    /**
     * 产地
     */
    private String address;

    /**
     * 货品编号
     */
    private Long goodsId;

    /**
     * 货品名称
     */
    private String goodsName;

    /**
     * 包装规格id
     */
    private Long packagingSpecificationId;

    /**
     * 采购数量/重量
     */
    private BigDecimal buyNumber;

    /**
     * 期望到货频次
     */
    private String frequency;

}
