package cn.acsm.module.transaction.order.controller.admin.settleinfo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 订单结账 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class SettleInfoBaseVO {

    @ApiModelProperty(value = "订单id")
    @NotNull(message = "订单id不能为空")
    private String orderId;
    @ApiModelProperty(value = "编号")
    private String code;
    @ApiModelProperty(value = "结账金额")
    @NotNull(message = "结账金额不能为空")
    private BigDecimal settlePrice;

    @ApiModelProperty(value = "实付金额")
    @NotNull(message = "实付金额不能为空")
    private BigDecimal actualPrice;

    @ApiModelProperty(value = "支付方式 0 对公转账  ")
    @NotNull(message = "支付方式不能为空")
    private String payType;

    @ApiModelProperty(value = "支付凭证")
    private String img;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "结账时间")
    @NotNull(message = "结账时间不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date settleTime;

    @ApiModelProperty(value = "状态", required = true)
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

}
