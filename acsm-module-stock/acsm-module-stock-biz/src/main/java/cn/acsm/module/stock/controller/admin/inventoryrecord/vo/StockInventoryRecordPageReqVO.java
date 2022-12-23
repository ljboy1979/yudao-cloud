package cn.acsm.module.stock.controller.admin.inventoryrecord.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 盘点记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockInventoryRecordPageReqVO extends PageParam {

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
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] operationTime;

    @ApiModelProperty(value = "负责人id")
    private Long headId;

    @ApiModelProperty(value = "负责人名称")
    private String headName;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体")
    private String subjectId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "租户集合")
    private Long sourceId;

}
