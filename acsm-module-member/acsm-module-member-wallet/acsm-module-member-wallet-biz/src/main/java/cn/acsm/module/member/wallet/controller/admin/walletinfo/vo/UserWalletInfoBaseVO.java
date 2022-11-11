package cn.acsm.module.member.wallet.controller.admin.walletinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 用户钱包信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class UserWalletInfoBaseVO {

    @ApiModelProperty(value = "钱包编号")
    private String walletId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "备注信息")
    private String remark;

    @ApiModelProperty(value = "状态（0正常 1停用）", required = true)
    @NotNull(message = "状态（0正常 1停用）不能为空")
    private Integer status;

}
