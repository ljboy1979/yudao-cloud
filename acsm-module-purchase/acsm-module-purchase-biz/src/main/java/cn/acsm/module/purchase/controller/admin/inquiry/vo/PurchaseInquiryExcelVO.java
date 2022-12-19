package cn.acsm.module.purchase.controller.admin.inquiry.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 采购询价电子 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PurchaseInquiryExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("商品id")
    private Long commodityId;

    @ExcelProperty("分类id")
    private Long commodityCategoryId;

    @ExcelProperty("规格id")
    private Long productSpecificationsId;

    @ExcelProperty("计划数量最低")
    private String plannedQuantityMin;

    @ExcelProperty("计划数量最高")
    private String plannedQuantityMax;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体")
    private String subjectId;

}
