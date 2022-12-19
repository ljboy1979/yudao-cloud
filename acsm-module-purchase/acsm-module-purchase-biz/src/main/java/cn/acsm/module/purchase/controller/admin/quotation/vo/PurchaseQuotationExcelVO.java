package cn.acsm.module.purchase.controller.admin.quotation.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 采购询价电子 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PurchaseQuotationExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("报价单编号")
    private Long quoteId;

    @ExcelProperty("报价单名称")
    private String quoteName;

    @ExcelProperty("采购商id")
    private Long purchaserId;

    @ExcelProperty("询价单编号")
    private Long enquiryId;

    @ExcelProperty("报价有效期")
    private Date indateDate;

    @ExcelProperty("是否提交 0：未提交 1：已提交")
    private Boolean submitStatus;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体")
    private String subjectId;

}
