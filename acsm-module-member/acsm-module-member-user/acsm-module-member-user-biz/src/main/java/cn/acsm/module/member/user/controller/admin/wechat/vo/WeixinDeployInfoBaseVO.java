package cn.acsm.module.member.user.controller.admin.wechat.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 微信公众号配置信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class WeixinDeployInfoBaseVO {

    @ApiModelProperty(value = "公众号appId")
    private String appid;

    @ApiModelProperty(value = "公众号appSecret")
    private String appsecret;

    @ApiModelProperty(value = "商户号")
    private String mchId;

    @ApiModelProperty(value = "商户密钥key")
    private String mchKey;

    @ApiModelProperty(value = "标识")
    private String appletFlag;

    @ApiModelProperty(value = "备注信息")
    private String remark;

    @ApiModelProperty(value = "状态（0正常 1停用）", required = true)
    @NotNull(message = "状态（0正常 1停用）不能为空")
    private Integer status;

}
