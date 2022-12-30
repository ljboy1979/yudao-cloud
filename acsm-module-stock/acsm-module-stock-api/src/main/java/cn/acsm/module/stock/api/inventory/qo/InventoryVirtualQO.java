package cn.acsm.module.stock.api.inventory.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * <pre>
 * 对象功能: InventoryVirtualQO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/30
 * <pre>
 */
@ApiModel("管理后台 - 库存清单虚拟库存量修改 Response DTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryVirtualQO {

    @ApiModelProperty(value = "规格id", required = true)
    @NotBlank(message = "规格id不能为空")
    private String packagingSpecificatioId;

    @ApiModelProperty(value = "虚拟库存量", required = true)
    @NotBlank(message = "虚拟库存量不能为空")
    private Integer virtualInventory;

}
