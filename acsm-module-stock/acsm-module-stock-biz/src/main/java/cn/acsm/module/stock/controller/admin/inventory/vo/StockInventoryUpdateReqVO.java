package cn.acsm.module.stock.controller.admin.inventory.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ApiModel("管理后台 - 库存清单更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockInventoryUpdateReqVO extends StockInventoryBaseVO {

    @ApiModelProperty(value = "库存清单id", required = true)
    @NotNull(message = "库存清单id不能为空")
    private String id;

}
