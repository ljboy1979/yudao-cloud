package cn.acsm.module.transaction.sales.controller.admin.packageorganization.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 套餐组成 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PackageOrganizationExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("套餐id")
    private String packageId;

    @ExcelProperty("0商品 1菜品")
    private String type;

    @ExcelProperty("来源id(商品id/菜品id)")
    private String sourceId;

    @ExcelProperty("规格id")
    private String specificationId;

    @ExcelProperty("分类")
    private String classify;

    @ExcelProperty("组成编号")
    private String organizationNumber;

    @ExcelProperty("组成名称")
    private String organizationName;

    @ExcelProperty("数量")
    private Integer num;

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

    @ExcelProperty("售出价")
    private BigDecimal sellingPrice;

    @ExcelProperty("菜系")
    private String cuisine;

    @ExcelProperty("烹饪方式")
    private Boolean cookingStyle;

    @ExcelProperty("套餐组成图片")
    private String imgUrl;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("source")
    private String source;

}
