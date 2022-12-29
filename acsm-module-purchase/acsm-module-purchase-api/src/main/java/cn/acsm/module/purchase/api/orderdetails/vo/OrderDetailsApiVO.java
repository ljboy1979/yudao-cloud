package cn.acsm.module.purchase.api.orderdetails.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <pre>
 * 对象功能: OrderDetailsApiVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/28
 * <pre>
 */
@Data
public class OrderDetailsApiVO implements Serializable {

    /**
     * 采购单号
     */
    private String purchaseNumber;

    /**
     * 货品名称
     */
    private String goodsName;
}
