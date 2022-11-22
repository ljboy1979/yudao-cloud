package cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 企业政策补贴信息创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PolicySubsidiesInfoCreateReqVO extends PolicySubsidiesInfoBaseVO {

    @ApiModelProperty(value = "经营主体ID")
    private Long enterpriseId;

    @ApiModelProperty(value = "补贴金额")
    private BigDecimal subsidiesAmount;

    @ApiModelProperty(value = "补贴方式")
    private String subsidiesType;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
