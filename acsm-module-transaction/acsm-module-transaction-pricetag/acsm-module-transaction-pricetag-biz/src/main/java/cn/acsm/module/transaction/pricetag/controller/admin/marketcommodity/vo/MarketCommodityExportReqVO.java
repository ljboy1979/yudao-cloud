package cn.acsm.module.transaction.pricetag.controller.admin.marketcommodity.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 市场商品 Excel 导出 Request VO", description = "参数和 MarketCommodityPageReqVO 是一致的")
@Data
public class MarketCommodityExportReqVO {

    @ApiModelProperty(value = "货架id")
    private String shelvesId;

    @ApiModelProperty(value = "规格id")
    private String specificationId;

    @ApiModelProperty(value = "商品名称")
    private String commodityName;

    @ApiModelProperty(value = "规格名称")
    private String specificationsName;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
