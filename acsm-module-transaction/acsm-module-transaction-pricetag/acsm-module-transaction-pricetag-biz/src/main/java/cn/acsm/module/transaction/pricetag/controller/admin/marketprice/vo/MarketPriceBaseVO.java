package cn.acsm.module.transaction.pricetag.controller.admin.marketprice.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 市场价格 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class MarketPriceBaseVO {

    @ApiModelProperty(value = "编码", required = true)
    @NotNull(message = "编码不能为空")
    private String code;

    @ApiModelProperty(value = "市场商品id", required = true)
    @NotNull(message = "市场商品id不能为空")
    private String marketCommodityId;


    @ApiModelProperty(value = "市场id", required = true)
    @NotNull(message = "市场id不能为空")
    private String marketId;


    @ApiModelProperty(value = "最高价", required = true)
    @NotNull(message = "最高价不能为空")
    private Float maxPrice;

    @ApiModelProperty(value = "最低价", required = true)
    @NotNull(message = "最低价不能为空")
    private Float minPrice;

    @ApiModelProperty(value = "平均价", required = true)
    @NotNull(message = "平均价不能为空")
    private Float middlePrice;

    @ApiModelProperty(value = "来源", required = true)
    @NotNull(message = "来源不能为空")
    private String source;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id", required = true)
    @NotNull(message = "经营主体id不能为空")
    private String subjectId;

}
