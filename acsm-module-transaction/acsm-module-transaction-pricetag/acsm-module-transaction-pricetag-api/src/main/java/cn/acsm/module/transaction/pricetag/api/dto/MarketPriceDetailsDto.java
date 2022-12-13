package cn.acsm.module.transaction.pricetag.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
public class MarketPriceDetailsDto {

    @ApiModelProperty(value = "市场价格id")
    private String marketPriceId;

    @ApiModelProperty(value = "价格编号")
    private String priceCode;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "支付人")
    private String payer;

    @ApiModelProperty(value = "0货架/1订单/2人工导入")
    private String priceSource;

    @ApiModelProperty(value = "来源")
    private String source;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

}
