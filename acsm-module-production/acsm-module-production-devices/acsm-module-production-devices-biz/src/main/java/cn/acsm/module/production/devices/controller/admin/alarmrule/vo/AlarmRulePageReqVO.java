package cn.acsm.module.production.devices.controller.admin.alarmrule.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 告警规则分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AlarmRulePageReqVO extends PageParam {

    @ApiModelProperty(value = "设备id")
    private String deviceId;

    @ApiModelProperty(value = "告警参数id")
    private String paramId;

    @ApiModelProperty(value = "告警类型")
    private String alarmType;

    @ApiModelProperty(value = "告警上限")
    private BigDecimal alarmUp;

    @ApiModelProperty(value = "告警下限")
    private BigDecimal alarmDown;

    @ApiModelProperty(value = "告警内容")
    private String alarmContent;

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

    @ApiModelProperty(value = "告警参数名称")
    private String paramName;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
