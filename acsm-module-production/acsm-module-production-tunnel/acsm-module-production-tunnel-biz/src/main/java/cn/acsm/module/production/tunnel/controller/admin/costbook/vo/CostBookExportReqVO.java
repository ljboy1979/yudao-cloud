package cn.acsm.module.production.tunnel.controller.admin.costbook.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 地块账本 Excel 导出 Request VO", description = "参数和 CostBookPageReqVO 是一致的")
@Data
public class CostBookExportReqVO {

    @ApiModelProperty(value = "编号")
    private String costCode;

    @ApiModelProperty(value = "来源")
    private String costSource;

    @ApiModelProperty(value = "主体")
    private String entityId;

    @ApiModelProperty(value = "类型(0支出,1收入)")
    private String costType;

    @ApiModelProperty(value = "单据名称")
    private String accountName;

    @ApiModelProperty(value = "账目内容")
    private String accountInfo;

    @ApiModelProperty(value = "账目金额")
    private BigDecimal accountAmount;

    @ApiModelProperty(value = "时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] accountTime;

    @ApiModelProperty(value = "地点")
    private String accountLocation;

    @ApiModelProperty(value = "记账时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] accountingTime;

    @ApiModelProperty(value = "详情")
    private String remarks;

    @ApiModelProperty(value = "计数器")
    private Integer counter;

    @ApiModelProperty(value = "机构编码")
    private String officeCode;

    @ApiModelProperty(value = "机构名称")
    private String officeName;

    @ApiModelProperty(value = "公司编码")
    private String companyCode;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "审核状态")
    private String reviewStatus;

    @ApiModelProperty(value = "审核人")
    private String reviewer;

    @ApiModelProperty(value = "审核时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] reviewDate;

    @ApiModelProperty(value = "审核内容")
    private String reviewContent;

    @ApiModelProperty(value = "租户代码")
    private String corpCode;

    @ApiModelProperty(value = "租户名称")
    private String corpName;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
