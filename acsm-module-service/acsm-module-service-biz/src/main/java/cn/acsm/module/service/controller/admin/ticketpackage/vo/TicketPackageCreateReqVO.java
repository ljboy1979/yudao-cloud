package cn.acsm.module.service.controller.admin.ticketpackage.vo;

import cn.acsm.module.service.controller.admin.ticketdetail.vo.TicketDetailCreateReqVO;
import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 套票创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TicketPackageCreateReqVO extends TicketPackageBaseVO {

    @ApiModelProperty(value = "套票详情List")
    private List<TicketDetailCreateReqVO> ticketDetailList;

}
