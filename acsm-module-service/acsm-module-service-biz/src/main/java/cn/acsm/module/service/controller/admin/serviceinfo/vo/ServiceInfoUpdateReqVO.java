package cn.acsm.module.service.controller.admin.serviceinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 服务更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ServiceInfoUpdateReqVO extends ServiceInfoBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    @NotNull(message = "编号不能为空")
    private Long id;

    @ApiModelProperty(value = "认养/租赁ids")
    private String adoptContentIds;

}
