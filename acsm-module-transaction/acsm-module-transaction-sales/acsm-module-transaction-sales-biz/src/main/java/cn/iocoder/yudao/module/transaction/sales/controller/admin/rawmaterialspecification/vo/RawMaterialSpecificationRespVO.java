package cn.iocoder.yudao.module.transaction.sales.controller.admin.rawmaterialspecification.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 原料规格 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RawMaterialSpecificationRespVO extends RawMaterialSpecificationBaseVO {

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
