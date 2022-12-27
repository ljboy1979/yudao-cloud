package cn.acsm.module.transaction.shelves.controller.admin.shelves.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;


@Data
public class ShelvesReqVO {

    @ApiModelProperty("类型 0原料、1投入品、2商品、3菜品、4套餐 5特医食品")
    private Integer type;

    @ApiModelProperty("售品id")
    private String salesId;

    @ApiModelProperty("货架id")
    private String shelvesId;
}
