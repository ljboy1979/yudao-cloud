package cn.acsm.module.purchase.controller.admin.inquiry.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 采购询价电子 Excel 导出 Request VO", description = "参数和 PurchaseInquiryPageReqVO 是一致的")
@Data
public class PurchaseInquiryExportReqVO {

    @ApiModelProperty(value = "询价单编号")
    private String inquiryNo;

    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "分类id")
    private Long classifyId;

    @ApiModelProperty(value = "规格id")
    private Long specificationsId;

    @ApiModelProperty(value = "计划数量最低")
    private Integer lowestPlannedQuantity;

    @ApiModelProperty(value = "计划数量最高")
    private Integer highestPlannedQuantity;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体")
    private String subjectId;

}
