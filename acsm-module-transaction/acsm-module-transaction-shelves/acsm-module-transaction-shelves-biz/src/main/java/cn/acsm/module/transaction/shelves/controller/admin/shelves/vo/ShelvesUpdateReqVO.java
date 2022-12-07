package cn.acsm.module.transaction.shelves.controller.admin.shelves.vo;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 货架更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ShelvesUpdateReqVO extends ShelvesBaseVO {

    @ApiModelProperty(value = "id", required = true)
    @NotNull(message = "id不能为空")
    private String id;

}
