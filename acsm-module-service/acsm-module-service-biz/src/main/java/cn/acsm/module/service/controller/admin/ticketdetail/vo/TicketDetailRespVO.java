package cn.acsm.module.service.controller.admin.ticketdetail.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 套票详情 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TicketDetailRespVO extends TicketDetailBaseVO {

    @ApiModelProperty(value = "套票编号", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
