package cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 企业政策补贴信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PolicySubsidiesInfoUpdateReqVO extends PolicySubsidiesInfoBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    @NotNull(message = "编号不能为空")
    private Long id;

    @ApiModelProperty(value = "补贴金额")
    private BigDecimal subsidiesAmount;

    @ApiModelProperty(value = "补贴方式")
    private String subsidiesType;

}
