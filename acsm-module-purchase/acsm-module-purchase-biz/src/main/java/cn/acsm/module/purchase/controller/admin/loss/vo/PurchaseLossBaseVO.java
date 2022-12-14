package cn.acsm.module.purchase.controller.admin.loss.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
* 损耗 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PurchaseLossBaseVO {

    @ApiModelProperty(value = "采购单id", required = true)
    @NotNull(message = "采购单id不能为空")
    private Long orderId;

    @ApiModelProperty(value = "采购单号", required = true)
    @NotNull(message = "采购单号不能为空")
    private String orderNo;

    @ApiModelProperty(value = "货单id", required = true)
    @NotNull(message = "货单id不能为空")
    private Long goodsId;

    @ApiModelProperty(value = "货单单号", required = true)
    @NotNull(message = "货单单号不能为空")
    private String goodsNo;

    @ApiModelProperty(value = "货电子表-明细id", required = true)
    @NotNull(message = "货电子表-明细id不能为空")
    private Long electronicBillOfGoodsId;

    @ApiModelProperty(value = "货架id", required = true)
    @NotNull(message = "货架id不能为空")
    private Long goodsShelvesId;

    @ApiModelProperty(value = "货架号", required = true)
    @NotNull(message = "货架号不能为空")
    private String goodsShelvesNo;

    @ApiModelProperty(value = "货品名称", required = true)
    @NotNull(message = "货品名称不能为空")
    private String goodsName;

    @ApiModelProperty(value = "包装规格", required = true)
    @NotNull(message = "包装规格不能为空")
    private String packingSpecifications;

    @ApiModelProperty(value = "规格单位", required = true)
    @NotNull(message = "规格单位不能为空")
    private String specificationUnit;

    @ApiModelProperty(value = "损耗数量")
    private Integer lossCount;

    @ApiModelProperty(value = "损耗重量")
    private Integer lossWeight;

    @ApiModelProperty(value = "金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "报损人id", required = true)
    @NotNull(message = "报损人id不能为空")
    private Long lossReporterId;

    @ApiModelProperty(value = "报损人姓名", required = true)
    @NotNull(message = "报损人姓名不能为空")
    private String lossReporterName;

    @ApiModelProperty(value = "报损时间")
    private Date lossReporterTime;

    @ApiModelProperty(value = "库存记录id", required = true)
    @NotNull(message = "库存记录id不能为空")
    private Long inventoryRecordsId;

    @ApiModelProperty(value = "入库批次号", required = true)
    @NotNull(message = "入库批次号不能为空")
    private String receiptBatchNo;

    @ApiModelProperty(value = "库存记录明细id", required = true)
    @NotNull(message = "库存记录明细id不能为空")
    private Long inventoryRecordDetailsId;

    @ApiModelProperty(value = "经营主体", required = true)
    private String subjectId;

}
