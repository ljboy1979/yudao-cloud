package cn.acsm.module.resource.controller.admin.adoptcontentadoptprice.vo;

import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightRespVO;
import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 认养/租凭价格 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AdoptContentAdoptPriceRespVO extends AdoptContentAdoptPriceBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    @ApiModelProperty(value = "认养权益")
    private AdoptRightRespVO adoptRights;

}
