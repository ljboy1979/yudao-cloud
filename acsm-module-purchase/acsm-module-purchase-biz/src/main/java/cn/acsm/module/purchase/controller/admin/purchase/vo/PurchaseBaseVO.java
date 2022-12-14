package cn.acsm.module.purchase.controller.admin.purchase.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 采购单 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PurchaseBaseVO {

    private long id;

    @ApiModelProperty(value = "采购类型(1:原料 2:投入品 3:成品 4:办公用品)")
    private String purchaseType;

    @ApiModelProperty(value = "二级分类")
    private String secondaryClassification;

    @ApiModelProperty(value = "采购单号", required = true)
    @NotNull(message = "采购单号不能为空")
    private String purchaseOrderNumber;

    @ApiModelProperty(value = "供应商(用户id)", required = true)
    @NotNull(message = "供应商(用户id)不能为空")
    private Long providerId;

    @ApiModelProperty(value = "供应商名称", required = true)
    @NotNull(message = "供应商名称不能为空")
    private String providerName;

    @ApiModelProperty(value = "供应商联系方式", required = true)
    @NotNull(message = "供应商联系方式不能为空")
    private String providerContactInformation;

    @ApiModelProperty(value = "采购时间", required = true)
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date purchaseTime;

    @ApiModelProperty(value = "采购完成时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date purchaseCompletionTime;

    @ApiModelProperty(value = "采购总额（元）")
    private BigDecimal totalProcurement;

    @ApiModelProperty(value = "结算方式")
    private String settlementMethod;

    @ApiModelProperty(value = "收款名称")
    private String beneficiaryName;

    @ApiModelProperty(value = "开户行")
    private String bankOfDeposit;

    @ApiModelProperty(value = "收款账号")
    private String collectionAccountNo;

    @ApiModelProperty(value = "付款方式(0:微信 1:银联 2:支付宝 3:现金)")
    private String paymentMethod;

    @ApiModelProperty(value = "采购人(用户id)", required = true)
    @NotNull(message = "采购人(用户id)不能为空")
    private Long purchaserId;

    @ApiModelProperty(value = "采购人姓名")
    private String purchaserName;

    @ApiModelProperty(value = "采购部门id")
    private String procurementDepartmentId;

    @ApiModelProperty(value = "采购部门名称")
    private String procurementDepartmentName;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区")
    private String area;

    @ApiModelProperty(value = "详细地址")
    private String detailedAddress;

    @ApiModelProperty(value = "经度")
    private BigDecimal longitude;

    @ApiModelProperty(value = "纬度")
    private BigDecimal latitude;

    @ApiModelProperty(value = "基地id")
    private Long baseId;

    @ApiModelProperty(value = "地块id")
    private Long massifId;

    @ApiModelProperty(value = "采购状态(1.未开始 2.执行中 3.已完成 4.其他)")
    private String purchaseStatus;

    @ApiModelProperty(value = "报价单id")
    private Long quotationId;

    @ApiModelProperty(value = "报价单号")
    private String quotationNo;

    @ApiModelProperty(value = "有效期")
    private String termOfValidity;

    @ApiModelProperty(value = "采收批次号")
    private String collectionBatchNo;

    @ApiModelProperty(value = "交易单号(多个交易单用 ',' 分割)")
    private String transactionNo;

    @ApiModelProperty(value = "采购单来源(1:自主采购 2:主体采购 3:集单采购 4:报价单采购)")
    private String purchaseOrderSource;

    @ApiModelProperty(value = "状态(1.待生效 2.有效 3.无效)")
    private String status;

}
