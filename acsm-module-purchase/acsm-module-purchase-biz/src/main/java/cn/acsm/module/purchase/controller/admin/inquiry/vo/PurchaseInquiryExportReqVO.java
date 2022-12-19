package cn.acsm.module.purchase.controller.admin.inquiry.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 采购询价电子 Excel 导出 Request VO", description = "参数和 PurchaseInquiryPageReqVO 是一致的")
@Data
public class PurchaseInquiryExportReqVO {

    @ApiModelProperty(value = "商品id")
    private Long commodityId;

    @ApiModelProperty(value = "分类id")
    private Long commodityCategoryId;

    @ApiModelProperty(value = "规格id")
    private Long productSpecificationsId;

    @ApiModelProperty(value = "计划数量最低")
    private String plannedQuantityMin;

    @ApiModelProperty(value = "计划数量最高")
    private String plannedQuantityMax;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体")
    private String subjectId;

}
