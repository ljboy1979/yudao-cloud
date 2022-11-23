package cn.acsm.module.wallet.controller.admin.wechat.vo;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 微信支付配置信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WechatConfigInfoUpdateReqVO extends WechatConfigInfoBaseVO {

    @ApiModelProperty(value = "主键ID", required = true)
    @NotNull(message = "主键ID不能为空")
    private Long id;

}
