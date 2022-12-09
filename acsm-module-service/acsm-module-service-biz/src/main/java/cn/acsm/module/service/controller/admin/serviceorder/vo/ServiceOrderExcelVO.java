package cn.acsm.module.service.controller.admin.serviceorder.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 服务交易单 Excel VO
 *
 * @author smile
 */
@Data
public class ServiceOrderExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("交易单号")
    private String transactionNumber;

    @ExcelProperty("服务用户id")
    private String serviceUserId;

    @ExcelProperty("手机号")
    private String cellphoneNumber;

    @ExcelProperty("下单时间")
    private Date orderTime;

    @ExcelProperty("交易总额")
    private String totalAmount;

    @ExcelProperty("服务id")
    private String serviceId;

    @ExcelProperty("服务权益id")
    private String serviceEquitiesId;

    @ExcelProperty("参与人数")
    private String participation;

    @ExcelProperty("服务费")
    private String serviceCharge;

    @ExcelProperty("交易单状态:  0，待付款,1、待使用,2、已完成,3、已失效,4、已取消,5、退款中,6、已退款,7、已核销")
    private String orderStatus;

    @ExcelProperty("服务权益id")
    private String servicePriceId;

    @ExcelProperty("下单人")
    private String systemUserId;

    @ExcelProperty("认养物的id")
    private String carrierId;

    @ExcelProperty("订阅地区")
    private String areaCode;

    @ExcelProperty("订单类型(0 农事订单,1 认购订单)")
    private String orderType;

    @ExcelProperty("套票id")
    private String ticketPackageId;

    @ExcelProperty("支付方式(0.现金 1.套票)")
    private String payType;

    @ExcelProperty("活动场次id")
    private String activitySessionId;

    @ExcelProperty("家庭成员id")
    private String farmFamilyId;

    @ExcelProperty("微信支付系统订单号")
    private String weixinOrderId;

    @ExcelProperty("兑换码")
    private String exchangeCode;

    @ExcelProperty("核销操作人")
    private String scanOperator;

    @ExcelProperty("核销时间")
    private Date scanDate;

    @ExcelProperty("有效期")
    private Date expiryDate;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("项目来源")
    private String source;

}
