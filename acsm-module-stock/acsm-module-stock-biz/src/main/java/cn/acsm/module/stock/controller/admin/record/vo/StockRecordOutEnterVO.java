package cn.acsm.module.stock.controller.admin.record.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ApiModel("管理后台 - 3.7.2.14.查询出/入库记录 Request VO")
@Data
@ToString(callSuper = true)
public class StockRecordOutEnterVO extends PageParam {

    @ApiModelProperty(value = "库存类型(0:原料 1:投入品 2:商品 3: 菜品 4:套餐 5:特医食品)", required = true)
    private Integer type;

    @ApiModelProperty(value = "操作类型(0.入库 1.出库)")
    private Integer operationType;

    @ApiModelProperty(value = "仓库名称")
    private String warehouseName;

    @ApiModelProperty(value = "批次号")
    private String batchNo;

    @ApiModelProperty(value = "操作开始时间")
    private Date operationStartTime;

    @ApiModelProperty(value = "操作结束时间")
    private Date operationEndTime;

    @ApiModelProperty(value = "负责人名称")
    private String headName;

}
