package cn.acsm.module.member.wallet.controller.admin.walletinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 用户钱包信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserWalletInfoRespVO extends UserWalletInfoBaseVO {

    @ApiModelProperty(value = "主键ID", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
