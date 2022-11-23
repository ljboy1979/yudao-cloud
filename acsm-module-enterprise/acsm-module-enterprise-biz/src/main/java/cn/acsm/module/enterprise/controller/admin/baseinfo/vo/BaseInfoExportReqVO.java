package cn.acsm.module.enterprise.controller.admin.baseinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 经营主体 Excel 导出 Request VO", description = "参数和 BaseInfoPageReqVO 是一致的")
@Data
public class BaseInfoExportReqVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;

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

    @ApiModelProperty(value = "经营状态")
    private String manageStatus;

    @ApiModelProperty(value = "注册时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] registerTime;

}
