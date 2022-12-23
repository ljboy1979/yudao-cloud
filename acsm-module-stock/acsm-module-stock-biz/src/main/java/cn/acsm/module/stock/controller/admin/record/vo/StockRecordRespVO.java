package cn.acsm.module.stock.controller.admin.record.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 库存记录 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockRecordRespVO extends StockRecordBaseVO {

    @ApiModelProperty(value = "库存记录id", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
