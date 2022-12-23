package cn.acsm.module.stock.controller.admin.record.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 库存记录更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockRecordUpdateReqVO extends StockRecordBaseVO {

    @ApiModelProperty(value = "库存记录id", required = true)
    @NotNull(message = "库存记录id不能为空")
    private Long id;

}
