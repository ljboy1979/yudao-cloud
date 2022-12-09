package cn.acsm.module.service.controller.admin.serviceorder.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 服务交易单 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ServiceOrderBaseVO {

    @ApiModelProperty(value = "交易单号")
    private String transactionNumber;

    @ApiModelProperty(value = "服务用户id")
    private String serviceUserId;

    @ApiModelProperty(value = "手机号")
    private String cellphoneNumber;

    @ApiModelProperty(value = "下单时间")
    private Date orderTime;

    @ApiModelProperty(value = "交易总额")
    private String totalAmount;

    @ApiModelProperty(value = "服务id")
    private String serviceId;

    @ApiModelProperty(value = "服务权益id")
    private String serviceEquitiesId;

    @ApiModelProperty(value = "参与人数")
    private String participation;

    @ApiModelProperty(value = "服务费")
    private String serviceCharge;

    @ApiModelProperty(value = "交易单状态:  0，待付款,1、待使用,2、已完成,3、已失效,4、已取消,5、退款中,6、已退款,7、已核销")
    private String orderStatus;

    @ApiModelProperty(value = "服务权益id")
    private String servicePriceId;

    @ApiModelProperty(value = "下单人")
    private String systemUserId;

    @ApiModelProperty(value = "认养物的id")
    private String carrierId;

    @ApiModelProperty(value = "订阅地区")
    private String areaCode;

    @ApiModelProperty(value = "订单类型(0 农事订单,1 认购订单)")
    private String orderType;

    @ApiModelProperty(value = "套票id")
    private String ticketPackageId;

    @ApiModelProperty(value = "支付方式(0.现金 1.套票)")
    private String payType;

    @ApiModelProperty(value = "活动场次id")
    private String activitySessionId;

    @ApiModelProperty(value = "家庭成员id")
    private String farmFamilyId;

    @ApiModelProperty(value = "微信支付系统订单号")
    private String weixinOrderId;

    @ApiModelProperty(value = "兑换码")
    private String exchangeCode;

    @ApiModelProperty(value = "核销操作人")
    private String scanOperator;

    @ApiModelProperty(value = "核销时间")
    private Date scanDate;

    @ApiModelProperty(value = "有效期")
    private Date expiryDate;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "项目来源")
    private String source;

}
