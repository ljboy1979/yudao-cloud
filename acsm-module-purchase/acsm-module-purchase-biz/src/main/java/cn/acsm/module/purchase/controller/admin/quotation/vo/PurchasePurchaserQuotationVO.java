package cn.acsm.module.purchase.controller.admin.quotation.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <pre>
 * 对象功能: PurchasePurchaserQuotationVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/20
 * <pre>
 */
@ApiModel("管理后台 - 查看价格牌中的报价信息 Request VO")
@Data
@ToString(callSuper = true)
public class PurchasePurchaserQuotationVO implements Serializable {

    @ApiModelProperty(value = "商品id", required = true)
    private Long commodityId;

    @ApiModelProperty(value = "规格id", required = true)
    private String specificationsId;

}
