package cn.acsm.module.purchase.controller.admin.loss.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel("管理后台 - 损耗创建 Request VO")
@Data
@ToString(callSuper = true)
public class PurchaseLossCreateReqVO implements Serializable {

    @ApiModelProperty(value = "采购单id", required = true)
    @NotNull(message = "采购单id不能为空")
    private Long purchaseId;

    @ApiModelProperty(value = "采购单号", required = true)
    private String purchaseNumber;

    @ApiModelProperty(value = "货品编号", required = true)
    @NotNull(message = "货品编号不能为空")
    private Long goodsId;

    @ApiModelProperty(value = "货单电子表-明细id", required = true)
    @NotNull(message = "货单电子表-明细id不能为空")
    private Long electronicBillOfGoodsId;

    @ApiModelProperty(value = "货架编号", required = true)
    private Long goodSkuId;

    @ApiModelProperty(value = "货品名称", required = true)
    private String goodsName;

    @ApiModelProperty(value = "包装规格", required = true)
    private String packingSpecification;

    @ApiModelProperty(value = "规格单位", required = true)
    private String specificationUnit;

    @ApiModelProperty(value = "损耗数量")
    @NotNull(message = "损耗数量不能为空")
    private Integer lossCount;

    @ApiModelProperty(value = "损耗重量")
    private Integer lossWeight;

    @ApiModelProperty(value = "金额【报损成本】")
    @NotNull(message = "金额【报损成本】不能为空")
    private BigDecimal amount;

    @ApiModelProperty(value = "报损人编号", required = true)
    @NotNull(message = "报损人编号不能为空")
    private Long managerId;

    @ApiModelProperty(value = "报损人姓名", required = true)
    @NotNull(message = "报损人姓名不能为空")
    private String manager;

    @ApiModelProperty(value = "报损时间")
    @NotBlank(message = "报损时间不能为空")
    private Date time;

    @ApiModelProperty(value = "库存记录编号", required = true)
    private Long stockId;

    @ApiModelProperty(value = "入库批次号", required = true)
    private String receiptBatchNo;

    @ApiModelProperty(value = "库存记录明细id", required = true)
    private Long inventoryRecordDetailsId;

    @ApiModelProperty(value = "经营主体", required = true)
    @NotBlank(message = "经营主体不能为空")
    private String subjectId;

    @ApiModelProperty(value = "租户编号", required = true)
    @NotBlank(message = "租户编号不能为空")
    private String tenantId;

    @ApiModelProperty(value = "租户集合", required = true)
    @NotNull(message = "租户集合不能为空")
    private Long sourceId;

    @ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id不能为空")
    private Long userId;

}
