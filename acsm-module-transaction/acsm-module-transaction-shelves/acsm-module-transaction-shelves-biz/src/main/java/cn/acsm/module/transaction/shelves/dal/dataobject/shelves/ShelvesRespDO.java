package cn.acsm.module.transaction.shelves.dal.dataobject.shelves;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@ApiModel("货架响应DTO")
@Data
public class ShelvesRespDO {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("名称")
    private String name;


    @ApiModelProperty(value = "包装类型(0定装1散装)")
    private String packagingType;

    @ApiModelProperty(value = "规格数量")
    private String number;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "包装单位")
    private String packaging;

    @ApiModelProperty(value = "计量单位")
    private String measurementUnit;

    @ApiModelProperty(value = "采购价")
    private BigDecimal purchasePrice;

    @ApiModelProperty(value = "售出价")
    private BigDecimal sellingPrice;

    @ApiModelProperty(value = "包装类型名称")
    private String packagingTypeName;

    @ApiModelProperty(value = "单位名称")
    private String unitName;

    @ApiModelProperty(value = "包装单位名称")
    private String packagingName;

    @ApiModelProperty(value = "计量单位名称")
    private String measurementUnitName;
}
