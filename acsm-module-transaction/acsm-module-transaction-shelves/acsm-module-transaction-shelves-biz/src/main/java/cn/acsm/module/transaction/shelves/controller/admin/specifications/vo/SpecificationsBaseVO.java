package cn.acsm.module.transaction.shelves.controller.admin.specifications.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 货架规格 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class SpecificationsBaseVO {

    @ApiModelProperty(value = "货架id")
    private String shelvesId;

    @ApiModelProperty(value = "来源id")
    private String sourceId;

    @ApiModelProperty(value = "规格名称")
    private String specificationsName;

    @ApiModelProperty(value = "规格")
    private String specifications;

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

    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "图片")
    private String imgUrl;

    @ApiModelProperty(value = "上架数量")
    private BigDecimal addNum;

    @ApiModelProperty(value = "可销售量")
    private BigDecimal availableNum;

    @ApiModelProperty(value = "销量")
    private BigDecimal salesNum;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

}
