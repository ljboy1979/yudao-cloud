package cn.acsm.module.transaction.order.controller.admin.sartinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
@ApiModel(value = "管理后台 - 购物车 Excel 导出 Request VO", description = "参数和 SartInfoPageReqVO 是一致的")
@Data
public class SartInfoExportReqVO {

    @ApiModelProperty(value = "货架id")
    private String shelvesId;

    @ApiModelProperty(value = "货架名称")
    private String shelvesName;

    @ApiModelProperty(value = "付款状态 0 未付款  1 已付款 2 已退款")
    private String payStatus;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
