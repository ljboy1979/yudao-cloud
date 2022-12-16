package cn.acsm.module.production.devices.controller.admin.parameter.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 设备表参数 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ParameterBaseVO {

    @ApiModelProperty(value = "设备id")
    private String deviceId;

    @ApiModelProperty(value = "视频ip")
    private String paramDeviceIp;

    @ApiModelProperty(value = "视频http端口")
    private String paramHttpPort;

    @ApiModelProperty(value = "视频服务端口")
    private String paramDevicePort;

    @ApiModelProperty(value = "视频rtsp端口")
    private String paramRtspPort;

    @ApiModelProperty(value = "视频用户名")
    private String paramDeviceUsername;

    @ApiModelProperty(value = "视频密码")
    private String paramDevicePassword;

    @ApiModelProperty(value = "视频通道号")
    private String paramChanelNum;

    @ApiModelProperty(value = "组态王链接")
    private String kingViewUrl;

    @ApiModelProperty(value = "机构编码")
    private String officeCode;

    @ApiModelProperty(value = "机构名称")
    private String officeName;

    @ApiModelProperty(value = "公司编码")
    private String companyCode;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

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
