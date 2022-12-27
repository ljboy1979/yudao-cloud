package cn.acsm.module.transaction.sales.controller.admin.packagespecification.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 套餐规格 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PackageSpecificationBaseVO {

    @ApiModelProperty(value = "套餐id")
    private String packageId;

    @ApiModelProperty(value = "规格名称", required = true)
    @NotNull(message = "规格名称不能为空")
    private String specificationsName;

    @ApiModelProperty(value = "包装类型(0定装1散装)", required = true)
    @NotNull(message = "包装类型(0定装1散装)不能为空")
    private String packagingType;

    @ApiModelProperty(value = "包装类型名称", required = true)
    @NotNull(message = "包装类型名称不能为空")
    private String packagingTypeName;

    @ApiModelProperty(value = "规格数量", required = true)
   // @NotNull(message = "规格数量不能为空")
    private String number;

    @ApiModelProperty(value = "单位", required = true)
    //@NotNull(message = "单位不能为空")
    private String unit;

    @ApiModelProperty(value = "单位名称", required = true)
    //@NotNull(message = "单位名称不能为空")
    private String unitName;

    @ApiModelProperty(value = "包装单位", required = true)
    //@NotNull(message = "包装单位不能为空")
    private String packaging;

    @ApiModelProperty(value = "包装单位名称", required = true)
    //@NotNull(message = "包装单位名称不能为空")
    private String packagingName;

    @ApiModelProperty(value = "计量单位", required = true)
    @NotNull(message = "计量单位不能为空")
    private String measurementUnit;

    @ApiModelProperty(value = "计量单位名称", required = true)
    @NotNull(message = "计量单位名称不能为空")
    private String measurementUnitName;

    @ApiModelProperty(value = "采购价")
    private BigDecimal purchasePrice;

    @ApiModelProperty(value = "售出价")
    private BigDecimal sellingPrice;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "状态", required = true)
    //@NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

}
