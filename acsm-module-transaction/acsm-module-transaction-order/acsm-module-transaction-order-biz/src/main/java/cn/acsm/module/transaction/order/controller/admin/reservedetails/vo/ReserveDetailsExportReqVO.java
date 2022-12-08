package cn.acsm.module.transaction.order.controller.admin.reservedetails.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 订单预定详情 Excel 导出 Request VO", description = "参数和 ReserveDetailsPageReqVO 是一致的")
@Data
public class ReserveDetailsExportReqVO {

    @ApiModelProperty(value = "商品名称")
    private String commodityName;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
