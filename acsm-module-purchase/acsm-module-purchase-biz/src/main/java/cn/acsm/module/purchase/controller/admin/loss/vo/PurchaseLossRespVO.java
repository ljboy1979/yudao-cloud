package cn.acsm.module.purchase.controller.admin.loss.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 损耗 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PurchaseLossRespVO extends PurchaseLossBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
