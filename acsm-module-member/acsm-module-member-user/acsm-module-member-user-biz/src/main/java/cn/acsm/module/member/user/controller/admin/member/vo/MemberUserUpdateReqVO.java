package cn.acsm.module.member.user.controller.admin.member.vo;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 会员更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberUserUpdateReqVO extends MemberUserBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    @NotNull(message = "编号不能为空")
    private Long id;

}
