package cn.acsm.module.stock.controller.admin.record.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

@ApiModel("管理后台 - 库存记录创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockRecordCreateReqVO extends StockRecordBaseVO {

    @ApiModelProperty(value = "货品id")
    private String goodsId;

    @ApiModelProperty(value = "货品id")
    private String goodsName;

    @ApiModelProperty(value = "包装规格")
    private String packingSpecification;

    @ApiModelProperty(value = "入库数量")
    private Integer receiptQuantity;

    @ApiModelProperty(value = "现有库存量")
    private Integer existingInventory;

    @ApiModelProperty(value = "出库数量")
    private Integer deliveryQuantity;

    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "计量单位")
    private String unit;

    @ApiModelProperty(value = "合计总价")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "生产批次号")
    private String productionBatchNo;

    @ApiModelProperty(value = "入库来源")
    private String treasurySource;

    @ApiModelProperty(value = "采购单id")
    private Long purchaseId;

    @ApiModelProperty(value = "采购单号")
    private String purchaseNumber;

    @ApiModelProperty(value = "库存记录明细id")
    private Long recordDetailId;

}
