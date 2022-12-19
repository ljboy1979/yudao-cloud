package cn.acsm.module.purchase.controller.admin.loss.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 损耗 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PurchaseLossExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("采购单id")
    private Long purchaseId;

    @ExcelProperty("采购单号")
    private String purchaseNumber;

    @ExcelProperty("货品编号")
    private Long goodsId;

    @ExcelProperty("货单电子表-明细id")
    private Long electronicBillOfGoodsId;

    @ExcelProperty("货架编号")
    private Long goodSkuId;

    @ExcelProperty("货品名称")
    private String goodsName;

    @ExcelProperty("包装规格")
    private String packingSpecification;

    @ExcelProperty("规格单位")
    private String specificationUnit;

    @ExcelProperty("损耗数量")
    private Integer lossCount;

    @ExcelProperty("损耗重量")
    private Integer lossWeight;

    @ExcelProperty("金额")
    private BigDecimal amount;

    @ExcelProperty("报损人编号")
    private Long managerId;

    @ExcelProperty("报损人姓名")
    private String manager;

    @ExcelProperty("报损时间")
    private Date time;

    @ExcelProperty("库存记录编号")
    private Long stockId;

    @ExcelProperty("入库批次号")
    private String receiptBatchNo;

    @ExcelProperty("库存记录明细id")
    private Long inventoryRecordDetailsId;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体")
    private String subjectId;

}
