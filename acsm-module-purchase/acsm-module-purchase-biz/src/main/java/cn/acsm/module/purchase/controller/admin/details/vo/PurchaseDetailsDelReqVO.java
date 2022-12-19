package cn.acsm.module.purchase.controller.admin.details.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <pre>
 * 对象功能: PurchaseDetailsDelReqVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/19
 * <pre>
 */
@Data
public class PurchaseDetailsDelReqVO implements Serializable {

    @ApiModelProperty(value = "采购单明细id", required = true)
    private Long id;

    @ApiModelProperty(value = "采购单号", required = true)
    private String purchaseNumber;

}
