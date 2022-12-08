package cn.acsm.module.transaction.order.controller.admin.deliveryinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 配送 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class DeliveryInfoBaseVO {

    @ApiModelProperty(value = "配送编号", required = true)
    @NotNull(message = "配送编号不能为空")
    private String deliveryCode;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "货架id")
    private String shelvesId;

    @ApiModelProperty(value = "计划id")
    private String planId;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "配送状态(0未配送 1已配送 2配送装箱中)")
    private String sendStatus;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "来源")
    private String source;

    @ApiModelProperty(value = "科室")
    private String department;

    @ApiModelProperty(value = "床位号")
    private String bedNumber;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "数量")
    private String num;

    @ApiModelProperty(value = "配送时间")
    private Date deliveryTime;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

}
