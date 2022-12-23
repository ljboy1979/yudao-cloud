package cn.acsm.module.stock.controller.admin.inventoryrecord.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 盘点记录 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockInventoryRecordRespVO extends StockInventoryRecordBaseVO {

    @ApiModelProperty(value = "盘点记录id", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
