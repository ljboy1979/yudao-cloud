package cn.acsm.module.purchase.controller.admin.loss.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

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
    private Long orderId;

    @ExcelProperty("采购单号")
    private String orderNo;

    @ExcelProperty("货单id")
    private Long goodsId;

    @ExcelProperty("货单单号")
    private String goodsNo;

    @ExcelProperty("货电子表-明细id")
    private Long electronicBillOfGoodsId;

    @ExcelProperty("货架id")
    private Long goodsShelvesId;

    @ExcelProperty("货架号")
    private String goodsShelvesNo;

    @ExcelProperty("货品名称")
    private String goodsName;

    @ExcelProperty("包装规格")
    private String packingSpecifications;

    @ExcelProperty("规格单位")
    private String specificationUnit;

    @ExcelProperty("损耗数量")
    private Integer lossCount;

    @ExcelProperty("损耗重量")
    private Integer lossWeight;

    @ExcelProperty("金额")
    private BigDecimal amount;

    @ExcelProperty("报损人id")
    private Long lossReporterId;

    @ExcelProperty("报损人姓名")
    private String lossReporterName;

    @ExcelProperty("报损时间")
    private Date lossReporterTime;

    @ExcelProperty("库存记录id")
    private Long inventoryRecordsId;

    @ExcelProperty("入库批次号")
    private String receiptBatchNo;

    @ExcelProperty("库存记录明细id")
    private Long inventoryRecordDetailsId;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体")
    private String subjectId;

}
