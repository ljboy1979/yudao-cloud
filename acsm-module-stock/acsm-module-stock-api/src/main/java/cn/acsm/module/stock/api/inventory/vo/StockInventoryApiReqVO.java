package cn.acsm.module.stock.api.inventory.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <pre>
 * 对象功能: StockInventoryApiReqVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/26
 * <pre>
 */
@Data
public class StockInventoryApiReqVO implements Serializable {

    @ApiModelProperty(value = "货品id")
    private Long goodsId;

    @ApiModelProperty(value = "货品名称")
    private String goodsName;

    @ApiModelProperty(value = "货品类型")
    private String goodsType;

    @ApiModelProperty(value = "规格名称")
    private String packingSpecification;

    @ApiModelProperty(value = "规格类型")
    private String packagingType;

    @ApiModelProperty(value = "库存数量")
    private String inventoryQuantity;

    @ApiModelProperty(value = "计量单位")
    private String measureUnit;

}
