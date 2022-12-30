package cn.acsm.module.stock.controller.admin.recorddetail.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <pre>
 * 对象功能: StockRecordDetailOutEnterVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/22
 * <pre>
 */
@ApiModel("管理后台 - 3.7.2.13.修改出/入库记录 Request VO")
@Data
@ToString(callSuper = true)
public class StockRecordDetailOutEnterVO implements Serializable {

    @ApiModelProperty(value = "库存记录明细id", required = true)
    @NotNull(message = "库存记录明细id不能为空")
    private Long id;

    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "优惠金额")
    private BigDecimal discountPrice;

    @ApiModelProperty(value = "付款方式")
    private String payMethod;

    @ApiModelProperty(value = "合计总价")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "生产批次号", required = true)
    private String productionBatchNo;

    @ApiModelProperty(value = "入库来源")
    private String treasurySource;

    @ApiModelProperty(value = "数量")
    private Integer deliveryQuantity;

    @ApiModelProperty(value = "来源说明")
    private String sourceTo;

    @ApiModelProperty(value = "货位id")
    private Long goodsAllocationId;

    @ApiModelProperty(value = "货位名称")
    private Long goodsAllocationName;

    @ApiModelProperty(value = "部门id")
    private Long departmentId;

    @ApiModelProperty(value = "公司id")
    private Long companyId;



}
