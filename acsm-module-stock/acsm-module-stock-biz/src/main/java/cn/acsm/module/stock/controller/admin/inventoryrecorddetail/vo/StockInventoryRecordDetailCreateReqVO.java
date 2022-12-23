package cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ApiModel("管理后台 - 盘点记录表子表-明细创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockInventoryRecordDetailCreateReqVO extends StockInventoryRecordDetailBaseVO {

}
