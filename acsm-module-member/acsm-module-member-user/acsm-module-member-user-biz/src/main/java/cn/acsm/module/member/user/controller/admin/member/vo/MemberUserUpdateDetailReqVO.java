package cn.acsm.module.member.user.controller.admin.member.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ApiModel("管理后台 - 会员审核 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberUserUpdateDetailReqVO extends MemberUserBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    @NotNull(message = "编号不能为空")
    private Long id;

    @ApiModelProperty(value = "会员信息id", required = true)
    @NotNull(message = "会员信息id不能为空")
    private Long memberUserDetailId;

    @ApiModelProperty(value = "审核状态 0-待审核 1-审核通过 2-已驳回 3-已解绑", required = true)
    private Integer auditStatus;

    @ApiModelProperty(value = "会员类型 1-集采会员")
    private Integer memberType;

    @ApiModelProperty(value = "会员角色")
    private Integer memberRole;

    @ApiModelProperty(value = "备注信息（审核驳回时必填）")
    private String remarks;
}
