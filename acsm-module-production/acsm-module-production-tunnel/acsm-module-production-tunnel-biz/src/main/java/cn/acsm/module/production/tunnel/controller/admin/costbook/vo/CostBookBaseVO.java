package cn.acsm.module.production.tunnel.controller.admin.costbook.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
* 地块账本 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CostBookBaseVO {

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
    private Date accountTime;

    @ApiModelProperty(value = "地点")
    private String accountLocation;

    @ApiModelProperty(value = "记账时间")
    private Date accountingTime;

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
    private Date reviewDate;

    @ApiModelProperty(value = "审核内容")
    private String reviewContent;

    @ApiModelProperty(value = "租户代码", required = true)
    @NotNull(message = "租户代码不能为空")
    private String corpCode;

    @ApiModelProperty(value = "租户名称", required = true)
    @NotNull(message = "租户名称不能为空")
    private String corpName;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
