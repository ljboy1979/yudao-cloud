package cn.acsm.module.user.user.controller.admin.wechat.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 微信登录信息记录 Excel 导出 Request VO", description = "参数和 WeixinLoginInfoPageReqVO 是一致的")
@Data
public class WeixinLoginInfoExportReqVO {

    @ApiModelProperty(value = "openid")
    private String openid;

    @ApiModelProperty(value = "用户手机号")
    private String phone;

    @ApiModelProperty(value = "系统的user_id")
    private String systemUserId;

    @ApiModelProperty(value = "用户头像地址")
    private String avatar;

    @ApiModelProperty(value = "省份名称")
    private String province;

    @ApiModelProperty(value = "市名称")
    private String city;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "性别(0女，1男)")
    private String sex;

    @ApiModelProperty(value = "类型 1-微信")
    private String type;

    @ApiModelProperty(value = "状态（0正常 1停用）")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
