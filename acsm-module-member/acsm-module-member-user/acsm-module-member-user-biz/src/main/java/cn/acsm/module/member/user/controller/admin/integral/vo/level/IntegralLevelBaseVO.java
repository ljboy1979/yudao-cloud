package cn.acsm.module.member.user.controller.admin.integral.vo.level;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 会员积分等级 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class IntegralLevelBaseVO {

    @ApiModelProperty(value = "企业id")
    private Long enterpriseId;

    @ApiModelProperty(value = "企业名称")
    private String enterpriseName;

    @ApiModelProperty(value = "会员等级")
    private String memberLevel;

    @ApiModelProperty(value = "积分阀值")
    private Integer integralThreshold;

    @ApiModelProperty(value = "等级优惠")
    private String levelDiscount;

    @ApiModelProperty(value = "等级描述")
    private String levelDescription;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
