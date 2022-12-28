package cn.acsm.module.transaction.pricetag.controller.admin.marketprice.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 市场价格 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MarketPriceRespVO extends MarketPriceBaseVO {

    @ApiModelProperty(value = "id", required = true)
    private String id;

    /**
     * 市场商品名称
     */
    @ApiModelProperty(value = "市场商品名称", required = true)
    private String commodityName;
    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称", required = true)
    private String categoryName;
    /**
     * 规格名称
     */
    @ApiModelProperty(value = "规格名称", required = true)
    private String specificationsName;
    /**
     * 计量单位名称
     */
    @ApiModelProperty(value = "计量单位名称", required = true)
    private String measurementUnitName;
    /**
     * 市场名称
     */
    @ApiModelProperty(value = "市场名称", required = true)
    private String marketName;


    @ApiModelProperty(value = "创建时间", required = true)
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date createTime;
    @ApiModelProperty(value = "更新时间", required = true)
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date updateTime;

}
