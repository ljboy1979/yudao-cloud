package cn.acsm.module.purchase.controller.admin.quotationelectronic.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购报价单电子 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PurchaseQuotationElectronicExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("报价单id")
    private Long quotationId;

    @ExcelProperty("报价单编号")
    private String quotationNo;

    @ExcelProperty("询价单明细id")
    private Long inquiryId;

    @ExcelProperty("商品id")
    private Long commodityId;

    @ExcelProperty("分类id")
    private Long classifyId;

    @ExcelProperty("规格id")
    private Long specificationsId;

    @ExcelProperty("起批数量")
    private Integer initialBatchCount;

    @ExcelProperty("单价")
    private BigDecimal unitPrice;

    @ExcelProperty("采购数量")
    private Integer purchaseCount;

    @ExcelProperty("总价")
    private BigDecimal totalPrice;

    @ExcelProperty("开始时间")
    private Date startTime;

    @ExcelProperty("结束时间")
    private Date endTime;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体")
    private String subjectId;

}
