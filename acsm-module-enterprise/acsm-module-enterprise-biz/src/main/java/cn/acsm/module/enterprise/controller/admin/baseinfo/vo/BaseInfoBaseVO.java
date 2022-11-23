package cn.acsm.module.enterprise.controller.admin.baseinfo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 经营主体 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class BaseInfoBaseVO {

    @ApiModelProperty(value = "主体编号")
    private String code;

    @ApiModelProperty(value = "主体名称")
    private String name;

    @ApiModelProperty(value = "主体类型")
    private String enterpriseType;

    @ApiModelProperty(value = "主体类型名称")
    private String enterpriseTypeName;

    @ApiModelProperty(value = "状态")
    private String stauts;

    @ApiModelProperty(value = "产业角色")
    private String userTag;

    @ApiModelProperty(value = "产业角色名称")
    private String userTagName;

    @ApiModelProperty(value = "经营状态", required = true)
    @NotNull(message = "经营状态不能为空")
    private String manageStatus;

    @ApiModelProperty(value = "注册时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerTime;

    @ApiModelProperty(value = "联系人")
    private String contactName;

    @ApiModelProperty(value = "省id")
    private String villagesAreaId;

    @ApiModelProperty(value = "省名称")
    private String villagesAreaName;

    @ApiModelProperty(value = "市id")
    private String areaId;

    @ApiModelProperty(value = "市名称")
    private String areaName;

    @ApiModelProperty(value = "区id")
    private String ruralId;

    @ApiModelProperty(value = "区名称")
    private String ruralName;

}
