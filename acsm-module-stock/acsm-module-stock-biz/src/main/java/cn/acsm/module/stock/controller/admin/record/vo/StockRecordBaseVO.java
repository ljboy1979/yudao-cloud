package cn.acsm.module.stock.controller.admin.record.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
* 库存记录 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class StockRecordBaseVO {

    @ApiModelProperty(value = "库存类型(0:原料 1:投入品 2:商品 3: 菜品 4:套餐 5:特医食品)", required = true)
    @NotNull(message = "库存类型(0:原料 1:投入品 2:商品 3: 菜品 4:套餐 5:特医食品)不能为空")
    private Integer type;

    @ApiModelProperty(value = "操作类型(0.入库 1.出库)", required = true)
    @NotNull(message = "操作类型(0.入库 1.出库)不能为空")
    private Boolean operationType;

    @ApiModelProperty(value = "仓库id", required = true)
    @NotNull(message = "仓库id不能为空")
    private String warehouseId;

    @ApiModelProperty(value = "仓库编号", required = true)
    @NotNull(message = "仓库编号不能为空")
    private String warehouseCode;

    @ApiModelProperty(value = "仓库名称", required = true)
    @NotNull(message = "仓库名称不能为空")
    private String warehouseName;

    @ApiModelProperty(value = "批次号")
    private String batchNo;

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
