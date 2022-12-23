package cn.acsm.module.stock.controller.admin.recorddetail.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 库存记录字表-明细 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class StockRecordDetailExcelVO {

    @ExcelProperty("库存记录明细id")
    private Long id;

    @ExcelProperty("库存记录id")
    private Long recordId;

    @ExcelProperty("库存批次号")
    private String stockBatchNo;

    @ExcelProperty("操作类型(0.入库 1.出库)")
    private Boolean operationType;

    @ExcelProperty("二级分类(成品类：套餐/商品/特医食品)")
    private String secondaryClassification;

    @ExcelProperty("货品id")
    private String goodsId;

    @ExcelProperty("货品编号")
    private String goodsNumber;

    @ExcelProperty("货品名称")
    private String goodsName;

    @ExcelProperty("货品类型")
    private String goodsType;

    @ExcelProperty("包装类型")
    private String packagingType;

    @ExcelProperty("包装规格")
    private String packingSpecification;

    @ExcelProperty("入库数量")
    private Integer receiptQuantity;

    @ExcelProperty("现有库存量")
    private Integer existingInventory;

    @ExcelProperty("出库数量")
    private Integer deliveryQuantity;

    @ExcelProperty("库存记录明细id(只出库类型才有值-对应入库记录)")
    private Long recordDetailId;

    @ExcelProperty("货位id")
    private Long goodsAllocationId;

    @ExcelProperty("货位号")
    private String goodsAllocationNo;

    @ExcelProperty("来源/去向说明")
    private String sourceTo;

    @ExcelProperty("单价")
    private BigDecimal unitPrice;

    @ExcelProperty("计量单位")
    private String unit;

    @ExcelProperty("合计总价")
    private BigDecimal totalPrice;

    @ExcelProperty("付款方式(0.微信 1.银联 2.支付宝 3.现金)")
    private String payMethod;

    @ExcelProperty("生产批次号")
    private String productionBatchNo;

    @ExcelProperty("基地")
    private String bases;

    @ExcelProperty("地块")
    private String tunnel;

    @ExcelProperty("入库来源")
    private String treasurySource;

    @ExcelProperty("采收记录id")
    private String harvestBatchId;

    @ExcelProperty("采购单id")
    private Long purchaseId;

    @ExcelProperty("采购单号")
    private String purchaseNumber;

    @ExcelProperty("加工单id")
    private Long processingOrderId;

    @ExcelProperty("称重记录id")
    private Long weighingRecordId;

    @ExcelProperty("包装单id")
    private Long packingListId;

    @ExcelProperty("临时时间")
    private Date temporaryTime;

    @ExcelProperty("0.冷藏 1.冷冻 2.常温 3.保鲜 4.其他")
    private String environmentalRequirements;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体")
    private String subjectId;

    @ExcelProperty("用户id")
    private Long userId;

    @ExcelProperty("租户集合")
    private Long sourceId;

}
