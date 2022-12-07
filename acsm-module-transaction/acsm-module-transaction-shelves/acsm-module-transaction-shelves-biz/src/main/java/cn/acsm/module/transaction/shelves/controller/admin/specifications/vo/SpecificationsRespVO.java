package cn.acsm.module.transaction.shelves.controller.admin.specifications.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 货架规格 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SpecificationsRespVO extends SpecificationsBaseVO {

    @ApiModelProperty(value = "id", required = true)
    private String id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
