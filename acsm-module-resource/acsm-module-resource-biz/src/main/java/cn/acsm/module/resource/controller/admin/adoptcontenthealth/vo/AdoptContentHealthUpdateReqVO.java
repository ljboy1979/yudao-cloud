package cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 服务资源-认养物/租凭物就医记录更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AdoptContentHealthUpdateReqVO extends AdoptContentHealthBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    @NotNull(message = "编号不能为空")
    private Long id;

}
