package cn.acsm.module.service.controller.admin.customerlist.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 服务客户名单 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CustomerListBaseVO {

    @ApiModelProperty(value = "身份码")
    private String identityCode;

    @ApiModelProperty(value = "参与者姓名")
    private String participantName;

    @ApiModelProperty(value = "手机号码")
    private String cellphoneNumber;

    @ApiModelProperty(value = "身份证号")
    private String idNumber;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "服务交易id")
    private String serviceOrderId;

    @ApiModelProperty(value = "收款账户")
    private String payee;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "项目来源")
    private String source;

}
