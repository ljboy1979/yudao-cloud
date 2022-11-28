package cn.iocoder.yudao.module.transaction.sales.controller.admin.rawmaterialspecification.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 原料规格创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RawMaterialSpecificationCreateReqVO extends RawMaterialSpecificationBaseVO {

    @ApiModelProperty(value = "原料id")
    private String rawMaterialId;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

}
