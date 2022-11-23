package cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 企业政策补贴信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PolicySubsidiesInfoBaseVO {

    @ApiModelProperty(value = "经营主体ID")
    private Long enterpriseId;

    @ApiModelProperty(value = "补贴种类")
    private String subsidiesCategory;

    @ApiModelProperty(value = "补贴名称")
    private String subsidiesName;

    @ApiModelProperty(value = "补贴金额")
    private BigDecimal subsidiesAmount;

    @ApiModelProperty(value = "补贴方式")
    private String subsidiesType;

    @ApiModelProperty(value = "补贴状态")
    private Integer subsidiesStatus;

    @ApiModelProperty(value = "申请人")
    private String applyPerson;

    @ApiModelProperty(value = "申请时间")
    private Date applyTime;

    @ApiModelProperty(value = "租户编号", required = true)
    @NotNull(message = "租户编号不能为空")
    private Long tenantId;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
