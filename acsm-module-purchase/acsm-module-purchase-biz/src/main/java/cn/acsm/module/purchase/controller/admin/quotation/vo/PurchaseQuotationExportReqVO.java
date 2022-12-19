package cn.acsm.module.purchase.controller.admin.quotation.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 采购询价电子 Excel 导出 Request VO", description = "参数和 PurchaseQuotationPageReqVO 是一致的")
@Data
public class PurchaseQuotationExportReqVO {

    @ApiModelProperty(value = "报价单编号")
    private Long quoteId;

    @ApiModelProperty(value = "报价单名称")
    private String quoteName;

    @ApiModelProperty(value = "采购商id")
    private Long purchaserId;

    @ApiModelProperty(value = "询价单编号")
    private Long enquiryId;

    @ApiModelProperty(value = "报价有效期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date[] indateDate;

    @ApiModelProperty(value = "是否提交 0：未提交 1：已提交")
    private Boolean submitStatus;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体")
    private String subjectId;

}
