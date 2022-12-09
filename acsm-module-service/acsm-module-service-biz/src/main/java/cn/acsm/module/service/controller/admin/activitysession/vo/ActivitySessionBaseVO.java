package cn.acsm.module.service.controller.admin.activitysession.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 时间排期 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ActivitySessionBaseVO {

    @ApiModelProperty(value = "最多参与人数")
    private String maxAttendPeople;

    @ApiModelProperty(value = "实际参与人数")
    private String attendPeople;

    @ApiModelProperty(value = "活动报名费用")
    private String registrationFee;

    @ApiModelProperty(value = "活动id")
    private String activityId;

    @ApiModelProperty(value = "开始时间")
    private String startTime;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "服务id")
    private String serviceId;

    @ApiModelProperty(value = "开始日期")
    private String startDate;

    @ApiModelProperty(value = "结束日期")
    private Date endDate;

    @ApiModelProperty(value = "结束时间")
    private String endTime;

    @ApiModelProperty(value = "基地id")
    private String basesId;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "项目来源")
    private String source;

}
