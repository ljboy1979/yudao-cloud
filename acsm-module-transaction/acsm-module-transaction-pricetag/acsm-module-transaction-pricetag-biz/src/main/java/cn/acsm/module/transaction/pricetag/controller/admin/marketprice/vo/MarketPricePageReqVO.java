package cn.acsm.module.transaction.pricetag.controller.admin.marketprice.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 市场价格分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MarketPricePageReqVO extends PageParam {

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "市场商品id")
    private String marketCommodityId;

    @ApiModelProperty(value = "最高价")
    private Float maxPrice;

    @ApiModelProperty(value = "最低价")
    private Float minPrice;

    @ApiModelProperty(value = "平均价")
    private Float middlePrice;

    @ApiModelProperty(value = "来源")
    private String source;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

}
