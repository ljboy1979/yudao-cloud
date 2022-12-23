package cn.acsm.module.stock.controller.admin.recorddetail.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@ApiModel("管理后台 - 库存记录字表-明细 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockRecordDetailRespVO extends StockRecordDetailBaseVO {

    @ApiModelProperty(value = "库存记录明细id", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
