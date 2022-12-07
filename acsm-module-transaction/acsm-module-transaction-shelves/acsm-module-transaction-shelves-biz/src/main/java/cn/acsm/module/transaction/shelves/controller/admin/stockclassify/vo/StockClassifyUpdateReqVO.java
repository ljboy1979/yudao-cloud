package cn.acsm.module.transaction.shelves.controller.admin.stockclassify.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 库存分类更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockClassifyUpdateReqVO extends StockClassifyBaseVO {

    @ApiModelProperty(value = "id", required = true)
    @NotNull(message = "id不能为空")
    private String id;

}
