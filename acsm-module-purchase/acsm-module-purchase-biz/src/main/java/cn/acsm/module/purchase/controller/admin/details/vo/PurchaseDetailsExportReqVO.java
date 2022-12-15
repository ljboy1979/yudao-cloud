package cn.acsm.module.purchase.controller.admin.details.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 采购单明细 Excel 导出 Request VO", description = "参数和 PurchaseDetailsPageReqVO 是一致的")
@Data
public class PurchaseDetailsExportReqVO {

    @ApiModelProperty(value = "采购单编号")
    private Long purchaseId;

    @ApiModelProperty(value = "采购单号")
    private String purchaseNumber;

    @ApiModelProperty(value = "货品编号")
    private Long goodsId;

    @ApiModelProperty(value = "货品名称")
    private String goodsName;

    @ApiModelProperty(value = "包装规格id")
    private Long packagingSpecificationId;

    @ApiModelProperty(value = "包装规格")
    private String packagingSpecification;

    @ApiModelProperty(value = "计量单位")
    private String unit;

    @ApiModelProperty(value = "包装类型")
    private String packagingType;

    @ApiModelProperty(value = "采购数量/重量")
    private BigDecimal buyNumber;

    @ApiModelProperty(value = "期望到货频次")
    private String frequency;

    @ApiModelProperty(value = "单价")
    private BigDecimal price;

    @ApiModelProperty(value = "优惠金额")
    private BigDecimal discount;

    @ApiModelProperty(value = "采购金额(总金额)")
    private BigDecimal total;

    @ApiModelProperty(value = "收货标准id")
    private Long standardId;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体")
    private String subjectId;

}
