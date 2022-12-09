package cn.acsm.module.service.controller.admin.serviceinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 服务创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ServiceInfoCreateReqVO extends ServiceInfoBaseVO {

    @ApiModelProperty(value = "认养/租赁ids")
    private String adoptContentIds;

}
