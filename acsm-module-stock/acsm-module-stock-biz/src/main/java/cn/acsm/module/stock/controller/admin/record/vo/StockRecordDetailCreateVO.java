package cn.acsm.module.stock.controller.admin.record.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel("管理后台 - 库存记录字表-明细创建 Request VO")
@Data
@ToString(callSuper = true)
public class StockRecordDetailCreateVO implements Serializable {

    @ApiModelProperty(value = "库存记录明细id")
    private String id;

    @ApiModelProperty(value = "货品id")
    private String goodsId;

    @ApiModelProperty(value = "货品名称")
    private String goodsName;

    @ApiModelProperty(value = "分类")
    private String goodsType;

    @ApiModelProperty(value = "包装类型")
    private String packagingType;

    @ApiModelProperty(value = "包装规格")
    private String packingSpecification;

    @ApiModelProperty(value = "入库数量")
    private Integer receiptQuantity;

    @ApiModelProperty(value = "出库数量")
    private Integer deliveryQuantity;

    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "优惠")
    private BigDecimal discountPrice;

    @ApiModelProperty(value = "合计总价")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "付款方式(0.微信 1.银联 2.支付宝 3.现金)")
    private String payMethod;

    @ApiModelProperty(value = "所属公司id")
    private String companyId;

    @ApiModelProperty(value = "所属部门id")
    private String departmentId;

    @ApiModelProperty(value = "货位名称")
    private String goodsAllocationName;

    @ApiModelProperty(value = "入库来源")
    private String treasurySource;

    @ApiModelProperty(value = "来源批次号")
    private String foreignId;

    @ApiModelProperty(value = "来源说明")
    private String sourceTo;

}
