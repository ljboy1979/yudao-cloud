package cn.acsm.module.service.controller.admin.activitysession.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 时间排期 Excel 导出 Request VO", description = "参数和 ActivitySessionPageReqVO 是一致的")
@Data
public class ActivitySessionExportReqVO {

    @ApiModelProperty(value = "最多参与人数")
    private String maxAttendPeople;

    @ApiModelProperty(value = "实际参与人数")
    private String attendPeople;

    @ApiModelProperty(value = "活动报名费用")
    private String registrationFee;

    @ApiModelProperty(value = "活动id")
    private String activityId;

    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private String[] startTime;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "服务id")
    private String serviceId;

    @ApiModelProperty(value = "开始日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private String[] startDate;

    @ApiModelProperty(value = "结束日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] endDate;

    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private String[] endTime;

    @ApiModelProperty(value = "基地id")
    private String basesId;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "项目来源")
    private String source;

}
