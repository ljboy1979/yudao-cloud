package cn.acsm.module.resource.controller.admin.adoptcontent.vo;

import lombok.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 认养物/租凭物 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AdoptContentRespVO extends AdoptContentBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    private Long id;

}
