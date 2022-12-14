package cn.acsm.module.purchase.controller.admin.loss.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 损耗 Excel 导出 Request VO", description = "参数和 PurchaseLossPageReqVO 是一致的")
@Data
public class PurchaseLossExportReqVO {

    @ApiModelProperty(value = "采购单id")
    private Long orderId;

    @ApiModelProperty(value = "采购单号")
    private String orderNo;

    @ApiModelProperty(value = "货单id")
    private Long goodsId;

    @ApiModelProperty(value = "货单单号")
    private String goodsNo;

    @ApiModelProperty(value = "货电子表-明细id")
    private Long electronicBillOfGoodsId;

    @ApiModelProperty(value = "货架id")
    private Long goodsShelvesId;

    @ApiModelProperty(value = "货架号")
    private String goodsShelvesNo;

    @ApiModelProperty(value = "货品名称")
    private String goodsName;

    @ApiModelProperty(value = "包装规格")
    private String packingSpecifications;

    @ApiModelProperty(value = "规格单位")
    private String specificationUnit;

    @ApiModelProperty(value = "损耗数量")
    private Integer lossCount;

    @ApiModelProperty(value = "损耗重量")
    private Integer lossWeight;

    @ApiModelProperty(value = "金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "报损人id")
    private Long lossReporterId;

    @ApiModelProperty(value = "报损人姓名")
    private String lossReporterName;

    @ApiModelProperty(value = "报损时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] lossReporterTime;

    @ApiModelProperty(value = "库存记录id")
    private Long inventoryRecordsId;

    @ApiModelProperty(value = "入库批次号")
    private String receiptBatchNo;

    @ApiModelProperty(value = "库存记录明细id")
    private Long inventoryRecordDetailsId;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体")
    private String subjectId;

}
