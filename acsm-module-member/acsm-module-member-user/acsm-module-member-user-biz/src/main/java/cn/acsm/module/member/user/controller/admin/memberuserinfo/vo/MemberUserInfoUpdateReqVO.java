package cn.acsm.module.member.user.controller.admin.memberuserinfo.vo;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 用户基本信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberUserInfoUpdateReqVO extends MemberUserInfoBaseVO {

    @ApiModelProperty(value = "用基本信息表ID", required = true)
    @NotNull(message = "用基本信息表ID不能为空")
    private Long id;

}
