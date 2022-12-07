package cn.acsm.module.transaction.shelves.controller.admin.stockclassify.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 库存分类 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockClassifyRespVO extends StockClassifyBaseVO {

    @ApiModelProperty(value = "id", required = true)
    private String id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
