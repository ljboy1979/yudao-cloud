package cn.acsm.module.stock.controller.admin.inventoryrecord.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
* 盘点记录 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class StockInventoryRecordBaseVO {

    @ApiModelProperty(value = "库存类型(1.原料 2.投入品 3.成品 4.办公用品)")
    private Integer type;

    @ApiModelProperty(value = "仓库id")
    private String warehouseId;

    @ApiModelProperty(value = "仓库编号")
    private String warehouseCode;

    @ApiModelProperty(value = "仓库名称")
    private String warehouseName;

    @ApiModelProperty(value = "盘点批次")
    private String inventoryCode;

    @ApiModelProperty(value = "操作时间")
    private Date operationTime;

    @ApiModelProperty(value = "负责人id")
    private Long headId;

    @ApiModelProperty(value = "负责人名称")
    private String headName;

    @ApiModelProperty(value = "经营主体", required = true)
    @NotNull(message = "经营主体不能为空")
    private String subjectId;

    @ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id不能为空")
    private Long userId;

    @ApiModelProperty(value = "租户集合", required = true)
    @NotNull(message = "租户集合不能为空")
    private Long sourceId;

}
