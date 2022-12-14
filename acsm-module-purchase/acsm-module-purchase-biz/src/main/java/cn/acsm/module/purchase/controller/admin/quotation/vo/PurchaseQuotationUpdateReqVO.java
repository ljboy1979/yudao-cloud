package cn.acsm.module.purchase.controller.admin.quotation.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 采购询价电子更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PurchaseQuotationUpdateReqVO extends PurchaseQuotationBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    @NotNull(message = "编号不能为空")
    private Long id;

}
