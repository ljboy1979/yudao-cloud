package cn.acsm.module.transaction.order.controller.admin.orderdetail.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 订单详情分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OrderDetailPageReqVO extends PageParam {

    @ApiModelProperty(value = "货架名称")
    private String shelvesName;

    @ApiModelProperty(value = "规格名称")
    private String specificationName;

    @ApiModelProperty(value = "配送时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] deliveryTime;

}
