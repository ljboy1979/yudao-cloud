package cn.acsm.module.purchase.controller.admin.inquiry.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("管理后台 - 采购询价创建 Request VO")
@Data
@ToString(callSuper = true)
public class PurchaseInquiryCreateReqVO implements Serializable {

    @ApiModelProperty(value = "询价单编号")
    private String enquiryId;

    @ApiModelProperty(value = "询价单名称", required = true)
    @NotNull(message = "询价单名称不能为空")
    private String enquiryName;

    @ApiModelProperty(value = "供应商id", required = true)
    @NotNull(message = "供应商id不能为空")
    private Long providerId;

    @ApiModelProperty(value = "供应商名称", required = true)
    @NotNull(message = "供应商名称不能为空")
    private String providerName;

    @ApiModelProperty(value = "发布状态（0未发布 1已发布）")
    @NotBlank(message = "发布状态不能为空")
    private String postStatus;

    // ---------- 询价单明细表数据

    @ApiModelProperty(value = "商品id", required = true)
    @NotBlank(message = "商品id不能为空")
    private String commodityId;

    @ApiModelProperty(value = "分类id", required = true)
    @NotNull(message = "分类id不能为空")
    private Long commodityCategoryId;

    @ApiModelProperty(value = "规格id")
    private Long productSpecificationsId;

    @ApiModelProperty(value = "计划数量最低")
    private Integer plannedQuantityMin;

    @ApiModelProperty(value = "计划数量最高")
    private Integer plannedQuantityMax;

    @ApiModelProperty(value = "经营主体")
    @NotNull(message = "经营主体不能为空")
    private Long subjectId;

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Long userId;

    @ApiModelProperty(value = "租户集合")
    @NotNull(message = "租户集合不能为空")
    private Long sourceId;

    @ApiModelProperty(value = "租户集合")
    @NotNull(message = "租户集合不能为空")
    private Long tenantId;

}
