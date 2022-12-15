package cn.acsm.module.purchase.controller.admin.deliver.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 采购交付 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PurchaseDeliverExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("采购单编号")
    private Long purchaseId;

    @ExcelProperty("采购单号")
    private String purchaseNumber;

    @ExcelProperty("交付批次号(系统自动生成)")
    private String batchCode;

    @ExcelProperty("期望交付时间")
    private Date expectedDeliveryTime;

    @ExcelProperty("实际交付时间")
    private Date actualDelivery;

    @ExcelProperty("期望交付数量")
    private Integer expectedDeliveryCount;

    @ExcelProperty("实际交付数量")
    private Integer actualDeliveryCount;

    @ExcelProperty("单位(字典id)")
    private Long companyId;

    @ExcelProperty("结算时间")
    private Date settlementTime;

    @ExcelProperty("结算金额")
    private BigDecimal settlementAmount;

    @ExcelProperty("1.未交付 2.已交付")
    private String deliveryStatus;

    @ExcelProperty("发货单号")
    private String shipmentNo;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体")
    private String subjectId;

}
