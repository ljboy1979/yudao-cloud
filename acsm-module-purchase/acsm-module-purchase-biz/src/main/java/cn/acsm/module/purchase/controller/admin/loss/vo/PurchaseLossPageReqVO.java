package cn.acsm.module.purchase.controller.admin.loss.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 损耗分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PurchaseLossPageReqVO extends PageParam {

    @ApiModelProperty(value = "采购单id")
    private Long purchaseId;

    @ApiModelProperty(value = "采购单号")
    private String purchaseNumber;

    @ApiModelProperty(value = "货品编号")
    private Long goodsId;

    @ApiModelProperty(value = "货单电子表-明细id")
    private Long electronicBillOfGoodsId;

    @ApiModelProperty(value = "货架编号")
    private Long goodSkuId;

    @ApiModelProperty(value = "货品名称")
    private String goodsName;

    @ApiModelProperty(value = "包装规格")
    private String packingSpecification;

    @ApiModelProperty(value = "规格单位")
    private String specificationUnit;

    @ApiModelProperty(value = "损耗数量")
    private Integer lossCount;

    @ApiModelProperty(value = "损耗重量")
    private Integer lossWeight;

    @ApiModelProperty(value = "金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "报损人编号")
    private Long managerId;

    @ApiModelProperty(value = "报损人姓名")
    private String manager;

    @ApiModelProperty(value = "报损时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date[] time;

    @ApiModelProperty(value = "库存记录编号")
    private Long stockId;

    @ApiModelProperty(value = "入库批次号")
    private String receiptBatchNo;

    @ApiModelProperty(value = "库存记录明细id")
    private Long inventoryRecordDetailsId;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

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
