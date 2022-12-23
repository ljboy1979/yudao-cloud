package cn.acsm.module.stock.controller.admin.inventoryrecord.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 盘点记录更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockInventoryRecordUpdateReqVO extends StockInventoryRecordBaseVO {

    @ApiModelProperty(value = "盘点记录id", required = true)
    @NotNull(message = "盘点记录id不能为空")
    private Long id;

}
