package cn.iocoder.yudao.module.transaction.sales.controller.admin.inputsinfo.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 投入品 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class InputsInfoBaseVO {

    @ApiModelProperty(value = "类型(农药,化肥,物料,种子)")
    private String inputsType;

    @ApiModelProperty(value = "投入品名称")
    private String inputsName;

    @ApiModelProperty(value = "种类")
    private String inputsKind;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    @ApiModelProperty(value = "有效成分")
    private String activeIngredients;

    @ApiModelProperty(value = "包装规格")
    private String packingSpecification;

    @ApiModelProperty(value = "产品剂型")
    private String productDosageForm;

    @ApiModelProperty(value = "picture")
    private String picture;

    @ApiModelProperty(value = "每亩最高用量")
    private BigDecimal standardUse;

    @ApiModelProperty(value = "标准用量")
    private BigDecimal unitConsumption;

    @ApiModelProperty(value = "条形码")
    private String barCode;

    @ApiModelProperty(value = "包装类型")
    private String packagingType;

    @ApiModelProperty(value = "计量单位")
    private String measureUnit;

    @ApiModelProperty(value = "状态（0正常 1不可修改）")
    private String state;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "数量")
    private String num;

    @ApiModelProperty(value = "采购价（单价）")
    private BigDecimal purchasePrice;

    @ApiModelProperty(value = "供应商")
    private String supplier;

    @ApiModelProperty(value = "安全期")
    private Integer secureDays;

    @ApiModelProperty(value = "项目类型")
    private String projectType;

    @ApiModelProperty(value = "投入品编码")
    private String inputsCode;

    @ApiModelProperty(value = "投入品批次号")
    private String inputsBatch;

    @ApiModelProperty(value = "单位名称")
    private String unitNames;

    @ApiModelProperty(value = "包装规格名称")
    private String packingSpecificationNames;

    @ApiModelProperty(value = "中华水产专用，图片，多张逗号隔开")
    private String inputsinfoImage;

    @ApiModelProperty(value = "供应商")
    private String refactsupplier;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;
    @ApiModelProperty(value = "专家建议")
    private String expertAdvice;

}
