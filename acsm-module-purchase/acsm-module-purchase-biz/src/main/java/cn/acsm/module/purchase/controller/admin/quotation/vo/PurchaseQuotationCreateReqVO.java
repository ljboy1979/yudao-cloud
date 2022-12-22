package cn.acsm.module.purchase.controller.admin.quotation.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ApiModel("管理后台 - 采购询价电子创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PurchaseQuotationCreateReqVO extends PurchaseQuotationBaseVO {

    @ApiModelProperty(value = "询价单明细id", required = true)
    @NotNull(message = "询价单明细id不能为空")
    private Long inquiryDetailId;

    @ApiModelProperty(value = "商品id", required = true)
    @NotNull(message = "商品id不能为空")
    private Long commodityId;

    @ApiModelProperty(value = "分类id", required = true)
    @NotNull(message = "分类id不能为空")
    private Long commodityCategoryId;

    @ApiModelProperty(value = "租户", required = true)
    @NotNull(message = "租户不能为空")
    private String tenantId;

    @ApiModelProperty(value = "userId", required = true)
    @NotNull(message = "userId不能为空")
    private String userId;

    @ApiModelProperty(value = "租户集合", required = true)
    @NotNull(message = "租户集合不能为空")
    private String sourceId;
}
