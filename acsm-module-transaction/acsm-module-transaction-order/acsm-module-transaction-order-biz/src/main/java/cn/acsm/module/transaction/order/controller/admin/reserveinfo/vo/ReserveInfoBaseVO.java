package cn.acsm.module.transaction.order.controller.admin.reserveinfo.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 预定订单 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ReserveInfoBaseVO {

    @ApiModelProperty(value = "预定id")
    private String planReserveId;

    @ApiModelProperty(value = "预定的用户")
    private String userId;

    @ApiModelProperty(value = "订金金额")
    private BigDecimal price;

    @ApiModelProperty(value = "预订单总金额")
    private BigDecimal actualPrice;

    @ApiModelProperty(value = "实付金额")
    private BigDecimal practicalPrice;

    @ApiModelProperty(value = "支付方式 0 账单 1 微信  ")
    private String payType;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "预定备注")
    private String orderRemarks;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "预定状态 0已预定 1已下单 2已过期 3已取消 4未付款 5已完成", required = true)
    @NotNull(message = "预定状态 0已预定 1已下单 2已过期 3已取消 4未付款 5已完成不能为空")
    private String payStatus;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "捕捞id 关联harvest_batch")
    private String harvestBatchId;

    @ApiModelProperty(value = "来源")
    private String source;

    @ApiModelProperty(value = "配送方式 0包邮 1不包邮")
    private String sendType;

    @ApiModelProperty(value = "物流费用")
    private BigDecimal logisticsPrice;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

}
