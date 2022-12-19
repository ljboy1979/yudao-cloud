package cn.acsm.module.purchase.controller.admin.details.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 采购单明细 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PurchaseDetailsExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("采购单编号")
    private Long purchaseId;

    @ExcelProperty("采购单号")
    private String purchaseNumber;

    @ExcelProperty("货品编号")
    private Long goodsId;

    @ExcelProperty("货品名称")
    private String goodsName;

    @ExcelProperty("包装规格id")
    private Long packagingSpecificationId;

    @ExcelProperty("包装规格")
    private String packagingSpecification;

    @ExcelProperty("计量单位")
    private String unit;

    @ExcelProperty("包装类型")
    private String packagingType;

    @ExcelProperty("采购数量/重量")
    private BigDecimal buyNumber;

    @ExcelProperty("期望到货频次")
    private String frequency;

    @ExcelProperty("单价")
    private BigDecimal price;

    @ExcelProperty("优惠金额")
    private BigDecimal discount;

    @ExcelProperty("采购金额(总金额)")
    private BigDecimal total;

    @ExcelProperty("收货标准id")
    private Long standardId;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体")
    private String subjectId;

}
