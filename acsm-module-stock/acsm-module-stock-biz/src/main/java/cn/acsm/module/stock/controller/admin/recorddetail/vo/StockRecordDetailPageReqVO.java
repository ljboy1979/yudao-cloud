package cn.acsm.module.stock.controller.admin.recorddetail.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 库存记录字表-明细分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockRecordDetailPageReqVO extends PageParam {

    @ApiModelProperty(value = "库存记录id")
    private Long recordId;

    @ApiModelProperty(value = "库存批次号")
    @NotBlank(message = "库存批次号不能为空")
    private String stockBatchNo;

    @ApiModelProperty(value = "操作类型(0.入库 1.出库)")
    private Boolean operationType;

    @ApiModelProperty(value = "二级分类(成品类：套餐/商品/特医食品)")
    private String secondaryClassification;

    @ApiModelProperty(value = "货品id")
    private String goodsId;

    @ApiModelProperty(value = "货品编号")
    private String goodsNumber;

    @ApiModelProperty(value = "货品名称")
    @NotBlank(message = "货品名称不能为空")
    private String goodsName;

    @ApiModelProperty(value = "货品类型")
    @NotBlank(message = "货品类型不能为空")
    private String goodsType;

    @ApiModelProperty(value = "包装类型")
    private String packagingType;

    @ApiModelProperty(value = "包装规格")
    private String packingSpecification;

    @ApiModelProperty(value = "入库数量")
    private Integer receiptQuantity;

    @ApiModelProperty(value = "现有库存量")
    private Integer existingInventory;

    @ApiModelProperty(value = "出库数量")
    private Integer deliveryQuantity;

    @ApiModelProperty(value = "库存记录明细id(只出库类型才有值-对应入库记录)")
    private Long recordDetailId;

    @ApiModelProperty(value = "货位id")
    private Long goodsAllocationId;

    @ApiModelProperty(value = "货位号")
    private String goodsAllocationNo;

    @ApiModelProperty(value = "来源/去向说明")
    private String sourceTo;

    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "计量单位")
    private String unit;

    @ApiModelProperty(value = "合计总价")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "付款方式(0.微信 1.银联 2.支付宝 3.现金)")
    private String payMethod;

    @ApiModelProperty(value = "生产批次号")
    private String productionBatchNo;

    @ApiModelProperty(value = "基地")
    private String bases;

    @ApiModelProperty(value = "地块")
    private String tunnel;

    @ApiModelProperty(value = "入库来源")
    private String treasurySource;

    @ApiModelProperty(value = "采收记录id")
    private String harvestBatchId;

    @ApiModelProperty(value = "采购单id")
    private Long purchaseId;

    @ApiModelProperty(value = "采购单号")
    private String purchaseNumber;

    @ApiModelProperty(value = "加工单id")
    private Long processingOrderId;

    @ApiModelProperty(value = "称重记录id")
    private Long weighingRecordId;

    @ApiModelProperty(value = "包装单id")
    private Long packingListId;

    @ApiModelProperty(value = "临时时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] temporaryTime;

    @ApiModelProperty(value = "0.冷藏 1.冷冻 2.常温 3.保鲜 4.其他")
    private String environmentalRequirements;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体")
    private String subjectId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "租户集合")
    private Long sourceId;

}
