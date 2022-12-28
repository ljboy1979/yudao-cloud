package cn.acsm.module.transaction.pricetag.controller.admin.scheduledprice.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 预定价格 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ScheduledPriceBaseVO {

    @ApiModelProperty(value = "分类id", required = true)
    @NotNull(message = "分类id不能为空")
    private String classifyId;

    @ApiModelProperty(value = "商品编号")
    private String commodityCode;

    @ApiModelProperty(value = "商品名称")
    @NotNull(message = "商品名称不能为空")
    private String commodityName;

    @ApiModelProperty(value = "市场id", required = true)
    private String marketId;

    @ApiModelProperty(value = "规格名称")
    @NotNull(message = "规格名称不能为空")
    private String specificationsName;

    @ApiModelProperty(value = "包装类型(0定装1散装)")
    @NotNull(message = "包装类型不能为空")
    private String packagingType;

    @ApiModelProperty(value = "包装类型名称")
    @NotNull(message = "包装类型名称不能为空")
    private String packagingTypeName;

    @ApiModelProperty(value = "规格数量")
    @NotNull(message = "规格数量不能为空")
    private String number;

    @ApiModelProperty(value = "单位")
    @NotNull(message = "单位不能为空")
    private String unit;

    @ApiModelProperty(value = "单位名称")
    @NotNull(message = "单位名称不能为空")
    private String unitName;

    @ApiModelProperty(value = "包装单位")
    @NotNull(message = "包装单位不能为空")
    private String packaging;

    @ApiModelProperty(value = "包装单位名称")
    @NotNull(message = "包装单位名称不能为空")
    private String packagingName;

    @ApiModelProperty(value = "计量单位")
    @NotNull(message = "计量单位不能为空")
    private String measurementUnit;

    @ApiModelProperty(value = "计量单位名称")
    @NotNull(message = "计量单位名称不能为空")
    private String measurementUnitName;

    @ApiModelProperty(value = "不包邮预定价")
    @NotNull(message = "不包邮预定价不能为空")
    private BigDecimal freeShippingPrice;

    @ApiModelProperty(value = "包邮预定价")
    @NotNull(message = "包邮预定价不能为空")
    private BigDecimal shippingPrice;

    @ApiModelProperty(value = "有效期")
    private Date expirationDate;

    @ApiModelProperty(value = "来源")
    private String source;


    @ApiModelProperty(value = "状态", required = true)
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "分类名称")
    private String categoryName;


    @ApiModelProperty(value = "规格id")
    private String specificationId;
}
