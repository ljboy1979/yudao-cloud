package cn.acsm.module.purchase.api.purchase.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * 对象功能: PurchaseReqDTO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/13
 * <pre>
 */
@ApiModel("管理后台 - 采购 Response DTO")
@Data
public class PurchaseOrderReqDTO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 采购类型(1:原料 2:投入品 3:成品 4:办公用品)
     */
    private String purchaseType;
    /**
     * 二级分类
     */
    private String secondaryClassification;
    /**
     * 采购单号
     */
    private String purchaseOrderNumber;
    /**
     * 供应商(用户id)
     */
    private Long providerId;
    /**
     * 供应商名称
     */
    private String providerName;
    /**
     * 供应商联系方式
     */
    private String providerContactInformation;
    /**
     * 采购时间
     */
    private Date purchaseTime;
    /**
     * 采购完成时间
     */
    private Date purchaseCompletionTime;
    /**
     * 采购总额（元）
     */
    private BigDecimal totalProcurement;
    /**
     * 结算方式
     */
    private String settlementMethod;
    /**
     * 收款名称
     */
    private String beneficiaryName;
    /**
     * 开户行
     */
    private String bankOfDeposit;
    /**
     * 收款账号
     */
    private String collectionAccountNo;
    /**
     * 付款方式(0:微信 1:银联 2:支付宝 3:现金)
     */
    private String paymentMethod;
    /**
     * 采购人(用户id)
     */
    private Long purchaserId;
    /**
     * 采购人姓名
     */
    private String purchaserName;
    /**
     * 采购部门id
     */
    private String procurementDepartmentId;
    /**
     * 采购部门名称
     */
    private String procurementDepartmentName;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String area;
    /**
     * 详细地址
     */
    private String detailedAddress;
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 纬度
     */
    private BigDecimal latitude;
    /**
     * 基地id
     */
    private Long baseId;
    /**
     * 地块id
     */
    private Long massifId;
    /**
     * 采购状态(1.未开始 2.执行中 3.已完成 4.其他)
     */
    private String purchaseStatus;
    /**
     * 报价单id
     */
    private Long quotationId;
    /**
     * 报价单号
     */
    private String quotationNo;
    /**
     * 有效期
     */
    private String termOfValidity;
    /**
     * 采收批次号
     */
    private String collectionBatchNo;
    /**
     * 交易单号(多个交易单用 "," 分割)
     */
    private String transactionNo;
    /**
     * 采购单来源(1:自主采购 2:主体采购 3:集单采购 4:报价单采购)
     */
    private String purchaseOrderSource;
    /**
     * 状态(1.待生效 2.有效 3.无效)
     */
    private String status;

}
