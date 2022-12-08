package cn.acsm.module.transaction.order.controller.admin.reservedetails.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 订单预定详情 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ReserveDetailsBaseVO {

    @ApiModelProperty(value = "预定id", required = true)
    @NotNull(message = "预定id不能为空")
    private String reserveId;

    @ApiModelProperty(value = "商品名称", required = true)
    @NotNull(message = "商品名称不能为空")
    private String commodityName;

    @ApiModelProperty(value = "规格名称")
    private String specificationName;

    @ApiModelProperty(value = "购买数量")
    private String num;

    @ApiModelProperty(value = "市场价格")
    private String marketPrice;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "套餐状态（默认 0未付款 1已取消 2已锁定）")
    private String planStatus;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "来源")
    private String source;

    @ApiModelProperty(value = "捕捞商品id", required = true)
    @NotNull(message = "捕捞商品id不能为空")
    private String osCommodityFishingId;

    @ApiModelProperty(value = "捕捞规格id")
    private String productSpecificationsFishingId;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "配送方式 0包邮 1不包邮")
    private String sendType;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

}
