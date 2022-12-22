package cn.acsm.module.purchase.controller.admin.inquirydetail.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 采购询价电子表 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PurchaseInquiryDetailExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("询价单编号")
    private String enquiryId;

    @ExcelProperty("商品id")
    private Long commodityId;

    @ExcelProperty("分类id")
    private Long commodityCategoryId;

    @ExcelProperty("规格id")
    private Long productSpecificationsId;

    @ExcelProperty("计划数量最低")
    private Integer plannedQuantityMin;

    @ExcelProperty("计划数量最高")
    private Integer plannedQuantityMax;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体")
    private String subjectId;

    @ExcelProperty("用户id")
    private Long userId;

    @ExcelProperty("租户集合")
    private Long sourceId;

}
