package cn.acsm.module.transaction.shelves.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("货架请求DTO")
@Data
public class PriceTagShelvesReqDto {

    @ApiModelProperty("租户编号")
    private String tenantId;

    @ApiModelProperty("货架id")
    private String shelvesId;
    @ApiModelProperty("分类id")
    private String classifyId;
}
