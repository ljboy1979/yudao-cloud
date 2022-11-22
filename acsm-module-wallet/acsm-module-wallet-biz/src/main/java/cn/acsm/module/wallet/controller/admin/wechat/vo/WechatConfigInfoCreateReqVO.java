package cn.acsm.module.wallet.controller.admin.wechat.vo;

import lombok.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 微信支付配置信息创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WechatConfigInfoCreateReqVO extends WechatConfigInfoBaseVO {

}
