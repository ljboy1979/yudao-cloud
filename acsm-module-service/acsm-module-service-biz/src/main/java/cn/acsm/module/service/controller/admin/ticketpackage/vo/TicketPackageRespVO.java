package cn.acsm.module.service.controller.admin.ticketpackage.vo;

import cn.iocoder.yudao.module.system.api.dict.dto.DictDataRespDTO;
import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 套票 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TicketPackageRespVO extends TicketPackageBaseVO {

    @ApiModelProperty(value = "套票编号", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    @ApiModelProperty(value = "字典数据")
    private DictDataRespDTO dictDataRespDTO;

}
