package cn.iocoder.yudao.module.system.controller.admin.area.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ApiModel("管理后台 - 行政区划更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AreaUpdateReqVO extends AreaBaseVO {

    @ApiModelProperty(value = "行政区划id", required = true)
    @NotNull(message = "行政区划id不能为空")
    private Long id;

}
