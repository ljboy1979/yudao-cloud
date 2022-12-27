package cn.acsm.module.transaction.sales.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel("货架响应DTO")
@Data
public class ShelvesSalesRespDto {
    @ApiModelProperty("id")
    private String id;


    @ApiModelProperty("售品名称")
    private String salesName;


    @ApiModelProperty("分类名称")
    private String classifyName;

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

    @ApiModelProperty(value = "规格")
    private String specifications;
}
