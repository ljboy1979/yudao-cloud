package cn.acsm.module.stock.controller.admin.inventory.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <pre>
 * 对象功能: StockInventoryUpdateCountVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/21
 * <pre>
 */
@ApiModel("管理后台 - 3.7.2.6.更新库存量 Request VO")
@Data
@ToString(callSuper = true)
public class StockInventoryUpdateCountVO implements Serializable {

    @ApiModelProperty(value = "货品id", required = true)
    @NotBlank(message = "货品id不能为空")
    private String goodsId;

    @ApiModelProperty(value = "规格id", required = true)
    private String packagingSpecificationId;

    @ApiModelProperty(value = "包装规格", required = true)
    private String packingSpecification;

    @ApiModelProperty(value = "仓库id", required = true)
    @NotBlank(message = "仓库id不能为空")
    private String warehouseId;

    @ApiModelProperty(value = "库存数量", required = true)
    @NotNull(message = "库存数量不能为空")
    private Integer inventoryQuantity;

    @ApiModelProperty(value = "经营主体")
    private String subjectId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "租户集合")
    private Long sourceId;

    @ApiModelProperty(value = "租户")
    private String tenantId;

}
