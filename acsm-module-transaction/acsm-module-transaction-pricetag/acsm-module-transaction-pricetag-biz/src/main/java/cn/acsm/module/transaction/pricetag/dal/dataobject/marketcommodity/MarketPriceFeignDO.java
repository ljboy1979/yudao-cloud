package cn.acsm.module.transaction.pricetag.dal.dataobject.marketcommodity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("货架响应DTO")
@Data
public class MarketPriceFeignDO {

    @ApiModelProperty("商品id")
    private String id;
    @ApiModelProperty("价格牌id")
    private String priceId;
}
