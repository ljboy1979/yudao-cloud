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

    @ExcelProperty("报价单编号")
    private Long quoteId;

    @ExcelProperty("询价单明细编号")
    private Long enquiryId;

    @ExcelProperty("商品id")
    private Long commodityId;

    @ExcelProperty("分类id")
    private Long commodityCategoryId;

    @ExcelProperty("规格id")
    private String specificationsId;

    @ExcelProperty("起批数量")
    private String batchNumber;

    @ExcelProperty("单价")
    private BigDecimal price;

    @ExcelProperty("采购数量")
    private String orderSize;

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
