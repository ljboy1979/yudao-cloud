package cn.iocoder.yudao.module.transaction.sales.controller.admin.inputsinfo.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 投入品 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class InputsInfoExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("类型(农药,化肥,物料,种子)")
    private String inputsType;

    @ExcelProperty("投入品名称")
    private String inputsName;

    @ExcelProperty("种类")
    private String inputsKind;

    @ExcelProperty("生产厂家")
    private String manufacturer;

    @ExcelProperty("有效成分")
    private String activeIngredients;

    @ExcelProperty("包装规格")
    private String packingSpecification;

    @ExcelProperty("产品剂型")
    private String productDosageForm;

    @ExcelProperty("picture")
    private String picture;

    @ExcelProperty("每亩最高用量")
    private BigDecimal standardUse;

    @ExcelProperty("标准用量")
    private BigDecimal unitConsumption;

    @ExcelProperty("条形码")
    private String barCode;

    @ExcelProperty("包装类型")
    private String packagingType;

    @ExcelProperty("计量单位")
    private String measureUnit;

    @ExcelProperty("状态（0正常 1不可修改）")
    private String state;

    @ExcelProperty("单位")
    private String unit;

    @ExcelProperty("数量")
    private String num;

    @ExcelProperty("采购价（单价）")
    private BigDecimal purchasePrice;

    @ExcelProperty("供应商")
    private String supplier;

    @ExcelProperty("安全期")
    private Integer secureDays;

    @ExcelProperty("项目类型")
    private String projectType;

    @ExcelProperty("投入品编码")
    private String inputsCode;

    @ExcelProperty("投入品批次号")
    private String inputsBatch;

    @ExcelProperty("单位名称")
    private String unitNames;

    @ExcelProperty("包装规格名称")
    private String packingSpecificationNames;

    @ExcelProperty("中华水产专用，图片，多张逗号隔开")
    private String inputsinfoImage;

    @ExcelProperty("供应商")
    private String refactsupplier;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("source")
    private String source;

}
