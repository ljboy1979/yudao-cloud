package cn.acsm.module.stock.controller.admin.recorddetail.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <pre>
 * 对象功能: StockRecordDetailPageVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/22
 * <pre>
 */
@ApiModel("管理后台 - 库存记录字表-明细分页 Request VO")
@Data
@ToString(callSuper = true)
public class StockRecordDetailPrintVO implements Serializable {

    @ApiModelProperty(value = "库存批次号")
    @NotBlank(message = "库存批次号不能为空")
    private String stockBatchNo;

    @ApiModelProperty(value = "操作类型(0.入库 1.出库)")
    @NotNull(message = "操作类型不能为空")
    private Boolean operationType;

}
