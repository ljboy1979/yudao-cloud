package cn.acsm.module.service.controller.admin.customerlist.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 服务客户名单分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CustomerListPageReqVO extends PageParam {

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

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "项目来源")
    private String source;

}
