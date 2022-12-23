package cn.acsm.module.stock.controller.admin.inventory.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 库存清单 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class StockInventoryBaseVO {

    @ApiModelProperty(value = "库存类型(1.原料 2.投入品 3.成品 4.办公用品)")
    private Integer type;

    @ApiModelProperty(value = "仓库id")
    private String warehouseId;

    @ApiModelProperty(value = "仓库编号")
    private String warehouseCode;

    @ApiModelProperty(value = "仓库名称")
    private String warehouseName;

    @ApiModelProperty(value = "仓库类型")
    private Integer warehouseType;

    @ApiModelProperty(value = "货品id")
    private String goodsId;

    @ApiModelProperty(value = "货品编号")
    private String goodsNumber;

    @ApiModelProperty(value = "货品名称")
    private String goodsName;

    @ApiModelProperty(value = "货品类型")
    private String goodsType;

    @ApiModelProperty(value = "包装类型")
    private String packagingType;

    @ApiModelProperty(value = "包装规格id")
    private String packagingSpecificationId;

    @ApiModelProperty(value = "包装规格")
    private String packingSpecification;

    @ApiModelProperty(value = "库存数量")
    private String inventoryQuantity;

    @ApiModelProperty(value = "计量单位")
    private String measureUnit;

    @ApiModelProperty(value = "预警数量上线")
    private Integer upperWarningLimit;

    @ApiModelProperty(value = "预警数量下线")
    private Integer lowerWarningLimit;

    @ApiModelProperty(value = "经营主体")
    private String subjectId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "租户集合")
    private Long sourceId;

    @ApiModelProperty(value = "租户")
    private String tenantId;

}
