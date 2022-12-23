package cn.acsm.module.stock.controller.admin.recorddetail.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
* 库存记录字表-明细 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class StockRecordDetailBaseVO {

    @ApiModelProperty(value = "库存记录id", required = true)
    @NotNull(message = "库存记录id不能为空")
    private Long recordId;

    @ApiModelProperty(value = "库存批次号", required = true)
    @NotNull(message = "库存批次号不能为空")
    private String stockBatchNo;

    @ApiModelProperty(value = "操作类型(0.入库 1.出库)", required = true)
    @NotNull(message = "操作类型(0.入库 1.出库)不能为空")
    private Boolean operationType;

    @ApiModelProperty(value = "二级分类(成品类：套餐/商品/特医食品)")
    private String secondaryClassification;

    @ApiModelProperty(value = "货品id", required = true)
    @NotNull(message = "货品id不能为空")
    private String goodsId;

    @ApiModelProperty(value = "货品编号")
    private String goodsNumber;

    @ApiModelProperty(value = "货品名称", required = true)
    @NotNull(message = "货品名称不能为空")
    private String goodsName;

    @ApiModelProperty(value = "货品类型")
    private String goodsType;

    @ApiModelProperty(value = "包装类型")
    private String packagingType;

    @ApiModelProperty(value = "包装规格")
    private String packingSpecification;

    @ApiModelProperty(value = "入库数量")
    private Integer receiptQuantity;

    @ApiModelProperty(value = "现有库存量")
    private Integer existingInventory;

    @ApiModelProperty(value = "出库数量")
    private Integer deliveryQuantity;

    @ApiModelProperty(value = "库存记录明细id(只出库类型才有值-对应入库记录)")
    private Long recordDetailId;

    @ApiModelProperty(value = "货位id")
    private Long goodsAllocationId;

    @ApiModelProperty(value = "货位号")
    private String goodsAllocationNo;

    @ApiModelProperty(value = "来源/去向说明")
    private String sourceTo;

    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "计量单位")
    private String unit;

    @ApiModelProperty(value = "合计总价")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "付款方式(0.微信 1.银联 2.支付宝 3.现金)")
    private String payMethod;

    @ApiModelProperty(value = "生产批次号", required = true)
    @NotNull(message = "生产批次号不能为空")
    private String productionBatchNo;

    @ApiModelProperty(value = "基地")
    private String bases;

    @ApiModelProperty(value = "地块")
    private String tunnel;

    @ApiModelProperty(value = "入库来源")
    private String treasurySource;

    @ApiModelProperty(value = "采收记录id")
    private String harvestBatchId;

    @ApiModelProperty(value = "采购单id", required = true)
    @NotNull(message = "采购单id不能为空")
    private Long purchaseId;

    @ApiModelProperty(value = "采购单号", required = true)
    @NotNull(message = "采购单号不能为空")
    private String purchaseNumber;

    @ApiModelProperty(value = "加工单id")
    private Long processingOrderId;

    @ApiModelProperty(value = "称重记录id")
    private Long weighingRecordId;

    @ApiModelProperty(value = "包装单id")
    private Long packingListId;

    @ApiModelProperty(value = "临时时间")
    private Date temporaryTime;

    @ApiModelProperty(value = "0.冷藏 1.冷冻 2.常温 3.保鲜 4.其他")
    private String environmentalRequirements;

    @ApiModelProperty(value = "经营主体", required = true)
    @NotNull(message = "经营主体不能为空")
    private String subjectId;

    @ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id不能为空")
    private Long userId;

    @ApiModelProperty(value = "租户集合", required = true)
    @NotNull(message = "租户集合不能为空")
    private Long sourceId;

}
