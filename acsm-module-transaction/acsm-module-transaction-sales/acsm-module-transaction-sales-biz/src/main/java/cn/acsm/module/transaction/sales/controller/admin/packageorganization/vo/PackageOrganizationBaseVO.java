package cn.acsm.module.transaction.sales.controller.admin.packageorganization.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 套餐组成 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PackageOrganizationBaseVO {

    @ApiModelProperty(value = "套餐id", required = true)
    @NotNull(message = "套餐id不能为空")
    private String packageId;

    @ApiModelProperty(value = "0商品 1菜品", required = true)
    @NotNull(message = "0商品 1菜品不能为空")
    private String type;

    @ApiModelProperty(value = "来源id(商品id/菜品id)", required = true)
    @NotNull(message = "来源id(商品id/菜品id)不能为空")
    private String sourceId;

    @ApiModelProperty(value = "规格id", required = true)
    @NotNull(message = "规格id不能为空")
    private String specificationId;

    @ApiModelProperty(value = "分类", required = true)
    @NotNull(message = "分类不能为空")
    private String classify;

    @ApiModelProperty(value = "组成编号")
    private String organizationNumber;

    @ApiModelProperty(value = "组成名称")
    private String organizationName;

    @ApiModelProperty(value = "数量")
    private Integer num;

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

    @ApiModelProperty(value = "售出价")
    private BigDecimal sellingPrice;

    @ApiModelProperty(value = "菜系")
    private String cuisine;

    @ApiModelProperty(value = "烹饪方式")
    private Boolean cookingStyle;

    @ApiModelProperty(value = "套餐组成图片")
    private String imgUrl;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

}
