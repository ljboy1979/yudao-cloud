package cn.acsm.module.transaction.pricetag.controller.admin.marketcommodity.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 市场商品 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class MarketCommodityBaseVO {

    @ApiModelProperty(value = "货架id")
    @NotNull(message = "货架id不能为空")
    private String shelvesId;

    @ApiModelProperty(value = "规格id")
    @NotNull(message = "规格id不能为空")
    private String specificationId;

    @ApiModelProperty(value = "分类id", required = true)
    @NotNull(message = "分类id不能为空")
    private String classifyId;

    @ApiModelProperty(value = "商品编号")
    private String commodityCode;

    @ApiModelProperty(value = "商品名称")
    @NotNull(message = "商品名称不能为空")
    private String commodityName;

    @ApiModelProperty(value = "市场id", required = true)
    @NotNull(message = "市场id不能为空")
    private String marketId;

    @ApiModelProperty(value = "规格名称")
    @NotNull(message = "规格名称不能为空")
    private String specificationsName;

    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    @ApiModelProperty(value = "包装类型(0定装1散装)")
    private String packagingType;

    @ApiModelProperty(value = "包装类型名称")
    private String packagingTypeName;

    @ApiModelProperty(value = "规格数量")
    private String number;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "单位名称")
    private String unitName;

    @ApiModelProperty(value = "包装单位")
    private String packaging;

    @ApiModelProperty(value = "包装单位名称")
    private String packagingName;

    @ApiModelProperty(value = "计量单位")
    private String measurementUnit;

    @ApiModelProperty(value = "计量单位名称")
    private String measurementUnitName;

    @ApiModelProperty(value = "产地")
    private String productionAddress;

    @ApiModelProperty(value = "来源")
    private String source;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

}
