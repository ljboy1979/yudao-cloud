package cn.acsm.module.transaction.pricetag.controller.admin.marketpricedetails.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 市场价格明细 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class MarketPriceDetailsBaseVO {

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
