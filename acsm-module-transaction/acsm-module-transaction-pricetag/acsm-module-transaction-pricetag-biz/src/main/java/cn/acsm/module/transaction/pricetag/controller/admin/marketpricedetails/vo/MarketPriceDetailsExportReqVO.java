package cn.acsm.module.transaction.pricetag.controller.admin.marketpricedetails.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 市场价格明细 Excel 导出 Request VO", description = "参数和 MarketPriceDetailsPageReqVO 是一致的")
@Data
public class MarketPriceDetailsExportReqVO {

    @ApiModelProperty(value = "市场价格id")
    private String marketPriceId;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
