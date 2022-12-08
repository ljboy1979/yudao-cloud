package cn.acsm.module.transaction.order.controller.admin.settleinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
@ApiModel(value = "管理后台 - 订单结账 Excel 导出 Request VO", description = "参数和 SettleInfoPageReqVO 是一致的")
@Data
public class SettleInfoExportReqVO {

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
