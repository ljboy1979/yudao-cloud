package cn.acsm.module.transaction.order.controller.admin.reserveinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
@ApiModel(value = "管理后台 - 预定订单 Excel 导出 Request VO", description = "参数和 ReserveInfoPageReqVO 是一致的")
@Data
public class ReserveInfoExportReqVO {

    @ApiModelProperty(value = "支付方式 0 账单 1 微信  ")
    private String payType;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
