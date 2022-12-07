package cn.acsm.module.transaction.pricetag.controller.admin.marketpricedetails.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 市场价格明细分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MarketPriceDetailsPageReqVO extends PageParam {

    @ApiModelProperty(value = "市场价格id")
    private String marketPriceId;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
