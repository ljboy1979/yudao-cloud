package cn.acsm.module.member.user.controller.admin.professional.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 专业资质 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ProfessionalQualificationBaseVO {

    @ApiModelProperty(value = "会员id", required = true)
    @NotNull(message = "会员id不能为空")
    private Long memberId;

    @ApiModelProperty(value = "备案类型")
    private String recordType;

    @ApiModelProperty(value = "备案名称")
    private String recordName;

    @ApiModelProperty(value = "许可证号码")
    private String permitNo;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "备案日期")
    private String recordDate;

    @ApiModelProperty(value = "证照")
    private String idPhoto;

    @ApiModelProperty(value = "审核状态")
    private Integer auditStatus;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
