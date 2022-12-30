package cn.acsm.module.stock.controller.admin.inventoryrecord.vo;

import cn.acsm.module.stock.dal.dataobject.inventoryrecorddetail.StockInventoryRecordDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@ApiModel("管理后台 - 盘点记录创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockInventoryRecordCreateReqVO extends StockInventoryRecordBaseVO {

    @ApiModelProperty(value = "库存批次号", required = true)
    private String stockBatchNo;

    @ApiModelProperty(value = "货品id", required = true)
    private String goodsId;

    @ApiModelProperty(value = "货品名称", required = true)
    private String goodsName;

    @ApiModelProperty(value = "包装规格id", required = true)
    private Integer packagingSpecificationId;

    @ApiModelProperty(value = "盘点前数量")
    private Integer inventoryFrontQuantity;

    @ApiModelProperty(value = "盘点后数量")
    private Integer inventoryAfterQuantity;

    @ApiModelProperty(value = "盘点详情对象集合")
    private List<StockInventoryRecordDetailDO> detailDOS;



}
