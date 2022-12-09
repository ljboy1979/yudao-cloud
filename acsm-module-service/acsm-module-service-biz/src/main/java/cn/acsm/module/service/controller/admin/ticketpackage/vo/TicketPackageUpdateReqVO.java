package cn.acsm.module.service.controller.admin.ticketpackage.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 套票更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TicketPackageUpdateReqVO extends TicketPackageBaseVO {

    @ApiModelProperty(value = "套票编号", required = true)
    @NotNull(message = "套票编号不能为空")
    private Long id;

}
