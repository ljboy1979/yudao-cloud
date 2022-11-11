package cn.acsm.module.member.user.controller.app.memberuserinfo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ApiModel("用户 APP - 用户基本信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppMemberUserInfoUpdateReqVO extends AppMemberUserInfoBaseVO {

    @ApiModelProperty(value = "用基本信息表ID", required = true)
    @NotNull(message = "用基本信息表ID不能为空")
    private Long id;

}
