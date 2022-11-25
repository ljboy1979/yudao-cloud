package cn.iocoder.yudao.module.system.controller.admin.area.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ApiModel("管理后台 - 行政区划 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AreaRespVO extends AreaBaseVO {

    @ApiModelProperty(value = "行政区划id", required = true)
    private Long id;

}
