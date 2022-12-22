package cn.acsm.module.purchase.controller.admin.inquirydetail.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 采购询价电子表 Excel 导出 Request VO", description = "参数和 PurchaseInquiryDetailPageReqVO 是一致的")
@Data
public class PurchaseInquiryDetailExportReqVO {

    @ApiModelProperty(value = "询价单编号")
    private String enquiryId;

    @ApiModelProperty(value = "商品id")
    private Long commodityId;

    @ApiModelProperty(value = "分类id")
    private Long commodityCategoryId;

    @ApiModelProperty(value = "规格id")
    private Long productSpecificationsId;

    @ApiModelProperty(value = "计划数量最低")
    private Integer plannedQuantityMin;

    @ApiModelProperty(value = "计划数量最高")
    private Integer plannedQuantityMax;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体")
    private String subjectId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "租户集合")
    private Long sourceId;

}
