package cn.acsm.module.member.wallet.controller.admin.walletinfo.vo;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 用户钱包信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserWalletInfoUpdateReqVO extends UserWalletInfoBaseVO {

    @ApiModelProperty(value = "主键ID", required = true)
    @NotNull(message = "主键ID不能为空")
    private Long id;

}
