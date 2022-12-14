package cn.acsm.module.purchase.controller.admin.details.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购单明细 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PurchaseDetailsExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("采购单id")
    private Long orderId;

    @ExcelProperty("采购单号")
    private String purchaseOrderNumber;

    @ExcelProperty("货品id")
    private Long goodsId;

    @ExcelProperty("货品名称")
    private String goodsName;

    @ExcelProperty("包装规格id")
    private Long packagingSpecificationId;

    @ExcelProperty("包装规格")
    private String packagingSpecification;

    @ExcelProperty("计量单位")
    private String unitOfMeasurement;

    @ExcelProperty("包装类型")
    private String packagingType;

    @ExcelProperty("采购数量/重量")
    private BigDecimal purchaseQuantity;

    @ExcelProperty("期望到货频次")
    private String expectedArrivalFrequency;

    @ExcelProperty("单价")
    private BigDecimal unitPrice;

    @ExcelProperty("优惠金额")
    private BigDecimal discountAmount;

    @ExcelProperty("采购金额")
    private BigDecimal purchaseAmount;

    @ExcelProperty("货品id")
    private Long chargingStandard;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体")
    private String subjectId;

}
