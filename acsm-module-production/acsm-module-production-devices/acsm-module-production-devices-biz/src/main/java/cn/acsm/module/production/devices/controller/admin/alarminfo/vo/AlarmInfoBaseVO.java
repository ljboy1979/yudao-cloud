package cn.acsm.module.production.devices.controller.admin.alarminfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 告警信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AlarmInfoBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    @NotNull(message = "编号不能为空")
    private Integer number;

    @ApiModelProperty(value = "告警类型")
    private String alarmType;

    @ApiModelProperty(value = "告警来源")
    private String alarmSource;

    @ApiModelProperty(value = "告警内容")
    private String alarmContent;

    @ApiModelProperty(value = "发生时间")
    private Date happenDate;

    @ApiModelProperty(value = "发生地点")
    private String happenPlace;

    @ApiModelProperty(value = "通知人(多个逗号隔开)")
    private String notifiers;

    @ApiModelProperty(value = "处理状态(0-待处理 1-已处理)")
    private String handleStatus;

    @ApiModelProperty(value = "处理描述")
    private String handleContent;

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

    @ApiModelProperty(value = "租户代码")
    private String corpCode;

    @ApiModelProperty(value = "租户名称")
    private String corpName;

    @ApiModelProperty(value = "设备id")
    private String devicesId;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备编号")
    private String deviceSn;

    @ApiModelProperty(value = "养殖户名称")
    private String subjectName;

    @ApiModelProperty(value = "静默小时")
    private Integer silenceHour;

    @ApiModelProperty(value = "静默截止期")
    private Date silenceExpiry;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
