package cn.acsm.module.transaction.pricetag.controller.admin.marketprice.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PriceTrendVO {
    @ApiModelProperty(value = "日期", required = true)
    private String time;

    /**
     * 最高价
     */
    @ApiModelProperty(value = "最高价", required = true)
    private Float maxPrice;
    /**
     * 最低价
     */
    @ApiModelProperty(value = "最低价", required = true)
    private Float minPrice;
    /**
     * 平均价
     */
    @ApiModelProperty(value = "平均价", required = true)
    private Float middlePrice;
}
