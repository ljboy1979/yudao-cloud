package cn.acsm.module.stock.controller.admin.inventoryrecord.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ApiModel("管理后台 - 盘点记录创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockInventoryRecordCreateReqVO extends StockInventoryRecordBaseVO {

    @ApiModelProperty(value = "库存批次号", required = true)
    @NotNull(message = "库存批次号不能为空")
    private String stockBatchNo;

    @ApiModelProperty(value = "库存记录明细id", required = true)
    @NotNull(message = "库存记录明细id不能为空")
    private Long stockRecordDetailId;

    @ApiModelProperty(value = "货品id", required = true)
    @NotNull(message = "货品id不能为空")
    private String goodsId;

    @ApiModelProperty(value = "货品名称", required = true)
    @NotNull(message = "货品名称不能为空")
    private String goodsName;

    @ApiModelProperty(value = "包装规格id", required = true)
    @NotNull(message = "包装规格id不能为空")
    private Integer packagingSpecificationId;

    @ApiModelProperty(value = "盘点前数量", required = true)
    @NotNull(message = "盘点前数量不能为空")
    private Integer inventoryFrontQuantity;

    @ApiModelProperty(value = "盘点后数量", required = true)
    @NotNull(message = "盘点后数量不能为空")
    private Integer inventoryAfterQuantity;



}
