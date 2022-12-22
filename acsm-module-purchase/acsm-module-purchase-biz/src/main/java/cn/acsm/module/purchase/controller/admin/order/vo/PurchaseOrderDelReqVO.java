package cn.acsm.module.purchase.controller.admin.order.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <pre>
 * 对象功能: PurchaseOrderDelReqVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/19
 * <pre>
 */
@Data
public class PurchaseOrderDelReqVO {

    @ApiModelProperty(value = "采购单id", required = true)
    private Long id;

    @ApiModelProperty(value = "采购单号", required = true)
    private String purchaseNumber;

    @ApiModelProperty(value = "采购单状态", required = true)
    private Integer purchaseStatus;

}
