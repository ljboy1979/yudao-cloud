package cn.acsm.module.enterprise.controller.admin.baseinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 经营主体分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BaseInfoPageReqVO extends PageParam {

    @ApiModelProperty(value = "主体编号")
    private String code;

    @ApiModelProperty(value = "主体名称")
    private String name;

    @ApiModelProperty(value = "主体类型")
    private String enterpriseType;

    @ApiModelProperty(value = "状态")
    private String stauts;

    @ApiModelProperty(value = "产业角色")
    private String userTag;

    @ApiModelProperty(value = "经营状态")
    private String manageStatus;

    @ApiModelProperty(value = "注册时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] registerTime;

}
