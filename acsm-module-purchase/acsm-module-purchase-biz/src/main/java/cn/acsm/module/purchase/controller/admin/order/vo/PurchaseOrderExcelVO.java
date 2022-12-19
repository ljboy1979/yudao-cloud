package cn.acsm.module.purchase.controller.admin.order.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购单 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PurchaseOrderExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("采购类型(1:原料 2:投入品 3:成品 4:办公用品)")
    private String purchaseType;

    @ExcelProperty("二级分类")
    private String secondaryClassification;

    @ExcelProperty("采购单号")
    private String purchaseNumber;

    @ExcelProperty("供应商(用户id)")
    private Long providerId;

    @ExcelProperty("供应商名称")
    private String providerName;

    @ExcelProperty("供应商联系方式")
    private String providerPhone;

    @ExcelProperty("采购时间")
    private Date purchaseTime;

    @ExcelProperty("采购完成时间")
    private Date complateTime;

    @ExcelProperty("采购总额（元）")
    private BigDecimal purchaseTotalAmount;

    @ExcelProperty("结算方式1货到付款、2先款后货、3账期付款、4其他")
    private String settlementType;

    @ExcelProperty("收款名称")
    private String beneficiaryName;

    @ExcelProperty("开户行")
    private String bankDeposit;

    @ExcelProperty("收款账号")
    private String collectionAccount;

    @ExcelProperty("付款方式(0微信1银联2支付宝3现金)")
    private String payWay;

    @ExcelProperty("采购人id")
    private String purchaserId;

    @ExcelProperty("采购人姓名")
    private String purchaserName;

    @ExcelProperty("采购部门id")
    private String purchaseOfficeId;

    @ExcelProperty("采购部门名称")
    private String purchaseOfficeName;

    @ExcelProperty("省")
    private String province;

    @ExcelProperty("市")
    private String city;

    @ExcelProperty("区")
    private String country;

    @ExcelProperty("详细地址")
    private String address;

    @ExcelProperty("经度")
    private BigDecimal longitude;

    @ExcelProperty("纬度")
    private BigDecimal latitude;

    @ExcelProperty("基地id")
    private String basesId;

    @ExcelProperty("地块id")
    private String tunnelId;

    @ExcelProperty("采购状态(1.未开始 2.执行中 3.已完成 4.其他)")
    private String purchaseStatus;

    @ExcelProperty("报价单id")
    private String quoteId;

    @ExcelProperty("有效期")
    private String effectiveStage;

    @ExcelProperty("采收批次号")
    private String batchCode;

    @ExcelProperty("交易单号")
    private String transactionNumber;

    @ExcelProperty("采购单来源(1:自主采购 2:主体采购 3:集单采购 4:报价单采购)")
    private String source;

    @ExcelProperty("状态(1.待生效 2.有效 3.无效)")
    private String status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体")
    private String subjectId;

}
