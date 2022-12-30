package cn.acsm.module.stock.controller.admin.recorddetail.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ApiModel("管理后台 - 出入库记录详情-明细分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockRecordDetailPageInOutVO extends PageParam {

    @ApiModelProperty(value = "操作类型(0.入库 1.出库)")
    private String operationType;

    @ApiModelProperty(value = "批次号")
    private String stockBatchNo;

    @ApiModelProperty(value = "货品名称")
    private String goodsName;

    @ApiModelProperty(value = "货品类型")
    private String goodsType;

}
