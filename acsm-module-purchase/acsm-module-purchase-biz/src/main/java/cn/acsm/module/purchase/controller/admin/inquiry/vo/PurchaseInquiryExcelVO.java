package cn.acsm.module.purchase.controller.admin.inquiry.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 采购询价电子 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PurchaseInquiryExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("询价单编号")
    private String inquiryNo;

    @ExcelProperty("商品id")
    private Long productId;

    @ExcelProperty("分类id")
    private Long classifyId;

    @ExcelProperty("规格id")
    private Long specificationsId;

    @ExcelProperty("计划数量最低")
    private Integer lowestPlannedQuantity;

    @ExcelProperty("计划数量最高")
    private Integer highestPlannedQuantity;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体")
    private String subjectId;

}
