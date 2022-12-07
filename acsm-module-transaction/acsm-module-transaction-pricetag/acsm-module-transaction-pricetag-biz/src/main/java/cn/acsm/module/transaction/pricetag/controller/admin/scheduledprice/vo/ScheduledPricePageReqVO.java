package cn.acsm.module.transaction.pricetag.controller.admin.scheduledprice.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 预定价格分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ScheduledPricePageReqVO extends PageParam {

    @ApiModelProperty(value = "商品名称")
    private String commodityName;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
