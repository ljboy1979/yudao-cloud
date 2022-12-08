package cn.acsm.module.transaction.order.controller.admin.deliveryinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 配送 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class DeliveryInfoExcelVO {

    @ExcelProperty("ID")
    private String id;

    @ExcelProperty("配送编号")
    private String deliveryCode;

    @ExcelProperty("用户id")
    private String userId;

    @ExcelProperty("货架id")
    private String shelvesId;

    @ExcelProperty("计划id")
    private String planId;

    @ExcelProperty("订单id")
    private String orderId;

    @ExcelProperty("配送状态(0未配送 1已配送 2配送装箱中)")
    private String sendStatus;

    @ExcelProperty("备注信息")
    private String remarks;

    @ExcelProperty("来源")
    private String source;

    @ExcelProperty("科室")
    private String department;

    @ExcelProperty("床位号")
    private String bedNumber;

    @ExcelProperty("地址")
    private String address;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("手机号")
    private String phone;

    @ExcelProperty("数量")
    private String num;

    @ExcelProperty("配送时间")
    private Date deliveryTime;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

}
