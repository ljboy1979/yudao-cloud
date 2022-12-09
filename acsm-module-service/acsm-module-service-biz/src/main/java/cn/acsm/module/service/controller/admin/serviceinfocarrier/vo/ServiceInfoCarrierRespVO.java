package cn.acsm.module.service.controller.admin.serviceinfocarrier.vo;

import cn.acsm.module.resource.api.adoptcontent.dto.AdoptContentReqDTO;
import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 服务-认养物/租凭物 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ServiceInfoCarrierRespVO extends ServiceInfoCarrierBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    @ApiModelProperty(value = "认养/租赁", required = true)
    private AdoptContentReqDTO adoptContent;
}
