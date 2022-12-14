package cn.acsm.module.purchase.controller.admin.purchase.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购单 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PurchaseExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("采购类型(1:原料 2:投入品 3:成品 4:办公用品)")
    private String purchaseType;

    @ExcelProperty("二级分类")
    private String secondaryClassification;

    @ExcelProperty("采购单号")
    private String purchaseOrderNumber;

    @ExcelProperty("供应商(用户id)")
    private Long providerId;

    @ExcelProperty("供应商名称")
    private String providerName;

    @ExcelProperty("供应商联系方式")
    private String providerContactInformation;

    @ExcelProperty("采购时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date purchaseTime;

    @ExcelProperty("采购完成时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date purchaseCompletionTime;

    @ExcelProperty("采购总额（元）")
    private BigDecimal totalProcurement;

    @ExcelProperty("结算方式")
    private String settlementMethod;

    @ExcelProperty("收款名称")
    private String beneficiaryName;

    @ExcelProperty("开户行")
    private String bankOfDeposit;

    @ExcelProperty("收款账号")
    private String collectionAccountNo;

    @ExcelProperty("付款方式(0:微信 1:银联 2:支付宝 3:现金)")
    private String paymentMethod;

    @ExcelProperty("采购人(用户id)")
    private Long purchaserId;

    @ExcelProperty("采购人姓名")
    private String purchaserName;

    @ExcelProperty("采购部门id")
    private String procurementDepartmentId;

    @ExcelProperty("采购部门名称")
    private String procurementDepartmentName;

    @ExcelProperty("省")
    private String province;

    @ExcelProperty("市")
    private String city;

    @ExcelProperty("区")
    private String area;

    @ExcelProperty("详细地址")
    private String detailedAddress;

    @ExcelProperty("经度")
    private BigDecimal longitude;

    @ExcelProperty("纬度")
    private BigDecimal latitude;

    @ExcelProperty("基地id")
    private Long baseId;

    @ExcelProperty("地块id")
    private Long massifId;

    @ExcelProperty("采购状态(1.未开始 2.执行中 3.已完成 4.其他)")
    private String purchaseStatus;

    @ExcelProperty("报价单id")
    private Long quotationId;

    @ExcelProperty("报价单号")
    private String quotationNo;

    @ExcelProperty("有效期")
    private String termOfValidity;

    @ExcelProperty("采收批次号")
    private String collectionBatchNo;

    @ExcelProperty("交易单号(多个交易单用 ',' 分割)")
    private String transactionNo;

    @ExcelProperty("采购单来源(1:自主采购 2:主体采购 3:集单采购 4:报价单采购)")
    private String purchaseOrderSource;

    @ExcelProperty("状态(1.待生效 2.有效 3.无效)")
    private String status;

    @ExcelProperty("创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

}
