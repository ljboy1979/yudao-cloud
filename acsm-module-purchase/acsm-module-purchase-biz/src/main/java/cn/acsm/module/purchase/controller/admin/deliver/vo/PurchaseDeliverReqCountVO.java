package cn.acsm.module.purchase.controller.admin.deliver.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <pre>
 * 对象功能: PurchaseDeliverReqCountVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/19
 * 功能：获取交付数量VO
 * <pre>
 */
@Data
public class PurchaseDeliverReqCountVO {

    @ApiModelProperty(value = "采购明细单id", required = true)
    private Long purchaseDetailsId;

    @ApiModelProperty(value = "采购单编号", required = true)
    private String purchase_number;

}
