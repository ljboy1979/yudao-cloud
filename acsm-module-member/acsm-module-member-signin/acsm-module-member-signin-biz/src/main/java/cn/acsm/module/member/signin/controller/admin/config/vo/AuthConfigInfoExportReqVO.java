package cn.acsm.module.member.signin.controller.admin.config.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 会员登录授权配置信息 Excel 导出 Request VO", description = "参数和 AuthConfigInfoPageReqVO 是一致的")
@Data
public class AuthConfigInfoExportReqVO {

    @ApiModelProperty(value = "公众号appId")
    private String appId;

    @ApiModelProperty(value = "公众号appSecret")
    private String appSecret;

    @ApiModelProperty(value = "标识 1-微信")
    private String appletFlag;

    @ApiModelProperty(value = "备注信息")
    private String remark;

    @ApiModelProperty(value = "状态（0正常 1停用）")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
