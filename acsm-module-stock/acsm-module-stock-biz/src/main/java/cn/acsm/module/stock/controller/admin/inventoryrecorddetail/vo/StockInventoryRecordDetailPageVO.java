package cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("管理后台 - 盘点记录表子表-明细分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockInventoryRecordDetailPageVO extends PageParam {

    @ApiModelProperty(value = "盘点记录id", required = true)
    @NotNull(message = "盘点记录id不能为空")
    private Long inventoryRecordId;

    @ApiModelProperty(value = "盘点批次号", required = true)
    @NotBlank(message = "盘点批次号不能为空")
    private String inventoryCode;

    @ApiModelProperty(value = "货品名称")
    private String goodsName;

    @ApiModelProperty(value = "货品类型")
    private String goodsType;

}
