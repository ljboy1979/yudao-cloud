package cn.acsm.module.purchase.controller.admin.order.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

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
     * 货品编号
     */
    private String goodsId;

    /**
     * 货品名称
     */
    private String goodsName;

    /**
     * 商品类型
     */
    private String goodsType;

    /**
     * 包装规格id
     */
    private String packagingSpecificationId;

    /**
     * 包装规格名称
     */
    private String packagingSpecificationName;

    /**
     * 包装规格类型
     */
    private String packagingType;

    /**
     * 采购数量/重量
     */
    private BigDecimal buyNumber;

    /**
     * 期望到货频次
     */
    private String frequency;

}
