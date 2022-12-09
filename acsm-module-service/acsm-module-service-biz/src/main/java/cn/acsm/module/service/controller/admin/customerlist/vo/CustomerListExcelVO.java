package cn.acsm.module.service.controller.admin.customerlist.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 服务客户名单 Excel VO
 *
 * @author smile
 */
@Data
public class CustomerListExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("身份码")
    private String identityCode;

    @ExcelProperty("参与者姓名")
    private String participantName;

    @ExcelProperty("手机号码")
    private String cellphoneNumber;

    @ExcelProperty("身份证号")
    private String idNumber;

    @ExcelProperty("性别")
    private String gender;

    @ExcelProperty("服务交易id")
    private String serviceOrderId;

    @ExcelProperty("收款账户")
    private String payee;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("项目来源")
    private String source;

}
