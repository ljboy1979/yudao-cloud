package cn.acsm.module.purchase.controller.admin.quotationelectronic.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 采购报价单电子 Excel 导出 Request VO", description = "参数和 PurchaseQuotationElectronicPageReqVO 是一致的")
@Data
public class PurchaseQuotationElectronicExportReqVO {

    @ApiModelProperty(value = "报价单id")
    private Long quotationId;

    @ApiModelProperty(value = "报价单编号")
    private String quotationNo;

    @ApiModelProperty(value = "询价单明细id")
    private Long inquiryId;

    @ApiModelProperty(value = "商品id")
    private Long commodityId;

    @ApiModelProperty(value = "分类id")
    private Long classifyId;

    @ApiModelProperty(value = "规格id")
    private Long specificationsId;

    @ApiModelProperty(value = "起批数量")
    private Integer initialBatchCount;

    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "采购数量")
    private Integer purchaseCount;

    @ApiModelProperty(value = "总价")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] startTime;

    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] endTime;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体")
    private String subjectId;

}
