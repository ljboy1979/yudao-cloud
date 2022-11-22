package cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo;

import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.PolicySubsidiesInfoBaseVO;
import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 企业政策补贴信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PolicySubsidiesInfoRespVO extends PolicySubsidiesInfoBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
