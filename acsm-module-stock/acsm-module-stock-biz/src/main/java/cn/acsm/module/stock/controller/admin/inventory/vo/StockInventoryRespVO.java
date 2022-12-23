package cn.acsm.module.stock.controller.admin.inventory.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@ApiModel("管理后台 - 库存清单 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockInventoryRespVO extends StockInventoryBaseVO {

    @ApiModelProperty(value = "库存清单id", required = true)
    private String id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
