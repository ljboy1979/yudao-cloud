package cn.acsm.module.member.user.controller.admin.integral.vo.rules;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 会员积分规则 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class IntegralRulesBaseVO {

    @ApiModelProperty(value = "企业id")
    private Long enterpriseId;

    @ApiModelProperty(value = "企业名称")
    private String enterpriseName;

    @ApiModelProperty(value = "上级项目")
    private Long parentLevelProject;

    @ApiModelProperty(value = "评分项目")
    private Long ratingItems;

    @ApiModelProperty(value = "数值范围")
    private String rangeValues;

    @ApiModelProperty(value = "积分上限")
    private String integralMax;

    @ApiModelProperty(value = "积分下限")
    private String integralMin;

    @ApiModelProperty(value = "积分值")
    private String integralValue;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
