package cn.acsm.module.member.user.controller.admin.member.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 会员信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class MemberUserDetailBaseVO {

    @ApiModelProperty(value = "会员id", required = true)
    @NotNull(message = "会员id不能为空")
    private Long memberId;

    @ApiModelProperty(value = "企业账号")
    private String memberAccount;

    @ApiModelProperty(value = "企业id")
    private Long enterpriseId;

    @ApiModelProperty(value = "企业名称")
    private String enterpriseName;

    @ApiModelProperty(value = "会员类型")
    private Integer memberType;

    @ApiModelProperty(value = "会员角色")
    private Integer memberRole;

    @ApiModelProperty(value = "会员等级id")
    private Long integralLevelId;

    @ApiModelProperty(value = "审核状态 0-待审核 1-审核通过 2-已驳回 3-已解绑")
    private Integer auditStatus;

    @ApiModelProperty(value = "备注信息（审核驳回时必填）")
    private String remarks;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
