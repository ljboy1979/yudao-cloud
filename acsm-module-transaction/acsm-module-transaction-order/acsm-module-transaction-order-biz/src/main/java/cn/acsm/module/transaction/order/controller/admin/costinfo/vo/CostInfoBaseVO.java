package cn.acsm.module.transaction.order.controller.admin.costinfo.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 费用 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CostInfoBaseVO {

    @ApiModelProperty(value = "费用编号")
    private String costNumber;

    @ApiModelProperty(value = "费用类型（0-团长返利、1-误差退款、2-其他费用）")
    private String costType;

    @ApiModelProperty(value = "费用金额")
    private BigDecimal costAmount;

    @ApiModelProperty(value = "订单id")
    private String skuPackageOrderId;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "支付状态（0-待支付，1-已支付）")
    private String payStatus;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

}
