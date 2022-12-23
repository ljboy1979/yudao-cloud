package cn.acsm.module.stock.controller.admin.inventoryrecord.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@ApiModel("管理后台 - 盘点记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockInventoryRecordPageVO extends PageParam {

    @ApiModelProperty(value = "库存类型(1.原料 2.投入品 3.成品 4.办公用品)")
    private Integer type;

    @ApiModelProperty(value = "仓库名称")
    private String warehouseName;

    @ApiModelProperty(value = "盘点批次")
    private String inventoryCode;

    @ApiModelProperty(value = "操作开始时间")
    private Date operationStartTime;

    @ApiModelProperty(value = "操作结束时间")
    private Date operationEndTime;

    @ApiModelProperty(value = "负责人名称")
    private String headName;

}
