package cn.acsm.module.purchase.controller.admin.order.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 采购单分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PurchaseOrderPageReqVO extends PageParam {

    @ApiModelProperty(value = "采购类型(1:原料 2:投入品 3:成品 4:办公用品)")
    private String purchaseType;

    @ApiModelProperty(value = "二级分类")
    private String secondaryClassification;

    @ApiModelProperty(value = "采购单号")
    private String purchaseNumber;

    @ApiModelProperty(value = "供应商(用户id)")
    private Long providerId;

    @ApiModelProperty(value = "供应商名称")
    private String providerName;

    @ApiModelProperty(value = "供应商联系方式")
    private String providerPhone;

    @ApiModelProperty(value = "采购时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] purchaseTime;

    @ApiModelProperty(value = "采购完成时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] complateTime;

    @ApiModelProperty(value = "采购总额（元）")
    private BigDecimal purchaseTotalAmount;

    @ApiModelProperty(value = "结算方式1货到付款、2先款后货、3账期付款、4其他")
    private String settlementType;

    @ApiModelProperty(value = "收款名称")
    private String beneficiaryName;

    @ApiModelProperty(value = "开户行")
    private String bankDeposit;

    @ApiModelProperty(value = "收款账号")
    private String collectionAccount;

    @ApiModelProperty(value = "付款方式(0微信1银联2支付宝3现金)")
    private String payWay;

    @ApiModelProperty(value = "采购人id")
    private String purchaserId;

    @ApiModelProperty(value = "采购人姓名")
    private String purchaserName;

    @ApiModelProperty(value = "采购部门id")
    private String purchaseOfficeId;

    @ApiModelProperty(value = "采购部门名称")
    private String purchaseOfficeName;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区")
    private String country;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "经度")
    private BigDecimal longitude;

    @ApiModelProperty(value = "纬度")
    private BigDecimal latitude;

    @ApiModelProperty(value = "基地id")
    private String basesId;

    @ApiModelProperty(value = "地块id")
    private String tunnelId;

    @ApiModelProperty(value = "采购状态(1.未开始 2.执行中 3.已完成 4.其他)")
    private String purchaseStatus;

    @ApiModelProperty(value = "报价单id")
    private String quoteId;

    @ApiModelProperty(value = "有效期")
    private String effectiveStage;

    @ApiModelProperty(value = "采收批次号")
    private String batchCode;

    @ApiModelProperty(value = "交易单号")
    private String transactionNumber;

    @ApiModelProperty(value = "采购单来源(1:自主采购 2:主体采购 3:集单采购 4:报价单采购)")
    private String source;

    @ApiModelProperty(value = "状态(1.待生效 2.有效 3.无效)")
    private String status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体")
    private String subjectId;

}
