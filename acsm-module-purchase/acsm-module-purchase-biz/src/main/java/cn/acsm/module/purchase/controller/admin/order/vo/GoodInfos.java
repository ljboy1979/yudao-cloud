package cn.acsm.module.purchase.controller.admin.order.vo;

import lombok.Data;

/**
 * <pre>
 * 对象功能: GoodInfos.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/18
 * <pre>
 */
@Data
public class GoodInfos {

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 规格id
     */
    private Long packagingSpecificationId;

    /**
     * 包装规格
     */
    private String packagingSpecification;

    /**
     * 计量单位
     */
    private String unit;

    /**
     * 包装类型
     */
    private String packagingType;

    /**
     * 采购数量/重量
     */
    private Double buyNumber;



}
