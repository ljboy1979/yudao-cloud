package cn.acsm.module.transaction.sales.controller.admin.packagespecification.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 套餐规格 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PackageSpecificationExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("套餐id")
    private String packageId;

    @ExcelProperty("规格名称")
    private String specificationsName;

    @ExcelProperty("包装类型(0定装1散装)")
    private String packagingType;

    @ExcelProperty("包装类型名称")
    private String packagingTypeName;

    @ExcelProperty("规格数量")
    private String number;

    @ExcelProperty("单位")
    private String unit;

    @ExcelProperty("单位名称")
    private String unitName;

    @ExcelProperty("包装单位")
    private String packaging;

    @ExcelProperty("包装单位名称")
    private String packagingName;

    @ExcelProperty("计量单位")
    private String measurementUnit;

    @ExcelProperty("计量单位名称")
    private String measurementUnitName;

    @ExcelProperty("采购价")
    private BigDecimal purchasePrice;

    @ExcelProperty("售出价")
    private BigDecimal sellingPrice;

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
