package cn.acsm.module.purchase.api.loss.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <pre>
 * 对象功能: LossReqDTO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/21
 * <pre>
 */
@ApiModel("管理后台 - 损耗信息创建 Response DTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LossReqDTO implements Serializable {

    @ApiModelProperty(value = "采购单id", required = true)
    @NotNull(message = "采购单id不能为空")
    private Long purchaseId;

    @ApiModelProperty(value = "采购单号", required = true)
    @NotBlank(message = "采购单号不能为空")
    private String purchaseNumber;

    @ApiModelProperty(value = "货品id", required = true)
    @NotNull(message = "货品id不能为空")
    private Long goodsId;

    @ApiModelProperty(value = "货品名称")
    private String goodsName;

    @ApiModelProperty(value = "包装规格", required = true)
    @NotBlank(message = "包装规格不能为空")
    private String packingSpecification;

    @ApiModelProperty(value = "规格单位", required = true)
    @NotBlank(message = "规格单位不能为空")
    private String specificationUnit;

    @ApiModelProperty(value = "损耗数量", required = true)
    @NotNull(message = "损耗数量不能为空")
    private Integer lossCount;

    @ApiModelProperty(value = "损耗重量", required = true)
    @NotNull(message = "损耗重量不能为空")
    private Integer lossWeight;

    @ApiModelProperty(value = "金额", required = true)
    @NotNull(message = "金额不能为空")
    private BigDecimal amount;

    @ApiModelProperty(value = "报损人编号", required = true)
    @NotNull(message = "报损人编号不能为空")
    private Long managerId;

    @ApiModelProperty(value = "报损人姓名", required = true)
    private String manager;

    @ApiModelProperty(value = "库存记录编号", required = true)
    @NotNull(message = "库存记录编号不能为空")
    private Long stockId;

    @ApiModelProperty(value = "入库批次号", required = true)
    @NotBlank(message = "入库批次号不能为空")
    private String receiptBatchNo;

    @ApiModelProperty(value = "库存记录明细id", required = true)
    @NotNull(message = "库存记录明细id不能为空")
    private Long inventoryRecordDetailsId;

    @ApiModelProperty(value = "货品id", required = true)
    @NotBlank(message = "货品id不能为空")
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
