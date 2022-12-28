package cn.acsm.module.stock.api.inventory.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <pre>
 * 对象功能: InventoryReqDTO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/23
 * <pre>
 */
@ApiModel("管理后台 - 库存清单信息读取 Response DTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryQO {

    @ApiModelProperty(value = "库存类型(0:原料 1:投入品 2:商品 3: 菜品 4:套餐 5:特医食品)", required = true)
    @NotNull(message = "库存类型(0:原料 1:投入品 2:商品 3: 菜品 4:套餐 5:特医食品)不能为空")
    private Long type;

    @ApiModelProperty(value = "货品id", required = true)
    @NotBlank(message = "货品id不能为空")
    private String goodsId;

    @ApiModelProperty(value = "规格名称", required = true)
    @NotBlank(message = "规格名称不能为空")
    private String packingSpecification;

}
