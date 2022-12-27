package cn.acsm.module.transaction.shelves.controller.admin.stockclassify.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 库存分类 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockClassifyRespVO extends StockClassifyBaseVO {

    @ApiModelProperty(value = "id", required = true)
    private String id;

    @ApiModelProperty(value = "创建时间", required = true)
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date createTime;
    @ApiModelProperty(value = "更新时间", required = true)
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date updateTime;

}
