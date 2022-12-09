package cn.acsm.module.resource.controller.admin.adoptcontentadoptprice.vo;

import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightCreateReqVO;
import lombok.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 认养/租凭价格创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AdoptContentAdoptPriceCreateReqVO extends AdoptContentAdoptPriceBaseVO {

    @ApiModelProperty(value = "认养权益")
    private AdoptRightCreateReqVO adoptRight;

}
