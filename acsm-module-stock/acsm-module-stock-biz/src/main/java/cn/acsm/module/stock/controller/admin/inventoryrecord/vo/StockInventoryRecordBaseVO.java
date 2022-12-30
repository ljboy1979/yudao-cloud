package cn.acsm.module.stock.controller.admin.inventoryrecord.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

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
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = "GMT+8")
    private Date operationTime;

    @ApiModelProperty(value = "负责人id")
    private Long headId;

    @ApiModelProperty(value = "负责人名称")
    private String headName;

    @ApiModelProperty(value = "经营主体", required = true)
    private String subjectId;

    @ApiModelProperty(value = "用户id", required = true)
    private Long userId;

    @ApiModelProperty(value = "租户集合", required = true)
    private Long sourceId;

}
