package cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 盘点记录表子表-明细 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class StockInventoryRecordDetailBaseVO {

    @ApiModelProperty(value = "盘点记录id")
    private Long inventoryRecordId;

    @ApiModelProperty(value = "盘点批次号", required = true)
    private String inventoryCode;

    @ApiModelProperty(value = "库存类型(1.原料 2.投入品 3.成品 4.办公用品)")
    private Integer type;

    @ApiModelProperty(value = "二级分类(成品类：套餐/商品/特医食品)")
    private String secondaryClassification;

    @ApiModelProperty(value = "货品id", required = true)
    private String goodsId;

    @ApiModelProperty(value = "货品编号")
    private String goodsNumber;

    @ApiModelProperty(value = "货品名称", required = true)
    private String goodsName;

    @ApiModelProperty(value = "货品类型")
    private String goodsType;

    @ApiModelProperty(value = "包装规格id")
    private Long packagingSpecificationId;

    @ApiModelProperty(value = "包装规格")
    private String packagingSpecification;

    @ApiModelProperty(value = "包装规格名称")
    private String packagingSpecificationName;

    @ApiModelProperty(value = "包装类型")
    private String packagingType;

    @ApiModelProperty(value = "盘点前数量", required = true)
    private Integer inventoryFrontQuantity;

    @ApiModelProperty(value = "盘点后数量", required = true)
    private Integer inventoryAfterQuantity;

    @ApiModelProperty(value = "货位id")
    private Long goodsAllocationId;

    @ApiModelProperty(value = "货位号")
    private String goodsAllocationNo;

    @ApiModelProperty(value = "来源/去向说明")
    private String sourceTo;

    @ApiModelProperty(value = "经营主体", required = true)
    private String subjectId;

    @ApiModelProperty(value = "用户id", required = true)
    private Long userId;

    @ApiModelProperty(value = "租户集合", required = true)
    private Long sourceId;

}
