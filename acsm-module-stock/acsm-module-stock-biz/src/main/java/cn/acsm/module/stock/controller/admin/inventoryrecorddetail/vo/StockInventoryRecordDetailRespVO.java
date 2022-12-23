package cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 盘点记录表子表-明细 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockInventoryRecordDetailRespVO extends StockInventoryRecordDetailBaseVO {

    @ApiModelProperty(value = "盘点记录明细id", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
