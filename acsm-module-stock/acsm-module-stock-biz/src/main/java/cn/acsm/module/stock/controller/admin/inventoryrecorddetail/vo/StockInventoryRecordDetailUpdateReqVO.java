package cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 盘点记录表子表-明细更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockInventoryRecordDetailUpdateReqVO extends StockInventoryRecordDetailBaseVO {

    @ApiModelProperty(value = "盘点记录明细id", required = true)
    @NotNull(message = "盘点记录明细id不能为空")
    private Long id;

}
