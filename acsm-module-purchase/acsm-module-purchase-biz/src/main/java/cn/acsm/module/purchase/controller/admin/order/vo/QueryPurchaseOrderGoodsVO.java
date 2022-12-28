package cn.acsm.module.purchase.controller.admin.order.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <pre>
 * 对象功能: QueryPurchaseOrderGoodsVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/28
 * <pre>
 */
@Data
public class QueryPurchaseOrderGoodsVO implements Serializable {

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
     * 包装规格
     */
    private String specifications;

    /**
     * 库存数量
     */
    private Integer inventoryQuantity;

    /**
     * 计量单位
     */
    private String measureUnit;

}
