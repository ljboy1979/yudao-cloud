package cn.acsm.module.transaction.sales.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("货架请求DTO")
@Data
public class ShelvesSalesReqDto {
    @ApiModelProperty("类型 0原料、1投入品、2商品、3菜品、4套餐 5特医食品")
    private Integer type;

    @ApiModelProperty("售品id")
    private String salesId;

    @ApiModelProperty("租户编号")
    private String tenantId;

    @ApiModelProperty("售品名称")
    private String salesName;
}
