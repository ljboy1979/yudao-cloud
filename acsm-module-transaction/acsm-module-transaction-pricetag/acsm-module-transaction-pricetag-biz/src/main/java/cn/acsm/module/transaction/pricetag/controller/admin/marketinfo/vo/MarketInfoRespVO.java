package cn.acsm.module.transaction.pricetag.controller.admin.marketinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 市场信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MarketInfoRespVO extends MarketInfoBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    private String id;

    @ApiModelProperty(value = "创建时间", required = true)
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date createTime;

}
