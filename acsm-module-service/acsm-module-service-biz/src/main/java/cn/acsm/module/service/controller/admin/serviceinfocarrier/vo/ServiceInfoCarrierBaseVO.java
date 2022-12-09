package cn.acsm.module.service.controller.admin.serviceinfocarrier.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 服务-认养物/租凭物 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ServiceInfoCarrierBaseVO {

    @ApiModelProperty(value = "认养物/租凭物的id", required = true)
    @NotNull(message = "认养物/租凭物的id不能为空")
    private String adoptContentAdoptId;

    @ApiModelProperty(value = "服务的id", required = true)
    @NotNull(message = "服务的id不能为空")
    private String serviceInfoId;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "项目来源")
    private String source;

}
